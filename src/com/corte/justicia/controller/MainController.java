/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.jfoenix.controls.JFXButton;
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
 * Vista del main
 *
 * @version 1.0 noviembre 14, 2017
 * @author Mariam Domínguez
 */
public class MainController implements Initializable {

    @FXML
    private Label exitBtn;
    @FXML
    private JFXButton juezBtn;

    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    /**
     * Cieera la ventana actual y abre el login del juez
     *
     * @param event tipo mouseevent
     * @throws IOException
     */
    @FXML
    void goJuezLogin(MouseEvent event) throws IOException {
        closeCurrentWindow();
        openjuezLogin();
    }

    /**
     * Abre la vista del login del juez
     *
     * @throws IOException
     */
    @FXML
    void openjuezLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/JuezLogin.fxml"));
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

    /**
     * Abre la vista del login del secretario de la corte
     *
     * @throws IOException
     */
    @FXML
    void openSecretarioLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/SecretarioLogin.fxml"));
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
    
    /**
     * Abre la vista del login del querellante
     *
     * @throws IOException
     */
    @FXML
    void openQuerellanteLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/QuerellanteLogin.fxml"));
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
    
    /**
     * Cierra la ventana actual
     */
    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) juezBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void goQuerellanteLogin(MouseEvent event) throws IOException {
        closeCurrentWindow();
        openQuerellanteLogin();
    }

    @FXML
    void goSecretarioLogin(MouseEvent event) throws IOException {
        closeCurrentWindow();
        openSecretarioLogin();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
