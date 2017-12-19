/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.jfoenix.controls.JFXTextArea;
import gestor.GestorCaso;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class EstadoDetalleController implements Initializable {
     @FXML
    private Label estado;

    @FXML
    private JFXTextArea detalleResolucion;
    
    
    private static int idCaso;
    private static int idEstado;
    
    
    

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
     /**
     * Cierra la vista/ventana actual
     */
    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) detalleResolucion.getScene().getWindow();
        stage.close();
    }  
    
    @FXML
    void exitApp(MouseEvent event) {
        closeCurrentWindow();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GestorCaso gestor = new GestorCaso();
        
         try {
            String estadoNombre = gestor.getEstadoById(idEstado);
            String comentario =    gestor.getComentarioByIdCaso(idCaso);
//            detalleResolucion.setDisable(true);
            detalleResolucion.setEditable(false);
            detalleResolucion.setFocusTraversable(false);
            detalleResolucion.setText(comentario);
            estado.setText(estadoNombre);
         } catch (Exception ex) {
             Logger.getLogger(EstadoDetalleController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }    
    
}
