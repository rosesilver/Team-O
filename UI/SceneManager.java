package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    /**
     * Pop-up windows
     */
    public void popWindow(Parent root){
        Stage stage;
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("idk what to pop so here's a fake mortgage calculator");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * Change scene
     */
    public void changeScene(Parent root, Button btn){
        Stage stage;
        stage=(Stage) btn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
