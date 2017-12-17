/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import gestor.GestorQuerellante;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class QuerellanteLoginController implements Initializable {

    
    @FXML
    private JFXButton backArrow;

    @FXML
    private Label errorLabel;

    @FXML
    private JFXTextField usuario;

    
    @FXML
    private JFXButton logInBtn;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets the visibility to non visible
        errorLabel.setVisible(false);
        //default Button is the button 
        //that receives a keyboard VK_ENTER press, if no other node in the scene consumes it.
        logInBtn.setDefaultButton(true);
    }
    
    

    /**
     * Login del juez
     *
     * @param event tipo ActionEvent
     */
    @FXML
    void loginJuez(ActionEvent event) throws IOException, Exception {
        String username = this.usuario.getText();
        
        GestorQuerellante gestor = new GestorQuerellante();
        PerfilQuerellanteController perfil = new PerfilQuerellanteController();
        
        String nombre = gestor.nombreByCedula(username);
        
        if (gestor.inicioSesion(username) != null ) {
            errorLabel.setVisible(false);
            Validacion.greenInputTextField(usuario);
            perfil.setUsername(nombre);
            
            
            irPerfilQuerellante();
            closeCurrentWindow();
        }else {
            Validacion.redInputTextField(usuario);
            errorLabel.setVisible(true);

        }
        
    }
        
    
    void irPerfilQuerellante() throws IOException{
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
    
    /**
     * Cierra la aplicacion
     *
     * @param event tipo mouseevent
     */
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    /**
     * Cierra la vista actual y se devuelve a la vista del main
     *
     * @param event tipo mouseevent
     * @throws IOException
     */
    @FXML
    void openMainScreen(MouseEvent event) throws IOException {
        closeCurrentWindow();
        mainScreen();
    }

    /**
     * Llama a la vista del main
     *
     * @throws IOException
     */
    @FXML
    void mainScreen() throws IOException {
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

    /**
     * Cierra la vista/ventana actual
     */
    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) backArrow.getScene().getWindow();
        stage.close();
    }
    
    
    
}
