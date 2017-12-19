/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import gestor.GestorCaso;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class EstadoRevisionController implements Initializable {

   @FXML
    private JFXButton backArrow;

    @FXML
    private JFXRadioButton redactado;

    @FXML
    private JFXTextArea detalle;

    @FXML
    private Label errorLabelComentario, exitoLabel, errorRadioButton;

    @FXML
    private JFXButton btnAceptarr, btnCancelar;

    @FXML
    private AnchorPane exitoBanner;
    @FXML
    private ToggleGroup estadoGrupo;

    private static int idCaso;


     @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void exitEstado(ActionEvent event) throws IOException {
        closeCurrentWindow();
        irPerfilJuez();
    }

    @FXML
    void exitSuccessBanner(ActionEvent event) throws IOException {
        FXUtils.fadeOutBanner(exitoBanner);
        closeCurrentWindow();
        irPerfilJuez();
    }

    void irPerfilJuez() throws IOException {
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/PerfilJuez.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        root.setStyle("-fx-background-color: transparent;");

        // set icon
        FXUtils.displayIcon(stage);

        //set draggable window
        FXUtils.makeDraggableWindow(root, stage);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        irPerfilJuez();
    }

    @FXML
    void registrarEstado(ActionEvent event) throws SQLException, Exception {
        String idSelected;
        RadioButton radioSelected = (RadioButton) estadoGrupo.getSelectedToggle();
        if (radioSelected == null) {
            errorRadioButton.setVisible(true);
        } else {
            errorRadioButton.setVisible(false);
            idSelected = radioSelected.getId();
            int idEstado;
            LocalDate fechaCambio = LocalDate.now();
            String comentario = this.detalle.getText();
            GestorCaso gestor = new GestorCaso();
            if (!isEmptyInput() && estadoGrupo.getSelectedToggle() != null) {

                switch (idSelected) {
                    case "redactado":
                        idEstado = 5;
                        gestor.modificarEstado(idEstado, comentario, idCaso);
                        gestor.registrarHistorial(comentario, idEstado, idCaso, fechaCambio);
                        break;
                    default:
                        gestor.modificarEstado(1, comentario, idCaso);
                        gestor.registrarHistorial(comentario, 1, idCaso, fechaCambio);
                        break;
                }

                errorLabelFalse();
                turnGreenInput();
                Validacion.sucessBanner(exitoBanner, exitoLabel);
            } else {
                styleInputError();
            }

        }

    }

    void styleInputError() {

        String descripcion = this.detalle.getText();

        //JFXTextField
        if (descripcion.isEmpty()) {
            Validacion.redInputTextAreaField(this.detalle);
            errorLabelComentario.setVisible(true);
        } else {
            Validacion.greenInputTextAreaField(this.detalle);
            errorLabelComentario.setVisible(false);
        }

    }

    void turnGreenInput() {

        Validacion.greenInputTextAreaField(detalle);
    }

    boolean isEmptyInput() {

        String descripcion = this.detalle.getText();

        String[] inputs = {descripcion};

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) backArrow.getScene().getWindow();
        stage.close();
    }

    public int getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    void errorLabelFalse() {
        errorRadioButton.setVisible(false);
        errorLabelComentario.setVisible(false);
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        errorLabelFalse();
    }    
    
}
