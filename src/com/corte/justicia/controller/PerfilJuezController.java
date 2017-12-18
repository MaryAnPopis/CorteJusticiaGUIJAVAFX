/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import gestor.GestorCaso;
import gestor.GestorJuez;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import objetos.Caso;
import objetos.Querellante;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class PerfilJuezController implements Initializable {
    
    @FXML
    private Label juezLabel;
    
    private static String username;
    private static int id_juez;
    
    @FXML
    private TableView<Caso> casos;
    @FXML
    private TableColumn<Caso, String> numero;

    @FXML
    private TableColumn<Caso, LocalDate> fecha;

    @FXML
    private TableColumn<Caso, Querellante> querellante;

    @FXML
    private TableColumn<Caso, String> estado;

    @FXML
    private TableColumn<Caso, String> descripcion;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        numero.setCellValueFactory(new PropertyValueFactory<Caso, String>("numero"));
        fecha.setCellValueFactory(new PropertyValueFactory<Caso, LocalDate>("fecha"));
        querellante.setCellValueFactory(new PropertyValueFactory<Caso, Querellante>("demandante"));
        estado.setCellValueFactory(new PropertyValueFactory<Caso, String>("estadoNombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory<Caso, String>("descripcion"));       
        casos.getItems().setAll(getCasosByJuez());
        
        
        //----------------------------
        juezLabel.setText(this.username);
    }
    
    public ArrayList<Caso> getCasosByJuez() {

        GestorCaso gestor = new GestorCaso();
        GestorJuez gestorJuez = new GestorJuez();
        ArrayList<Caso> casos = null;

        try {
            casos = gestor.getCasosByJuez(gestorJuez.getJuezIdByUsername(username));
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return casos;

    }
    
    @FXML
    void cerrarSesion(MouseEvent event) throws IOException {
        closeCurrentWindow();
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
    
    @FXML
    void exitApp(MouseEvent event) {
        System.exit(0);
    }
    
     /**
     * Cierra la vista/ventana actual
     */
    @FXML
    public void closeCurrentWindow() {
        Stage stage = (Stage) juezLabel.getScene().getWindow();
        stage.close();
    }  
    
    public void setUsername(String username){
        this.username = username;
    }
    
    
   
    

}
