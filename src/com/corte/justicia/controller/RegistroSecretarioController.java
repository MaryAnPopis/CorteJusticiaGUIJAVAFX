package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegistroSecretarioController implements Initializable {

    @FXML
    private Label errorLabelNombre, errorLabelApellido, errorLabelTelefono, errorLabelUsuario,
            errorLabelContrasenna, errorLabelNoMatch,exitoLabel;
    
    @FXML
    private JFXButton backArrow, btnRegistrar;
    
    @FXML
    private JFXTextField nameField, surnameField,secondSurnameField,phoneNumField,usernameField;
    
    @FXML
    private JFXPasswordField passwordField, confirmPass;
    
    @FXML
    private AnchorPane exitoBanner;
    
    
    @FXML
    void registrarSecretario(ActionEvent event) {
        sucessBanner();
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabelNombre.setVisible(false);
        errorLabelApellido.setVisible(false);
        errorLabelTelefono.setVisible(false);
        errorLabelUsuario.setVisible(false);
        errorLabelContrasenna.setVisible(false);
        errorLabelNoMatch.setVisible(false);
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
        btnRegistrar.setDefaultButton(true);
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
    
    @FXML
    void quitExitBanner(ActionEvent event) {
        
        FXUtils.fadeOutBanner(exitoBanner);

    }
    
    void sucessBanner(){
        exitoBanner.setVisible(true);
        FXUtils.fadeInBanner(exitoBanner);
        exitoLabel.setVisible(true);
    }
}
