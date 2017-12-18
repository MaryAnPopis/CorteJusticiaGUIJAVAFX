/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import gestor.GestorCaso;
import gestor.GestorJuez;
import gestor.GestorQuerellante;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import objetos.Caso;
import objetos.Juez;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class PerfilQuerellanteController implements Initializable {

    @FXML
    private Label querellanteLabel;

    @FXML
    private TableView<Caso> casos;

    @FXML
    private TableColumn<Caso, String> numero;

    @FXML
    private TableColumn<Caso, LocalDate> fecha;

    @FXML
    private TableColumn<Caso, Juez> juez;

    @FXML
    private TableColumn<Caso, String> estado;

    @FXML
    private TableColumn<Caso, String> descripcion;
    
    @FXML
    private TableColumn<Caso, String> comentarioEstado;

    private static String username;
    private static String cedulaQuere;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        juez.setCellValueFactory(new PropertyValueFactory<>("mediador"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estadoNombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));   
        comentarioEstado.setCellValueFactory(new PropertyValueFactory<>("comentarioEstado")); 
        casos.getItems().setAll(getCasosByQuerellante());

        //--------------------------------------
        querellanteLabel.setText(this.username);
        RegistroCasoQuerellanteController registroCaso = new RegistroCasoQuerellanteController();
        registroCaso.setCedula(cedulaQuere);
    }

    public ArrayList<Caso> getCasosByQuerellante() {

        GestorCaso gestor = new GestorCaso();
        GestorQuerellante gestorQu = new GestorQuerellante();
        ArrayList<Caso> casos = null;

        try {
            casos = gestor.getCasosByQuerellante(gestorQu.getQuerellanteIdByCedula(this.cedulaQuere));

        } catch (Exception e) {
            System.out.println(e);
        }

        return casos;

    }

    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) querellanteLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cerrarSesion(MouseEvent event) throws IOException {
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/Main.fxml"));
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

    public void setUsername(String cedula) {
        this.username = cedula;
    }

    public void setCedula(String cedula) {
        this.cedulaQuere = cedula;
    }

    public String getCedulaQuere() {
        return cedulaQuere;
    }
    
    @FXML
    void registrarCaso(MouseEvent event) throws IOException {
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/RegistroCasoQuerellante.fxml"));
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
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

}
