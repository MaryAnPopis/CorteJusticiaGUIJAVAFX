/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import gestor.GestorCaso;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import objetos.Querellante;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class RegistroCasoQuerellanteController implements Initializable {

     @FXML
    private JFXButton backArrow, btnRegistrar, btnAceptar;

//    @FXML
//    private JFXTextField numero;

    @FXML
    private Label exitoLabel, errorLabelDescripcion;

    @FXML
    private JFXTextArea desripcion;

    @FXML
    private AnchorPane exitoBanner;
    private static String cedulaQuere;
    
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void exitSuccessBanner(ActionEvent event) throws IOException {
        FXUtils.fadeOutBanner(exitoBanner);
        closeCurrentWindow();
        irPerfilSecretari();
    }

    @FXML
    void registrar(ActionEvent event) throws IOException, Exception {
        
        GestorCaso gestor = new GestorCaso();
        
        String descripcion = this.desripcion.getText();
        String cedulaQuerellante = this.cedulaQuere;
        int estado = 1;  
        LocalDate fecha = LocalDate.now();
        int randomId = gestor.setRandomJuezId();
        String comentarioInicial = "Caso recibido";
        String numeroCaso = cedulaQuerellante + "-" + getNumeroCasoString() ;
        if (!isEmptyInput() && gestor.querellanteIDByCedula(cedulaQuerellante) != null) {
            
            Querellante quere = gestor.querellanteIDByCedula(cedulaQuerellante);
  
            
            gestor.registrarCaso(numeroCaso, quere.getId_querellante(), randomId ,estado,fecha,descripcion, comentarioInicial);
            
            errorLabelFalse();
            turnGreenInput();
            Validacion.sucessBanner(exitoBanner, exitoLabel);
            
       
        }else {
            styleInputError();
        }
    }
    
    
    public String getNumeroCasoString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    
    void styleInputError() {

//        String numeroCaso = this.numero.getText();
        String descripcion = this.desripcion.getText();

        //JFXTextField
//        if (numeroCaso.isEmpty()) {
//            Validacion.redInputTextField(this.numero);
//            errorLabelNumero.setVisible(true);
//        } else {
//            Validacion.greenInputTextField(this.numero);
//            errorLabelNumero.setVisible(false);
//        }
//

        if (descripcion.isEmpty()) {
            Validacion.redInputTextAreaField(this.desripcion);
            errorLabelDescripcion.setVisible(true);
        } else {
            Validacion.greenInputTextAreaField(this.desripcion);
            errorLabelDescripcion.setVisible(false);
        }

    }
    
    void turnGreenInput() {
        Validacion.greenInputTextAreaField(desripcion);
    }
    
    void errorLabelFalse() {
        errorLabelDescripcion.setVisible(false);
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
    }
    
    boolean isEmptyInput() {

        String descripcion = this.desripcion.getText();
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
    
     @FXML
    void irPerfil(MouseEvent event) throws IOException {
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/PerfilQuerellante.fxml"));
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
    

    void irPerfilSecretari() throws IOException{
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/PerfilQuerellante.fxml"));
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        errorLabelFalse();
        btnRegistrar.setDefaultButton(true);
    }      
    
    
    public void setCedula(String cedula) {
        this.cedulaQuere = cedula;
    }


}
