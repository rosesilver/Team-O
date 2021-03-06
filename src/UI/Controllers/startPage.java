package UI.Controllers;

import Datatypes.Alcy;
import Datatypes.Controller;
import Managers.CacheManager;
import Managers.SceneManager;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.awt.*;
import java.io.IOException;
import java.util.Collection;

public class startPage extends Controller {
    private SceneManager sceneM;
    private CacheManager cacheM;
    private settingPage settingPage;

    public startPage(SceneManager sceneM, CacheManager cacheM) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;


    }

    @FXML private JFXTextField search;
    @FXML private ImageView alcyView;
    @FXML private Text alcyLabel;


    @FXML public void initialize(){
        TextFields.bindAutoCompletion(search, cacheM.getForm().autoSearch(cacheM.getDbM().getConnection()));
        cacheM.getAlcy().summonAlcy(alcyView, alcyLabel);
        cacheM.getAlcy().sayWelcome();
        System.out.println("here");

    }
    
    @FXML public void login() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/LoginPage.fxml"));
        sceneM.changeScene(loader, new LoginPage(sceneM, cacheM));
    }

    @FXML public void search() throws IOException {

        cacheM.setSearch(search.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/SearchPage.fxml"));
        sceneM.changeScene(loader, new SearchPage(sceneM, cacheM));
    }

    @FXML public void about() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/AboutUs.fxml"));
        sceneM.popWindowLoader(loader, new AboutUs(sceneM, cacheM), "About Us");
    }

    @FXML public void settings() throws IOException {
        settingPage = new settingPage(sceneM, cacheM);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/settingPage.fxml"));
        sceneM.popWindowLoader(loader, settingPage, "Setting");
    }

}
