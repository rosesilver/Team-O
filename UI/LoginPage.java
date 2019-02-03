package UI;

import Managers.*;

import Managers.UIManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoginPage {
    private UIManager uiManager;
    private CacheManager cacheManager;
    private DatabaseManager databaseManager;

    @FXML private Button pop;
    @FXML private RadioButton m;
    @FXML private RadioButton a;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Button register;
    @FXML private Button login;
    @FXML private Button search;

    public LoginPage(UIManager uiManager, CacheManager cacheManager, DatabaseManager databaseManager) {
        this.uiManager = uiManager;
        this.cacheManager = cacheManager;
        this.databaseManager = databaseManager;
    }

    /**
     * Default constructor
     */

    @FXML
    public void login() throws IOException {
        // Login
        if(m.isSelected()){
            Pane root = FXMLLoader.load(getClass().getResource("/UI/Views/mHomepage.fxml"));

            uiManager.switchScreen2(root);

            uiManager.changeScene(root, login);
        }
        else if(a.isSelected()){
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/aHomepage.fxml"));
            uiManager.changeScene(root, login);
        }
    }

    @FXML
    public void register() throws IOException {
        if(m.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/mRegister.fxml"));
            uiManager.changeScene(root, register);
        } else if (a.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/aRegister.fxml"));
            uiManager.changeScene(root, register);
        }
    }

    @FXML
    public void search() throws IOException {
        // Search
        Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/SearchPage.fxml"));
        uiManager.changeScene(root, search);
    }

    /**
     * Pop out a window
     * @param event
     * @throws IOException
     */
    @FXML
    public void popWindow(MouseEvent event) throws IOException {
        if(event.getSource() == pop){
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/mortgage.fxml"));
            uiManager.popWindow(root);
        }
    }

    /**
     * Enables the login btn and the register btn if radio buttons select and text fields are filled.
     * Disable otherwise
     */
    @FXML
    public void validateButton(){
        if(m.isSelected() || a.isSelected()){
            register.setDisable(false);
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                login.setDisable(true);
            } else {
                login.setDisable(false);
            }
        }
        else{
            register.setDisable(true);
            login.setDisable(true);
        }
    }
}
