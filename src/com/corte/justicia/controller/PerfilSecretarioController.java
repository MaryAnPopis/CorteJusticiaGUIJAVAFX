/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class PerfilSecretarioController implements Initializable {

    @FXML
    private JFXButton btnJuezRegistro;

    @FXML
    private JFXButton btnQuereRegistro;

    @FXML
    private JFXButton btnCasoRegistro;

    @FXML
    private Label nombreSecretario;
    
    private static String username;
    
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void irCasoRegistro(MouseEvent event) throws IOException {

    }

    @FXML
    void irJuezRegistro(MouseEvent event) throws IOException {
        String path = "RegistroJuez";
        abrirView(path);
    }

    @FXML
    void irQuerellanteRegistro(MouseEvent event) throws IOException {
        String path = "RegistroQuerellante";
        abrirView(path);
    }
    
    void abrirView(String path) throws IOException{
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/"+path+".fxml"));
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
    void cerrarSesion(MouseEvent event) throws IOException {
        String path = "Main";
        abrirView(path);
    }
    
    /**
     * Cierra la vista/ventana actual
     */
    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) btnCasoRegistro.getScene().getWindow();
        stage.close();
    }  
    
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreSecretario.setText(this.username);
    }

}
