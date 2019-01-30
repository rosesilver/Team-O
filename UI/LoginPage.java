package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.security.crypto.bcrypt.*;


import java.io.IOException;

public class LoginPage {

    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @FXML private Button pop;
    @FXML private RadioButton m;
    @FXML private RadioButton a;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Button register;
    @FXML private Button login;
    @FXML private Button search;

    /**
     * Model
     */
    private SceneManager sm;

    /**
     * Default constructor
     */
    public LoginPage() {
        this.sm = new SceneManager();
    }

    @FXML
    public void changeScene(MouseEvent event) throws IOException{

        // Register
        if(event.getSource() == register && m.isSelected()){
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/mRegister.fxml"));
            sm.changeScene(root, register);
        }
        else if(event.getSource() == register && a.isSelected()){
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/aRegister.fxml"));
            sm.changeScene(root, register);
        }

        // Login
        else if(event.getSource() == login && m.isSelected()){
            //this is where we check DB password hash
            //if(passwordEncoder.matches(raw text from password field,hashFromDataBase))
            //{

            //}
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/mHomepage.fxml"));
            sm.changeScene(root, login);
        }
        else if(event.getSource() == login && a.isSelected()){
            //this is where we check DB password hash
            //this is where we check DB password hash
            //if(passwordEncoder.matches(raw text from password field,hashFromDataBase))
            //{

            //}
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/aHomepage.fxml"));
            sm.changeScene(root, login);
        }

        // Search
        else if(event.getSource() == search){
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Views/SearchPage.fxml"));
            sm.changeScene(root, search);
        }
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
            sm.popWindow(root);
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
