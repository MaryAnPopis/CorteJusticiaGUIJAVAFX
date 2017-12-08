package com.corte.justicia.controller;

import com.corte.justicia.utils.FXUtils;
import com.corte.justicia.utils.Validacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import gestor.GestorSecretario;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author Mari
 */
public class SecretarioLoginController implements Initializable {

    @FXML
    private JFXButton backArrow;

    @FXML
    private Label errorLabel;

    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton logInBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets the visibility to non visible
        errorLabel.setVisible(false);
        //default Button is the button 
        //that receives a keyboard VK_ENTER press, if no other node in the scene consumes it.
        logInBtn.setDefaultButton(true);
    }

    /**
     * Login del juez
     *
     * @param event tipo ActionEvent
     */
    @FXML
    void loginJuez(ActionEvent event) throws IOException, Exception, SQLServerException {
        String username = this.usuario.getText();
        String contrasenna = this.password.getText();

        GestorSecretario gestor = new GestorSecretario();

        if (gestor.inicioSesion(username, contrasenna) != null) {
            
            errorLabel.setVisible(false);
            
            Validacion.greenInputTextField(usuario);
            Validacion.greenInputPasswordField(password);
            
            irPerfilSecretario();
            closeCurrentWindow();
        } else {
            Validacion.redInputTextField(usuario);
            Validacion.redInputPasswordField(password);
            errorLabel.setVisible(true);

        }

    }

    
    void irPerfilSecretario() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/PerfilSecretario.fxml"));
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

}
