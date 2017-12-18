package com.corte.justicia.utils;

import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @version 1.0 noviembre 14, 2017
 * @author Mariam Domínguez
 */
public class FXUtils {

    //init xy offsets
    private static double xOffset = 0;
    private static double yOffset = 0;

    /**
     * Cambia el icono default de java por uno modificado
     * en una ruta especificada
     *
     * @param s current stage
     */
    public static void displayIcon(Stage s) {
        Image icon = new Image("/com/corte/justicia/image/icon.png");
        s.getIcons().add(icon);
    }

    /**
     * Hace que la ventana actual pueda moverse
     *
     * @param root
     * @param s
     */
    public static void makeDraggableWindow(Parent root, Stage s) {

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                s.setX(event.getScreenX() - xOffset);
                s.setY(event.getScreenY() - yOffset);
            }
        });
    }
    
    /**
     * Implementa la clase FadeTransition en un AnchorPane
     * haciendo que el AchorPane aparezca suavemente
     * @param banner 
     */
    public static void fadeInBanner(AnchorPane banner) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1900), banner);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
    
    /**
     * Implementa la clase FadeTransition en un AnchorPane
     * haciendo que el AchorPane desaparezca suavemente
     * @param banner 
     */
    public static void fadeOutBanner(AnchorPane banner) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(1200), banner);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.play();
    }
    
    /**
     * Implementa la clase FadeTransition en un Label
     * haciendo que el label arezca suavemente
     * @param lab 
     */
    public static void fadeInLabel(Label lab) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1900), lab);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
    
    /**
     * Implementa la clase FadeTransition en un Label
     * haciendo que el label desarezca suavemente
     * @param lab 
     */
    public static void fadeOutLabel(Label lab) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(1200), lab);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.play();
    }
    
    

}
