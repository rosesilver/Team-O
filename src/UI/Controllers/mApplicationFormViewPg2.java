package UI.Controllers;

import Datatypes.Form;
import Datatypes.Manufacturer;
import Managers.*;
import UI.MultiThreadWaitFor;
import UI.callableFunction;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * @author Amrit Parmanand & Elizabeth Del Monaco
 * @version It 2
 * Controller for mApplicationFormPg2 of UI
 */
public class mApplicationFormViewPg2 {
    private SceneManager sceneM;
    private CacheManager cacheM;
    private String phoneNumberString;
    private String formEmail;
    private Form form;


    @FXML private AnchorPane mainPane;

    @FXML private VBox hideBox;
    @FXML private VBox varietalVBox;
    @FXML private VBox appellationVBox;
    @FXML private Label saveDraftMessage;

    @FXML private JFXTextField printName;
    @FXML private JFXTextField mailAddress;
    @FXML private JFXTextField formula;
    @FXML private JFXTextField grapes;
    @FXML private JFXTextField appellation;
    @FXML private JFXTextField phoneNumber;
    @FXML private JFXTextField email;

    public mApplicationFormViewPg2(SceneManager sceneM, CacheManager cacheM, Form form) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;
        this.form = form;
    }

    @SuppressWarnings("Duplicates")
    @FXML public void initialize() {
        Form form = this.form;

        printName.setText(form.getPrintName());
        printName.setEditable(false);
        mailAddress.setText(form.getMailingAddress());
        mailAddress.setEditable(false);
        formula.setText(form.getFormula());
        formula.setEditable(false);
        grapes.setText(form.getGrapeVarietal());
        grapes.setEditable(false);
        appellation.setText(form.getAppellation());
        appellation.setEditable(false);
        phoneNumber.setText(form.getPhoneNumber());
        phoneNumber.setEditable(false);
        email.setText(form.getEmailAddress());
        email.setEditable(false);
        System.out.println("filled in info page 2");

    }


    @FXML public void wineFieldCheck(){
        if(cacheM.getForm().getBeerWineSpirit() != "WINE") {
            grapes.setEditable(false);
            grapes.setPromptText("n/a");
            appellation.setEditable(false);
            appellation.setPromptText("n/a");
        }
    }

    @FXML public void nextPage() throws IOException {
//        multiThreadWaitFor.onShutDown();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mApplicationFormViewPg3.fxml"));
        sceneM.changeScene(loader, new mApplicationFormViewPg3(sceneM, cacheM,form));
    }
    @FXML public void previousPage() throws IOException {
//        multiThreadWaitFor.onShutDown();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mApplicationFormViewPg1.fxml"));
        sceneM.changeScene(loader, new mApplicationFormViewPg1(sceneM, cacheM,form));
    }

    @FXML public void goToHomePage() throws IOException {
//        multiThreadWaitFor.onShutDown();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mHomepage.fxml"));
        sceneM.changeScene(loader, new mHomepage(sceneM, cacheM));
    }

    @FXML
    public void logout() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/LoginPage.fxml"));
        sceneM.changeScene(loader, new LoginPage(sceneM, new CacheManager(this.cacheM.getDbM())));
    }

}