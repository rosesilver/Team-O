package UI.Controllers;

import Datatypes.StageContainingScene;
import Managers.*;
import Managers.SceneManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.sql.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class newPasswordInput extends StageContainingScene {
    private SceneManager sceneM;
    private CacheManager cacheM;
    private String email;
    private Boolean Agent;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @FXML private JFXPasswordField password;
    @FXML private JFXPasswordField confirmP;
    @FXML private JFXButton reset;
    @FXML private Label passwordMessage;


    public newPasswordInput(SceneManager sceneM, CacheManager cacheM, String email, Boolean Agent, Stage stage) {
        super(stage);
        this.sceneM = sceneM;
        this.cacheM = cacheM;
        this.email = email;
        this.Agent = Agent;

    }

    @FXML
    public void reset() throws SQLException{
        if (password.getText().equals(confirmP.getText())){
            System.out.println("Updating password please hold");
            String setData = "UPDATE " + (Agent ? "AGENTS ":"REPRESENTATIVES ")+ "SET PASSWORD = ? WHERE EMAIL = ?";
            PreparedStatement ps = cacheM.getDbM().getConnection().prepareStatement(setData);
            ps.setString(1, this.getEncryptor().encode(confirmP.getText()));
            ps.setString(2, email);
            System.out.println(ps.toString());
            ps.executeUpdate();
            System.out.println("Password reset! Please login to continue");
            super.getStage().close();
        }
        else{
            passwordMessage.setTextFill(Color.RED);
            passwordMessage.setText("Passwords do not match.");
        }
    }
    public BCryptPasswordEncoder getEncryptor(){return passwordEncoder;}

}