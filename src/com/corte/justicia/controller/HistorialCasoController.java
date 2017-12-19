/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import gestor.GestorCaso;
import gestor.GestorJuez;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import objetos.Caso;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class HistorialCasoController implements Initializable {
    private static int idCaso;
    
    @FXML
    private TableView<Caso> casos;

    @FXML
    private TableColumn<Caso, LocalDate> fecha;

    @FXML
    private TableColumn<Caso, String> estado;

    @FXML
    private TableColumn<Caso, String> comentarioEstado;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estadoNombre"));    
        comentarioEstado.setCellValueFactory(new PropertyValueFactory<>("comentarioEstado")); 
        casos.getItems().setAll(getCasosByJuez());
    } 

    @FXML
    void exitApp(MouseEvent event) {
         closeCurrentWindow();
    }
    
    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) casos.getScene().getWindow();
        stage.close();
    }  
    
    public ArrayList<Caso> getCasosByJuez() {

        GestorCaso gestor = new GestorCaso();

        ArrayList<Caso> casos = null;

        try {
            casos = gestor.getHistorialByCaso(idCaso);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return casos;

    }
    public void setUsername(int idCaso){
        this.idCaso = idCaso;
    }
    
       
    
}
