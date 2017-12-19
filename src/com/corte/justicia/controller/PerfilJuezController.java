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
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    
    @FXML
    private TableColumn<Caso, String> comentarioEstado;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        querellante.setCellValueFactory(new PropertyValueFactory<>("demandante"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estadoNombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));       
        comentarioEstado.setCellValueFactory(new PropertyValueFactory<>("comentarioEstado")); 
        casos.getItems().setAll(getCasosByJuez());
          
        //----------------------------
        juezLabel.setText(this.username);
    }
    @FXML
    void modificarEstado(MouseEvent event) throws Exception{
        Caso casoSelecionado = casos.getSelectionModel().getSelectedItem();
        GestorCaso gestor = new GestorCaso();
        EstadoDetalleController detalle = new EstadoDetalleController();
        String numero = casoSelecionado.getNumero();
        int id_caso = gestor.getIdCasoByNumero(numero);
        int idEstado = gestor.getIdEstadoByIdCaso(id_caso);
        
        String path ;
        switch(idEstado){
            case 1:
                path = "EstadoRecibido";
                abrirView(path);
                EstadoRecibidoController estadoR = new EstadoRecibidoController();
                estadoR.setIdCaso(id_caso);
                break;
            case 2:
                path = "EstadoAceptado";
                abrirView(path);
                EstadoAceptadoController estadoA = new EstadoAceptadoController();
                estadoA.setIdCaso(id_caso);
//                System.out.println("Aceptado");
                break;    
            case 3:
                path = "EstadoConsulta";
                abrirView(path);
                EstadoConsultaController estadoConsulta = new EstadoConsultaController();
                estadoConsulta.setIdCaso(id_caso);    
//                System.out.println("Consulta");
                break; 
            case 4:
                
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(4);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
               
                
//                System.out.println("Rechazado");
                break; 
            case 5:
                path = "EstadoRedactado";
                abrirView(path);
                EstadoRedactadoController estadoRedactado = new EstadoRedactadoController();
                estadoRedactado.setIdCaso(id_caso);
//                System.out.println("Redactado");
                break;
            case 6:
                path = "EstadoRevision";
                abrirView(path);
                EstadoRevisionController estadoRevision = new EstadoRevisionController();
                estadoRevision.setIdCaso(id_caso);
//                System.out.println("Revision");
                break;   
            case 7:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(7);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                
//                System.out.println("Resuelto");
                break;     
                
            default:
                System.exit(0);
        }
        

    }
    
    @FXML
    void verDetalleEstado(MouseEvent event) throws Exception {
        Caso casoSelecionado = casos.getSelectionModel().getSelectedItem();
        GestorCaso gestor = new GestorCaso();
        EstadoDetalleController detalle = new EstadoDetalleController();
        String numero = casoSelecionado.getNumero();
        int id_caso = gestor.getIdCasoByNumero(numero);
        int idEstado = gestor.getIdEstadoByIdCaso(id_caso);
        
        String path ;
        switch(idEstado){
            case 1:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(1);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break;
            case 2:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(2);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break;    
            case 3:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(3);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break; 
            case 4:
                
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(4);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break; 
            case 5:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(5);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break;
            case 6:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(6);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break;   
            case 7:
                detalle.setIdCaso(id_caso);    
                detalle.setIdEstado(7);
                path = "EstadoDetalle";
                abrirViewSinCerrar(path);
                break;     
                
            default:
                System.exit(0);
        }
    }
    
    @FXML
    void verHistorialCaso(MouseEvent event) throws Exception {
        Caso casoSelecionado = casos.getSelectionModel().getSelectedItem();
        GestorCaso gestor = new GestorCaso();
        String numero = casoSelecionado.getNumero();
        int id_caso = gestor.getIdCasoByNumero(numero);
        
    
        HistorialCasoController historia = new HistorialCasoController();
        historia.setUsername(id_caso);
        
        String path =  "HistorialCaso";
        abrirViewSinCerrar( path);
    }
    
    
    void abrirViewSinCerrar(String path) throws IOException{
//        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/"+path+".fxml"));
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
    
    
    void abrirView(String path) throws IOException{
        closeCurrentWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/"+path+".fxml"));
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
