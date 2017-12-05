
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @version 1.0 noviembre 21, 2017
 * @author Mariam Domínguez
 */
public class RegistroQuerellanteController implements Initializable {

    @FXML
    private JFXTextField nameField, surnameField, secondSurnameField, phoneNumField,
            direccionField, cedulaField;

    @FXML
    private Label errorLabelNombre, errorLabelApellido, errorLabelTelefono, errorLabelCedula,
            errorLabelDireccion, exitoLabel;

    @FXML
    private AnchorPane exitoBanner;

    @FXML
    private JFXButton backArrow, btnAceptar, registroBtn;

    /**
     * Registra el querellante
     *
     * @param event
     */
    @FXML
    void registrarQuerellante(ActionEvent event) {

        if (!isEmptyInput()) {

            errorLabelFalse();
            turnGreenInput();
            Validacion.sucessBanner(exitoBanner, exitoLabel);
        } else {
            styleInputError();

        }

    }

    /**
     * Añade un color y label al input dependiendo si esta lleno o vacio
     */
    void styleInputError() {

        String nombre = nameField.getText();
        String apellido1 = surnameField.getText();
        String telefono = phoneNumField.getText();
        String direccion = direccionField.getText();
        String cedula = cedulaField.getText();

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

        if (direccion.isEmpty()) {
            Validacion.redInputTextField(direccionField);
            errorLabelDireccion.setVisible(true);
        } else {
            Validacion.greenInputTextField(direccionField);
            errorLabelDireccion.setVisible(false);
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
     * Agrega estilos de color verde al los input
     */
    void turnGreenInput() {
        Validacion.greenInputTextField(nameField);
        Validacion.greenInputTextField(surnameField);
        Validacion.greenInputTextField(phoneNumField);
        Validacion.greenInputTextField(cedulaField);
        Validacion.greenInputTextField(direccionField);
    }

    /**
     * Este metodo revisa los inputs vacios
     *
     * @return boolean true si hay algun input en blanco
     */
    boolean isEmptyInput() {

        String nombre = nameField.getText();
        String apellido1 = surnameField.getText();
        String telefono = phoneNumField.getText();
        String direccion = direccionField.getText();
        String cedula = cedulaField.getText();

        String[] inputs = {nombre, apellido1, telefono, cedula, direccion};

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cierra el alert de succes
     *
     * @param event boton para cerra el alert
     */
    @FXML
    void exitSuccessBanner(ActionEvent event) {
        FXUtils.fadeOutBanner(exitoBanner);
        
    }

    /**
     * Cierra la aplicacion
     *
     * @param event
     */
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void goBack(MouseEvent event) {

    }

    /**
     * Set los label a false para que no se vean
     */
    void errorLabelFalse() {
        errorLabelNombre.setVisible(false);
        errorLabelApellido.setVisible(false);
        errorLabelTelefono.setVisible(false);
        errorLabelCedula.setVisible(false);
        errorLabelDireccion.setVisible(false);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        errorLabelFalse();
        registroBtn.setDefaultButton(true);
        exitoLabel.setVisible(false);
        exitoBanner.setVisible(false);
        
    }

}
