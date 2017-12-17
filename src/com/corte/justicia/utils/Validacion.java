package com.corte.justicia.utils;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * @version 1.0 noviembre 14, 2017
 * @author Mariam Domínguez
 */
public class Validacion {
    
    /**
     * Añade estilos css de color verde a los inputs
     * de tipo JTXTextField
     * @param u parametro de tipo JTXTextField
     */
    public static void greenInputTextField(JFXTextField u) {
        u.setStyle("-jfx-unfocus-color:#a6bd55; "
                + "-jfx-focus-color: #a6bd55;"
                + "-fx-prompt-text-fill: #a6bd55; ");
    }
    
    
    public static void greenInputTextAreaField(JFXTextArea u) {
        u.setStyle("-jfx-unfocus-color:#a6bd55; "
                + "-jfx-focus-color: #a6bd55;"
                + "-fx-prompt-text-fill: #a6bd55; ");
    }
    
    public static void redInputTextAreaField(JFXTextArea u) {
        u.setStyle("-jfx-unfocus-color:#e74c3c;"
                + " -jfx-focus-color: #e74c3c;"
                + "-fx-prompt-text-fill: #e74c3c; ");
    }
    
    /**
     * Añade estilos css de color verde a los inputs
     * de tipo JFXPasswordField
     * @param p parametro de tipo JFXPasswordField
     */
    public static void greenInputPasswordField(JFXPasswordField p) {
         p.setStyle("-jfx-unfocus-color:#a6bd55; "
                + "-jfx-focus-color: #a6bd55;"
                + "-fx-prompt-text-fill: #a6bd55; ");
    }
    
    /**
     * Añade estilos css de color rojo a los inputs
     * de tipo JTXTextField
     * @param u parametro de tipo JTXTextField
     */
    public static void redInputTextField(JFXTextField u) {
        u.setStyle("-jfx-unfocus-color:#e74c3c;"
                + " -jfx-focus-color: #e74c3c;"
                + "-fx-prompt-text-fill: #e74c3c; ");
    }
    
     /**
     * Añade estilos css de color rojo a los inputs
     * de tipo JFXPasswordField
     * @param p parametro de tipo JFXPasswordField
     */
    public static void redInputPasswordField(JFXPasswordField p) {

        p.setStyle("-jfx-unfocus-color:#e74c3c; "
                + "-jfx-focus-color: #e74c3c;"
                + "-fx-prompt-text-fill: #e74c3c; ");
    }
    
    /**
     * Muestra un Alert de exito al registrar
     * @param exitoBanner banner verde que se muestra si la operacion fue exitosa
     * @param exitoLabel label en el banner verde
     */
    public static void sucessBanner(AnchorPane exitoBanner, Label exitoLabel){
        exitoBanner.setVisible(true);
        FXUtils.fadeInBanner(exitoBanner);
        exitoLabel.setVisible(true);
    }
    
    /**
     * Revisa que los dos inputs de contraseña sean iguales
     * si no son iguales llama a la funcion redInputPasswordField
     * y retorna true
     * @param confirmPass segundo input de tipo JFXPasswordField
     * @param passwordField primer input de tipo JFXPasswordField
     * @param errorLabelNoMatch label con mensaje indicando que las contraseñas
     * no son iguales
     * @return boolean
     */
    public static boolean isPasswordCorrect(JFXPasswordField confirmPass, JFXPasswordField passwordField, Label errorLabelNoMatch) {
        String contrasenna2 = confirmPass.getText();
        String contrasenna = passwordField.getText();

        if (!contrasenna.equals(contrasenna2)) {
            errorLabelNoMatch.setVisible(true);
            Validacion.redInputPasswordField(confirmPass);
            Validacion.redInputPasswordField(passwordField);
            return true;
        } else {

            errorLabelNoMatch.setVisible(false);

        }

        return false;
    }
}
