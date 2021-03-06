package UI.Controllers;

import Datatypes.*;
import Managers.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;

/**
 * @author Amrit Parmanand, Elizabeth Del Monaco, & Gabriel Entov & Percy
 * @version It 3
 * Controller for mApplicationFormPg3 of UI
 */
public class mApplicationFormPg3 extends Controller {
    private SceneManager sceneM;
    private CacheManager cacheM;
    private LabelImage image = new LabelImage();
    private Form form;

    @FXML private JFXTextField onlyState;
    @FXML private JFXTextField ttbID;
    @FXML private JFXTextField bottleCapacity; //will be int, for future reference
    @FXML private JFXCheckBox certificateOfApproval;
    @FXML private JFXCheckBox certificateOfExemption;
    @FXML private JFXCheckBox DistinctiveLiquor;
    @FXML private JFXCheckBox resubmission;
    @FXML private ImageView imagePreview;
    @FXML private Label errorLabel;
    @FXML private JFXButton pdfButton;
    @FXML private VBox commentVBox;
    @FXML private JFXTextArea aComment;
    @FXML private ImageView alcyView;
    @FXML private Text alcyLabel;
    private settingPage settingPage;


    public mApplicationFormPg3(SceneManager sceneM, CacheManager cacheM,Form form) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;
        this.form = form;
        aComment = new JFXTextArea();
    }
    public mApplicationFormPg3(SceneManager sceneM, CacheManager cacheM) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;
        this.form = cacheM.getForm();
    }

    @SuppressWarnings("Duplicates") @FXML public void initialize() {

        Alcy alcy = cacheM.getAlcy();
        alcy.summonAlcy(alcyView, alcyLabel);
        alcy.sayMForm();

        aComment.setText(form.getCommentString());

            if (form.getCommentString() == "") {
                commentVBox.setVisible(false);
            }
            image = form.getLabel();

            certificateOfApproval.setSelected(form.getCertificateOfApproval());
            certificateOfExemption.setSelected(form.getCertificateOfExemption());
            DistinctiveLiquor.setSelected(form.getDistinctiveLiquor());
            resubmission.setSelected(form.getResubmission());
            onlyState.setText(form.parseGarbage(form.getOnlyState()));
            TextFields.bindAutoCompletion(onlyState, cacheM.getForm().stateSelect());

            if (form.getTtbID() != 0)
                resubmission.setSelected(true);
            ttbID.setText(String.valueOf(form.getTtbID()));
            bottleCapacity.setText(form.getBottleCapacity());

        if(form.getLabel().getLabelImage() != null)
            imagePreview.setImage(form.getLabel().getLabelImage());
        validateStateField();
        validateBottleCapacity();
        validateTTBID();
    }


    @FXML public void validateStateField() {
        if(!certificateOfExemption.isSelected()) {
            onlyState.setDisable(true);
        }else {
            onlyState.setText(form.parseGarbage(form.getOnlyState()));
            System.out.println(form.getOnlyState());
            onlyState.setDisable(false);
        }
    }
    @FXML public void validateBottleCapacity() {
        if(!DistinctiveLiquor.isSelected()) {
            bottleCapacity.setDisable(true);
        }else{
            bottleCapacity.setText(form.parseGarbage(form.getBottleCapacity()));
            bottleCapacity.setDisable(false);
        }
    }
    @FXML public void validateTTBID() {
        if(!resubmission.isSelected()) {
            ttbID.setText("");
            ttbID.setDisable(true);
        }else {
            ttbID.setText(Integer.toString(form.getTtbID()));
            ttbID.setEditable(false);
        }
    }

    @FXML public boolean saveDraft(){
        if (form.getTtbID() != 0) {
            checkDiff();
        }


            if (!certificateOfExemption.isSelected() && !certificateOfApproval.isSelected() &&
                    !DistinctiveLiquor.isSelected() && !resubmission.isSelected()) {
                errorLabel.setText("Please select a type of application.");
            }
            // Form form = cacheM.getForm();

            form.setCertificateOfApproval(certificateOfApproval.isSelected());
            form.setCertificateOfExemption(certificateOfExemption.isSelected());
            if (certificateOfExemption.isSelected()) {
                if (!onlyState.getText().isEmpty() && !form.getOnlyState().contains(cacheM.getStyle())) {
                    form.setOnlyState(onlyState.getText());
                }
            } else {
                form.setOnlyState("");
            }
            form.setDistinctiveLiquor(DistinctiveLiquor.isSelected());
            if (DistinctiveLiquor.isSelected()) {
                if (!bottleCapacity.getText().isEmpty()) {
                    if (!form.getBottleCapacity().contains(cacheM.getStyle())) {
                        form.setBottleCapacity(bottleCapacity.getText());
                    }
                }
            } else {
                form.setBottleCapacity("");
            }
            form.setResubmission(resubmission.isSelected());
            System.out.println(form.getResubmission());
            if (!resubmission.isSelected())
                form.setTtbID(0);
            else
                form.setTtbID(Integer.parseInt(ttbID.getText()));
            form.setLabel(image);
            errorLabel.setText(" ");
            form.setLabel(image);
            cacheM.setForm(form);
            return true;
    }


    @SuppressWarnings("Duplicates") public void checkDiff() {
        if (!onlyState.getText().equals(form.getOnlyState()) && !onlyState.getText().contains(cacheM.getStyle())) {
            form.setOnlyState(onlyState.getText() + cacheM.getStyle());
            System.out.println("added garbage");
        }
        if (!bottleCapacity.getText().equals(form.getBottleCapacity()) && !bottleCapacity.getText().contains(cacheM.getStyle())) {
            form.setBottleCapacity(bottleCapacity.getText() + cacheM.getStyle());
        }

    }

    @FXML public void nextPage() throws IOException {
        saveDraft();
        System.out.println("on to page 4");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mApplicationFormPg4.fxml"));
        sceneM.changeScene(loader, new mApplicationFormPg4(sceneM, cacheM, form));
    }
    @FXML public void previousPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mApplicationFormPg2.fxml"));
        sceneM.changeScene(loader, new mApplicationFormPg2(sceneM, cacheM, form));
    }
    @FXML public void goToHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/mHomepage.fxml"));
        sceneM.changeScene(loader, new mHomepage(sceneM, cacheM));
    }

    @FXML
    public void uploadImage(){
        form.getLabel().setLabelFile(image.getFile());
        if(form.getLabel().getLabelFile() == null){
            System.out.println("failed to set label file");
        }else{
            System.out.println("set label file from manufacturer");
        }
        imagePreview.setImage(image.getLabelImage());
    }

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