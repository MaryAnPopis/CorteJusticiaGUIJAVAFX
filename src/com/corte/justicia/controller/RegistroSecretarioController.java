package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
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
            errorLabelContrasenna, errorLabelNoMatch,exitoLabel,errorLabelContrasenna2;
    
    @FXML
    private JFXButton backArrow, btnRegistrar;
    
    @FXML
    private JFXTextField nameField, surnameField,secondSurnameField,phoneNumField,usernameField;
    
    @FXML
    private JFXPasswordField passwordField, confirmPass;
    
    @FXML
    private AnchorPane exitoBanner;
    
    /**
     * Registra un secretario
     * @param event 
     */
    @FXML
    void registrarSecretario(ActionEvent event) {
        if (!Validacion.isPasswordCorrect(confirmPass, passwordField, errorLabelNoMatch) && !isEmptyInput()) {
            System.out.println("bien");
            errorLabelFalse();
            turnGreenInput();
            Validacion.sucessBanner(exitoBanner, exitoLabel);
        } else {
            styleInputError();
            Validacion.isPasswordCorrect(confirmPass, passwordField, errorLabelNoMatch);
            System.out.println("error");
        }
    }
    
    /**
     * Agrega estilos de color verde al los input
     */
    void turnGreenInput() {
        Validacion.greenInputTextField(nameField);
        Validacion.greenInputTextField(surnameField);
        Validacion.greenInputTextField(phoneNumField);
        Validacion.greenInputTextField(usernameField);
        Validacion.greenInputPasswordField(passwordField);
        Validacion.greenInputPasswordField(confirmPass);
  
    }
    
    /**
     * Añade un color y label al input dependiendo si
     * esta lleno o vacio
     */
    void styleInputError() {

        String nombre = nameField.getText();
        String apellido1 = surnameField.getText();
        String telefono = phoneNumField.getText();
        String usuario = usernameField.getText();
        String contrasenna = passwordField.getText();
        String contrasenna2 = confirmPass.getText();

        //JFXPasswordField
        if (contrasenna.isEmpty()) {
            Validacion.redInputPasswordField(passwordField);
            errorLabelContrasenna.setVisible(true);
        } else {
            Validacion.greenInputPasswordField(passwordField);
            errorLabelContrasenna.setVisible(false);
        }

        if (contrasenna2.isEmpty()) {
            Validacion.redInputPasswordField(confirmPass);
            errorLabelContrasenna2.setVisible(true);
        } else {
            Validacion.greenInputPasswordField(confirmPass);
            errorLabelContrasenna2.setVisible(false);
        }
        //JFXTextField
        if (nombre.isEmpty()) {
            Validacion.redInputTextField(nameField);
            errorLabelNombre.setVisible(true);
        } else {
            Validacion.greenInputTextField(nameField);
            errorLabelNombre.setVisible(false);
        }

        if (apellido1.isEmpty()) {
            Validacion.redInputTextField(surnameField);
            errorLabelApellido.setVisible(true);
        } else {
            Validacion.greenInputTextField(surnameField);
            errorLabelApellido.setVisible(false);
        }

        Validacion.greenInputTextField(secondSurnameField);

        if (telefono.isEmpty()) {
            Validacion.redInputTextField(phoneNumField);
            errorLabelTelefono.setVisible(true);
        } else {
            Validacion.greenInputTextField(phoneNumField);
            errorLabelTelefono.setVisible(false);
        }

        if (usuario.isEmpty()) {
            Validacion.redInputTextField(usernameField);
            errorLabelUsuario.setVisible(true);
        } else {
            Validacion.greenInputTextField(usernameField);
            errorLabelUsuario.setVisible(false);
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabelFalse();
        btnRegistrar.setDefaultButton(true);
    }
    
    
    /**
     * Este metodo revisa los inputs vacios
     * @return boolean true si hay algun input en blanco
     */
    boolean isEmptyInput() {

        String nombre = nameField.getText();
        String apellido1 = surnameField.getText();
        String telefono = phoneNumField.getText();
        String usuario = usernameField.getText();
        String contrasenna = passwordField.getText();
        String contrasenna2 = confirmPass.getText();

        String[] inputs = {nombre, apellido1, telefono, usuario, contrasenna, contrasenna2};

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Set los label a false para que no se vean
     */
    void errorLabelFalse() {
        errorLabelNombre.setVisible(false);
        errorLabelApellido.setVisible(false);
        errorLabelTelefono.setVisible(false);
        errorLabelUsuario.setVisible(false);
        errorLabelContrasenna.setVisible(false);
        errorLabelContrasenna2.setVisible(false);
        errorLabelNoMatch.setVisible(false);
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
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
    
    /**
     * Cierra el alert de succes
     * @param event boton para cerra el alert
     */
    @FXML
    void exitSuccessBanner(ActionEvent event) {
        
        FXUtils.fadeOutBanner(exitoBanner);

    }
    
    
}
