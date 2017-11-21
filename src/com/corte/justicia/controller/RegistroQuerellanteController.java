/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Mari
 */
public class RegistroQuerellanteController implements Initializable {

    @FXML
    private JFXButton backArrow;

    @FXML
    private JFXTextField nameField;

    @FXML
    private Label errorLabelNombre;

    @FXML
    private JFXTextField surnameField;

    @FXML
    private Label errorLabelApellido;

    @FXML
    private JFXTextField secondSurnameField;

    @FXML
    private JFXTextField phoneNumField;

    @FXML
    private Label errorLabelTelefono;

    @FXML
    private JFXTextField direccionField;

    @FXML
    private Label errorLabelCedula;

    @FXML
    private JFXTextField cedulaField;
    
    @FXML
    private Label errorLabelDireccion;

    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void goBack(MouseEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabelNombre.setVisible(false);
        errorLabelApellido.setVisible(false);
        errorLabelTelefono.setVisible(false);
        errorLabelCedula.setVisible(false);
        errorLabelDireccion.setVisible(false);
    }

}
