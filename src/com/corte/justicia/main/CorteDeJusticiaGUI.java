
package com.corte.justicia.main;


import com.corte.justicia.utils.FXUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * 
 * @version 1.0 noviembre 14, 2017
 * @author Mariam Domínguez
 */
public class CorteDeJusticiaGUI extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/corte/justicia/view/RegistroQuerellante.fxml"));
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
