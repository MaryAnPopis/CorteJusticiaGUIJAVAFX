/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class PerfilQuerellanteController implements Initializable {
    @FXML
    private Label querellanteLabel;
    
    private static String username;
    
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
    
    public void setUsername(String username){
        this.username = username;
    }
    
@FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        querellanteLabel.setText(this.username);
    }    
    
}
