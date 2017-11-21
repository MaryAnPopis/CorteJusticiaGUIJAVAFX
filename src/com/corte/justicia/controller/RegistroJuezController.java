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

    @FXML
    void registrarJuez(ActionEvent event) {

        if (!Validacion.passMatch(confirmPass, passwordField, errorLabelNoMatch) && !isBlankInput()) {

            errorLabelFalse();
            rigthValidationBunk();
            sucessBanner();
        } else {
            redInputs();
            Validacion.passMatch(confirmPass, passwordField, errorLabelNoMatch);

        }

    }
    
    @FXML
    void quitExitBanner(ActionEvent event) {
        
        FXUtils.fadeOutBanner(exitoBanner);

    }

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

    void rigthValidationBunk() {
        Validacion.rightLabelTextField(nameField);
        Validacion.rightLabelTextField(surnameField);
        Validacion.rightLabelTextField(phoneNumField);
        Validacion.rightLabelTextField(usernameField);
        Validacion.rightLabelTextField(salaField);
        Validacion.rightLabelTextField(cedulaField);
        Validacion.rightLabelPasswordField(passwordField);
        Validacion.rightLabelPasswordField(confirmPass);

        
    }
    
    void sucessBanner(){
        exitoBanner.setVisible(true);
        FXUtils.fadeInBanner(exitoBanner);
        exitoLabel.setVisible(true);
    }

    void redInputs() {

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
            Validacion.errorLabelPasswordField(passwordField);
            errorLabelContrasenna.setVisible(true);
        } else {
            Validacion.rightLabelPasswordField(passwordField);
            errorLabelContrasenna.setVisible(false);
        }

        if (contrasenna2.isEmpty()) {
            Validacion.errorLabelPasswordField(confirmPass);
            errorLabelContrasenna2.setVisible(true);
        } else {
            Validacion.rightLabelPasswordField(confirmPass);
            errorLabelContrasenna2.setVisible(false);
        }
        //JFXTextField
        if (nombre.isEmpty()) {
            Validacion.errorLabelTextField(nameField);
            errorLabelNombre.setVisible(true);
        } else {
            Validacion.rightLabelTextField(nameField);
            errorLabelNombre.setVisible(false);
        }

        if (apellido1.isEmpty()) {
            Validacion.errorLabelTextField(surnameField);
            errorLabelApellido.setVisible(true);
        } else {
            Validacion.rightLabelTextField(surnameField);
            errorLabelApellido.setVisible(false);
        }

        Validacion.rightLabelTextField(secondSurnameField);

        if (telefono.isEmpty()) {
            Validacion.errorLabelTextField(phoneNumField);
            errorLabelTelefono.setVisible(true);
        } else {
            Validacion.rightLabelTextField(phoneNumField);
            errorLabelTelefono.setVisible(false);
        }

        if (usuario.isEmpty()) {
            Validacion.errorLabelTextField(usernameField);
            errorLabelUsuario.setVisible(true);
        } else {
            Validacion.rightLabelTextField(usernameField);
            errorLabelUsuario.setVisible(false);
        }

        if (sala.isEmpty()) {
            Validacion.errorLabelTextField(salaField);
            errorLabelSala.setVisible(true);
        } else {
            Validacion.rightLabelTextField(salaField);
            errorLabelSala.setVisible(false);
        }

        if (cedula.isEmpty()) {
            Validacion.errorLabelTextField(cedulaField);
            errorLabelCedula.setVisible(true);
        } else {
            Validacion.rightLabelTextField(cedulaField);
            errorLabelCedula.setVisible(false);
        }

        if (contrasenna.isEmpty()) {
            Validacion.errorLabelPasswordField(passwordField);
            errorLabelContrasenna.setVisible(true);
        } else {
            Validacion.rightLabelPasswordField(passwordField);
            errorLabelContrasenna.setVisible(false);
        }

        if (contrasenna2.isEmpty()) {
            Validacion.errorLabelPasswordField(confirmPass);
            errorLabelContrasenna2.setVisible(true);
        } else {
            Validacion.rightLabelPasswordField(confirmPass);
            errorLabelContrasenna2.setVisible(false);
        }
    }

    boolean isBlankInput() {

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

    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void goBack(MouseEvent event) {

    }
}
