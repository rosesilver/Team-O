package UI.Controllers;

import Datatypes.*;
import Datatypes.ProgressBar;
import Managers.*;
import UI.MultiThreadWaitFor;
import UI.callableFunction;
import com.jfoenix.controls.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.System;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Year;
import java.util.Calendar;

/**
 * @author Amrit Parmanand & Elizabeth Del Monaco
 * @version It 2
 * Controller for mApplicationFormPg1 of UI
 */
public class mApplicationFormPg1 extends Controller{
    private SceneManager sceneM;
    private CacheManager cacheM;
    private Form form;
    @FXML
    private Label saveDraftMessage;
    @FXML
    private JFXTextField repID;
    @FXML
    private JFXTextField brewerNO;
    @FXML
    private RadioButton domestic;
    @FXML
    private RadioButton imported;
    @FXML
    private JFXTextField serialNumber;
    @FXML
    private RadioButton wine;
    @FXML
    private RadioButton distilled;
    @FXML
    private RadioButton malt;
    @FXML
    private JFXTextField brandName;
    @FXML
    private JFXTextField fancifulName;
    @FXML
    private JFXTextField alcoholPercentage;
    @FXML
    private JFXTextField phLevel;
    @FXML
    private JFXTextField vintageYear;
    @FXML
    private RadioButton wine2;
    @FXML
    private RadioButton spirits2;
    @FXML
    private RadioButton beer2;
    @FXML
    private JFXButton saveDraft;
    @FXML
    private Label serialMessage;

    @FXML private VBox commentVBox;
    @FXML private JFXTextArea aComment;

    @FXML private ImageView alcyView;
    @FXML private Text alcyLabel;
    private settingPage settingPage;

