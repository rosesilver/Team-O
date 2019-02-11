package UI;

import Datatypes.Manufacturer;
import Managers.CacheManager;
import Managers.DatabaseManager;
import Managers.SceneManager;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Percy Jiang & Gabe Entov & Elizabeth Del Monaco
 * @version It 2
 * Controller for mRegister of UI
 */
public class mRegister {

    private SceneManager sceneM;
    private CacheManager cacheM;
    private String phoneNumber;


    public mRegister(SceneManager sceneM, CacheManager cacheM) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;
    }

    @FXML private Button register;

    @FXML private JFXTextField username;
    @FXML private JFXPasswordField password;
    @FXML private JFXPasswordField confirmP;
    @FXML private JFXTextField fullName;
    @FXML private JFXTextField email;
    @FXML private JFXTextField phone;
    @FXML private JFXTextField repID;
    @FXML private JFXTextField companyName;

    @FXML
    @SuppressWarnings("Duplicates")
    public void register() throws IOException {
        if(password.getText().equals(confirmP.getText())){
            Manufacturer m = new Manufacturer(username.getText(), password.getText(), fullName.getText(),
                    email.getText(), phone.getText(), Integer.parseInt(repID.getText()),companyName.getText());
            cacheM.setAcct(m);
            cacheM.register(m);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mHomepage.fxml"));
            sceneM.changeScene(loader, new mHomepage(sceneM, cacheM));
        }
        else{
            System.out.println("Please confirm password!");
        }
    }

    @FXML public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/LoginPage.fxml"));
        sceneM.changeScene(loader, new LoginPage(sceneM, cacheM));
    }

    @FXML public void search() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/SearchPage.fxml"));
        sceneM.changeScene(loader, new SearchPage(sceneM, cacheM));
    }

    @FXML public void validateButton(){
        phoneNumber = phone.getText();
        if(username.getText().isEmpty() ||
                password.getText().isEmpty() ||
                confirmP.getText().isEmpty() ||
                fullName.getText().isEmpty() ||
                email.getText().isEmpty() ||
                phone.getText().isEmpty() ||
                companyName.getText().isEmpty() ||
                repID.getText().isEmpty() ||
                !validManuPhone(phoneNumber)){
            register.setDisable(true);
        }
        else{
            register.setDisable(false);
        }
    }

    /**
     * @author Clay Oshiro-Leavitt
     * checks the manufacturer phone number for Manufacturer Registration form
     * will accept US number with the following conditions
     * 1 prefix optional
     * area code is required
     * delimiters between number groups are optional
     * if delimiters are used, can use spaces, dashes as dividers between number groups
     * alphanumeric format is allowed after area code
     * @return true if is valid number, false if not
     */
    @FXML
    public boolean validManuPhone(String phoneNumber){
        if(phoneNumber.matches("^([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7})$")){
            //System.out.println("valid number");
            return true;
        }else
           // System.out.println("invalid number");
        return false;

    }
}
