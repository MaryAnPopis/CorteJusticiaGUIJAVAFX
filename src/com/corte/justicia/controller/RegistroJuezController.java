package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegistroJuezController implements Initializable {

    @FXML
    private Label errorLabelNombre, errorLabelApellido, errorLabelTelefono, errorLabelUsuario,
            errorLabelContrasenna, errorLabelNoMatch, errorLabelSala, errorLabelCedula, errorLabelContrasenna2,
            exitoLabel;

    @FXML
    private JFXTextField nameField, surnameField, secondSurnameField, phoneNumField, usernameField,
            cedulaField, salaField;

    @FXML
    private JFXPasswordField passwordField, confirmPass;

    @FXML
    private JFXButton backArrow, btnAceptar, registroBtn;

    @FXML
    private AnchorPane exitoBanner;
    
    
    /**
     * Registra el juez
     * @param event 
     */
    @FXML
    void registrarJuez(ActionEvent event) {

        if (!Validacion.isPasswordCorrect(confirmPass, passwordField, errorLabelNoMatch) && !isEmptyInput()) {

            errorLabelFalse();
            turnGreenInput();
            Validacion.sucessBanner(exitoBanner, exitoLabel);
        } else {
            styleInputError();
            Validacion.isPasswordCorrect(confirmPass, passwordField, errorLabelNoMatch);

        }

    }
    
    
    /**
     * Cierra el alert de succes
     * @param event boton para cerra el alert
     */
    @FXML
    void exitSuccessBanner(ActionEvent event) {
        
        FXUtils.fadeOutBanner(exitoBanner);
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
        errorLabelNoMatch.setVisible(false);
        errorLabelSala.setVisible(false);
        errorLabelCedula.setVisible(false);
        errorLabelContrasenna2.setVisible(false);
    }
    
    
    /**
     * Agrega estilos de color verde al los input
     */
    void turnGreenInput() {
        Validacion.greenInputTextField(nameField);
        Validacion.greenInputTextField(surnameField);
        Validacion.greenInputTextField(phoneNumField);
        Validacion.greenInputTextField(usernameField);
        Validacion.greenInputTextField(salaField);
        Validacion.greenInputTextField(cedulaField);
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
        String cedula = cedulaField.getText();
        String sala = salaField.getText();
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

        if (sala.isEmpty()) {
            Validacion.redInputTextField(salaField);
            errorLabelSala.setVisible(true);
        } else {
            Validacion.greenInputTextField(salaField);
            errorLabelSala.setVisible(false);
        }

        if (cedula.isEmpty()) {
            Validacion.redInputTextField(cedulaField);
            errorLabelCedula.setVisible(true);
        } else {
            Validacion.greenInputTextField(cedulaField);
            errorLabelCedula.setVisible(false);
        }

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
        String cedula = cedulaField.getText();
        String sala = salaField.getText();
        String contrasenna = passwordField.getText();
        String contrasenna2 = confirmPass.getText();

        String[] inputs = {nombre, apellido1, telefono, usuario, cedula,
            sala, contrasenna, contrasenna2};

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabelFalse();
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
        registroBtn.setDefaultButton(true);
        btnAceptar.setDefaultButton(true);
    }
    /**
     * Cierra la aplicacion
     * @param event 
     */
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void goBack(MouseEvent event) {

    }
}