    public mApplicationFormPg1(SceneManager sceneM, CacheManager cacheM, Form form) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;
        this.form = form;
    }

    public mApplicationFormPg1(SceneManager sceneM, CacheManager cacheM) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;
        form = cacheM.getForm();
    }

    @SuppressWarnings("Duplicates")
    @FXML
    public void initialize() {

        Alcy alcy = cacheM.getAlcy();
        alcy.summonAlcy(alcyView, alcyLabel);
        alcy.sayMForm();

        repID.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                { cacheM.getAlcy().sayMHelpRepID();}
                else
                {
                    saveDraft();
                    cacheM.getAlcy().sayGreeting();
                }
            }
        });

        brewerNO.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                { cacheM.getAlcy().sayMHelpBrewerNO();}
                else
                {
                    saveDraft();
                    //cacheM.getAlcy().sayGreeting();
                }
            }
        });


        serialNumber.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                { cacheM.getAlcy().sayMHelpSerialNumber();}
                else
                {
                    saveDraft();
                    //cacheM.getAlcy().sayGreeting();
                }
            }
        });

        alcoholPercentage.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                { cacheM.getAlcy().sayMHelpAlcoholPercentage();}
                else
                {
                    saveDraft();
                    cacheM.getAlcy().sayWierdBeerPercentage();
                }
            }
        });

        fancifulName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                { cacheM.getAlcy().sayMHelpFancifulName();}
                else
                {
                    saveDraft();
                    cacheM.getAlcy().sayFancifulName();
                }
            }
        });

        brandName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {cacheM.getAlcy().sayMHelpBrandName(); }
                else
                {
                    saveDraft();
                    cacheM.getAlcy().sayBrandName();
                }
            }
        });

        phLevel.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {cacheM.getAlcy().sayMHelppHLevel(); }
                else
                {
                    saveDraft();
                    cacheM.getAlcy().saypHLevel();
                }
            }
        });

        vintageYear.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                { cacheM.getAlcy().sayMHelpVintageYear();}
                else
                {
                    saveDraft();
                    //cacheM.getAlcy().sayGreeting();
                }
            }
        });

        Manufacturer manAcc = (Manufacturer) cacheM.getAcct();

        if(form.getCommentString() == ""){
            commentVBox.setVisible(false);
        }

        aComment.setText(form.getCommentString());

        phVBox.setVisible(false);
        vintageVBox.setVisible(false);

        switch(form.getProductSource()){
            case "DOMESTIC":
                domestic.setSelected(true);
                break;
            case "IMPORTED":
                imported.setSelected(true);
                break;

        }
        switch(form.getProductType()){
            case "WINE":
                wine.setSelected(true);
                break;
            case "DISTILLED":
                distilled.setSelected(true);
                break;
            case "MALT":
                malt.setSelected(true);
                break;
        }
        switch(form.getBeerWineSpirit()){
            case "WINE":
                wine.setSelected(true);
                break;
            case "DISTILLED":
                distilled.setSelected(true);
                break;
            case "MALT":
                malt.setSelected(true);
                break;
        }
        if (form.getRepID() != 0)
            repID.setText(Integer.toString(form.getRepID()));
        else
            repID.setText(Integer.toString(manAcc.getRepID()));

        brewerNO.setText(form.parseGarbage(form.getBrewerNumber()));
        serialNumber.setText(form.parseGarbage(form.getSerialNumber()));
        if (!form.getBrandName().equals(""))
            brandName.setText(form.parseGarbage(form.getBrandName()));
        else
            brandName.setText(manAcc.getCompanyName());
        fancifulName.setText(form.parseGarbage(form.getFancifulName()));
        alcoholPercentage.setText(form.parseGarbage(form.getAlcoholPercent()));
        phLevel.setText(form.parseGarbage(form.getpHLevel()));
        vintageYear.setText(form.parseGarbage(form.getVintageYear()));
    }

    @SuppressWarnings("Duplicates") @FXML public void saveDraft() {

        if (form.getTtbID() != 0) {
            checkDiff();
        }

        if (!form.getProductSource().contains(cacheM.getStyle())) {
            if (domestic.isSelected() || imported.isSelected()) {
                if (domestic.isSelected()) {
                    form.setProductSource("DOMESTIC");
                } else if (imported.isSelected()) {
                    form.setProductSource("IMPORTED");
                }
            }
        }

        if (!form.getProductType().contains(cacheM.getStyle())) {
            if (wine.isSelected() || distilled.isSelected() || malt.isSelected()) {
                if (wine.isSelected()) {
                    form.setProductType("WINE");
                } else if (distilled.isSelected()) {
                    form.setProductType("DISTILLED");
                } else if (malt.isSelected()) {
                    form.setProductType("MALT");
                }
            }
        }

        if (!form.getBeerWineSpirit().contains(cacheM.getStyle())) {
            if (wine.isSelected() || distilled.isSelected() || malt.isSelected()) {
                if (wine.isSelected())
                    form.setBeerWineSpirit("WINE");
                else if (distilled.isSelected())
                    form.setBeerWineSpirit("SPIRITS");
                else if (malt.isSelected())
                    form.setBeerWineSpirit("BEER");
                if (wine.isSelected()) {
                    if (!phLevel.getText().isEmpty() && !form.getpHLevel().contains(cacheM.getStyle())) {
                        form.setpHLevel(phLevel.getText());
                    }
                    if (!vintageYear.getText().isEmpty() && !form.getVintageYear().contains(cacheM.getStyle())) {
                        form.setVintageYear(vintageYear.getText());
                    }
                }
                else {
                    form.setpHLevel(null);
                    form.setVintageYear(null);
                }
            }
        }

        if (!repID.getText().isEmpty()) {
            form.setRepID(Integer.parseInt(repID.getText()));
        }
        if (!brewerNO.getText().isEmpty() && !form.getBrewerNumber().contains(cacheM.getStyle())) {
            form.setBrewerNumber(brewerNO.getText());
            System.out.println("overwritten");
        }
        if (!serialNumber.getText().isEmpty() && !form.getSerialNumber().contains(cacheM.getStyle())) {
            form.setSerialNumber(serialNumber.getText());
            System.out.println("overwritten");
        }
        if (!brandName.getText().isEmpty() && !form.getBrandName().contains(cacheM.getStyle())) {
            form.setBrandName(brandName.getText());
            System.out.println("overwritten");
        }
        if (!fancifulName.getText().isEmpty() && !form.getFancifulName().contains(cacheM.getStyle())) {
            form.setFancifulName(fancifulName.getText());
            System.out.println("overwritten");
        }
        if (!alcoholPercentage.getText().isEmpty() && !form.getAlcoholPercent().contains(cacheM.getStyle())) {
            form.setAlcoholPercent(alcoholPercentage.getText());
        }



        //cacheM.setForm(form);

        System.out.println("Pg1 saved!");
    }

    @FXML
    private VBox phVBox;
    @FXML
    private VBox vintageVBox;

    @FXML
    public void hideWineFields() {
        phVBox.setVisible(false);
        vintageVBox.setVisible(false);
    }

    @FXML
    public void showWineFields() {
        phVBox.setVisible(true);
        vintageVBox.setVisible(true);
    }

    @FXML
    public void nextPage() throws IOException {
        saveDraft();
//        multiThreadWaitFor.onShutDown();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mApplicationFormPg2.fxml"));
        sceneM.changeScene(loader, new mApplicationFormPg2(sceneM, cacheM, form));
    }

    @FXML
    public void goToHomePage() throws IOException {
//        multiThreadWaitFor.onShutDown();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mHomepage.fxml"));
        sceneM.changeScene(loader, new mHomepage(sceneM, cacheM));
    }

    //starting with textboxes, not sure how to handle radio buttons and checkboxes
    public void checkDiff() {

        if (wine.isSelected()) {
            if (!phLevel.getText().equals(form.getpHLevel()) && !phLevel.getText().contains(cacheM.getStyle())) {
                form.setpHLevel(phLevel.getText() + cacheM.getStyle());
            }
            if (!vintageYear.getText().equals(form.getVintageYear()) && !vintageYear.getText().contains(cacheM.getStyle())) {
                form.setVintageYear(vintageYear.getText() + cacheM.getStyle());
            }
        }

        if (!brewerNO.getText().equals(form.getBrewerNumber()) && !brewerNO.getText().contains(cacheM.getStyle())) {
            form.setBrewerNumber(brewerNO.getText() + cacheM.getStyle());
        }
        if (!serialNumber.getText().equals(form.getSerialNumber()) && !serialNumber.getText().contains(cacheM.getStyle())) {
            form.setSerialNumber((serialNumber.getText() + cacheM.getStyle()));
        }
        if (!brandName.getText().equals(form.getBrandName()) && !brandName.getText().contains(cacheM.getStyle())) {
            form.setBrandName(brandName.getText() + cacheM.getStyle());
        }
        if (!fancifulName.getText().equals(form.getFancifulName()) && !fancifulName.getText().contains(cacheM.getStyle())) {
            form.setFancifulName(fancifulName.getText() + cacheM.getStyle());
        }
        if (!alcoholPercentage.getText().equals(form.getAlcoholPercent()) && !alcoholPercentage.getText().contains(cacheM.getStyle())) {
            form.setAlcoholPercent(alcoholPercentage.getText() + cacheM.getStyle());
        }

        if(domestic.isSelected() && !form.getProductSource().equals("DOMESTIC")){
            form.setProductSource("DOMESTIC" + cacheM.getStyle());
        }
        if(imported.isSelected() && !form.getProductSource().equals("IMPORTED")){
            form.setProductSource("IMPORTED" + cacheM.getStyle());
        }

        if(wine.isSelected() && !form.getProductType().equals("WINE")){
            form.setProductType("WINE" + cacheM.getStyle());
        }
        if(distilled.isSelected() && !form.getProductType().equals("DISTILLED")){
            form.setProductType("DISTILLED" + cacheM.getStyle());
        }
        if(malt.isSelected() && !form.getProductType().equals("MALT")){
            form.setProductType("MALT" + cacheM.getStyle());
        }

        if(wine.isSelected() && !form.getBeerWineSpirit().equals("WINE")){
            form.setBeerWineSpirit("WINE" + cacheM.getStyle());
        }
        if(distilled.isSelected() && !form.getBeerWineSpirit().equals("SPIRITS")){
            form.setBeerWineSpirit("SPIRITS" + cacheM.getStyle());
        }
        if(malt.isSelected() && !form.getBeerWineSpirit().equals("BEER")){
            form.setBeerWineSpirit("BEER" + cacheM.getStyle());
        }
    }

    //PROGRESSBAR 1
    //GET THIS DATA FROM CACHE
   

    @FXML
    public void logout() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/LoginPage.fxml"));
        sceneM.changeScene(loader, new LoginPage(sceneM, new CacheManager(this.cacheM.getDbM())));
    }

    @FXML
    public void onePage() throws IOException {
        saveDraft();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mOnePageForm.fxml"));
        sceneM.changeScene(loader, new mOnePageForm(sceneM, cacheM,form));
    }


    /**
     * @return true if valid serial number, false if not
     * @author Clay Oshiro-Leavitt
     * Checks that the serial number is valid
     * Criteria:
     * must be an integer
     * must be 6 digits in length
     * 1st two digits must be the last two digits of the current year (IE Year = 2019 -> 1st two digits = 19)
     */
    @FXML
    public Boolean validSerial() {
        String year = Integer.toString(Year.now().getValue());
        String serial = serialNumber.getText();
        if (serial.matches("^[0-9]{6}")) {
            if (serial.substring(0, 1).equals(year.substring(2, 3))) {
                serialMessage.setText("");
                return true;
            } else System.out.println("First two digits must be equal to last two digits of current year");
            serialMessage.setTextFill(Color.RED);
            serialMessage.setText("First two digits must be equal to last two digits of current year");
            return false;
        } else
            serialMessage.setTextFill(Color.RED);
        serialMessage.setText("Serial Number must be an integer of 6 digits");
        return false;
    }

    @FXML public void savePDF() throws IOException {
        saveDraft();
        PDF pdf = new PDF();
        pdf.savePDF(form);
    }

    @FXML public void settings() throws IOException {
        settingPage = new settingPage(sceneM, cacheM);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/settingPage.fxml"));
        sceneM.popWindowLoader(loader, settingPage, "Setting");
    }

}