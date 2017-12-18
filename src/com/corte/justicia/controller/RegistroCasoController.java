/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import gestor.GestorCaso;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class RegistroCasoController implements Initializable {
    
    @FXML
    private JFXButton backArrow, btnRegistrar, btnAceptar;

    @FXML
    private JFXTextField  cedulaQuerellante;

    @FXML
    private Label exitoLabel, errorLabelCedulaQuerellante, errorLabelDescripcion, errorNoExiste;

    @FXML
    private JFXTextArea desripcion;

    @FXML
    private AnchorPane exitoBanner;

    
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void exitSuccessBanner(ActionEvent event) throws IOException {
        FXUtils.fadeOutBanner(exitoBanner);
        closeCurrentWindow();
        irPerfilSecretario();  
    }

    @FXML
    void registrar(ActionEvent event) throws IOException, Exception {
        
        GestorCaso gestor = new GestorCaso();
        String descripcion = this.desripcion.getText();
        String cedulaQuere = this.cedulaQuerellante.getText();
        int estado = 1;  
        LocalDate fecha = LocalDate.now();
        int randomId = gestor.setRandomJuezId();
        String comentarioInicial = "Caso recibido";
        
        String numeroCaso = cedulaQuere + "-" + getNumeroCasoString() ;
        if (!isEmptyInput() && gestor.querellanteIDByCedula(cedulaQuere) != null) {
            
            Querellante quere = gestor.querellanteIDByCedula(cedulaQuere);
  
            
            gestor.registrarCaso(numeroCaso, quere.getId_querellante(), randomId ,estado,fecha,descripcion, comentarioInicial);
            
            errorLabelFalse();
            turnGreenInput();
            Validacion.sucessBanner(exitoBanner, exitoLabel);
            
       
        }else if(gestor.querellanteIDByCedula(cedulaQuere) == null){      
            styleQuerellanteField(cedulaQuere);
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
    
    
    
    void styleQuerellanteField(String cedulaQuere) throws Exception{
        GestorCaso gestor = new GestorCaso();
         
         if (gestor.querellanteIDByCedula(cedulaQuere) == null) {
            Validacion.redInputTextField(this.cedulaQuerellante);
            errorNoExiste.setVisible(true);
        } else {
            Validacion.greenInputTextField(this.cedulaQuerellante);
            errorNoExiste.setVisible(false);
        }
    }
    
    void styleInputError() {


        String descripcion = this.desripcion.getText();
        String cedulaQuere = this.cedulaQuerellante.getText();
        //JFXTextField

        
        if (cedulaQuere.isEmpty()) {
            Validacion.redInputTextField(this.cedulaQuerellante);
            errorLabelCedulaQuerellante.setVisible(true);
        } else {
            Validacion.greenInputTextField(this.cedulaQuerellante);
            errorLabelCedulaQuerellante.setVisible(false);
        }

        if (descripcion.isEmpty()) {
            Validacion.redInputTextAreaField(this.desripcion);
            errorLabelDescripcion.setVisible(true);
        } else {
            Validacion.greenInputTextAreaField(this.desripcion);
            errorLabelDescripcion.setVisible(false);
        }

    }
    
    void turnGreenInput() {
    
        Validacion.greenInputTextField(cedulaQuerellante);
        Validacion.greenInputTextAreaField(desripcion);
    }
    
    void errorLabelFalse() {
        errorNoExiste.setVisible(false);
        errorLabelCedulaQuerellante.setVisible(false);

        errorLabelDescripcion.setVisible(false);
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
    }
    
    boolean isEmptyInput() {


        String descripcion = this.desripcion.getText();
        String cedulaQuere = this.cedulaQuerellante.getText();
        String[] inputs = { descripcion, cedulaQuere};

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
    void goBack(MouseEvent event) throws IOException {
        irPerfilSecretario();
    }
    
    
    void irPerfilSecretario() throws IOException{
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/PerfilSecretario.fxml"));
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
    
}
