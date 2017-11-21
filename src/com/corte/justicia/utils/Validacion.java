package com.corte.justicia.utils;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * @version 1.0 noviembre 14, 2017
 * @author Mariam Domínguez
 */
public class Validacion {
    
    
    public static void greenInputTextField(JFXTextField u) {
        u.setStyle("-jfx-unfocus-color:#a6bd55; "
                + "-jfx-focus-color: #a6bd55;"
                + "-fx-prompt-text-fill: #a6bd55; ");
    }
    
    public static void greenInputPasswordField(JFXPasswordField p) {
         p.setStyle("-jfx-unfocus-color:#a6bd55; "
                + "-jfx-focus-color: #a6bd55;"
                + "-fx-prompt-text-fill: #a6bd55; ");
    }
    
    public static void redInputTextField(JFXTextField u) {
        u.setStyle("-jfx-unfocus-color:#e74c3c;"
                + " -jfx-focus-color: #e74c3c;"
                + "-fx-prompt-text-fill: #e74c3c; ");
    }
    
    public static void redInputPasswordField(JFXPasswordField p) {

        p.setStyle("-jfx-unfocus-color:#e74c3c; "
                + "-jfx-focus-color: #e74c3c;"
                + "-fx-prompt-text-fill: #e74c3c; ");
    }
    
    /**
     * Alert de exito al registrar
     */
    public static void sucessBanner(AnchorPane exitoBanner, Label exitoLabel){
        exitoBanner.setVisible(true);
        FXUtils.fadeInBanner(exitoBanner);
        exitoLabel.setVisible(true);
    }
    
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
