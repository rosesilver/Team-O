package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private SceneManager sm;

    public MainController(){
        this.sm = new SceneManager();
    }

    /**
     * Change scene
     */
    @FXML
    public void changeScene(MouseEvent event) throws IOException {
        Stage stage;
        Parent root;

        // LoginPage
        if(event.getSource()==register && m.isSelected()){
            //get reference to the button's stage
            stage=(Stage) register.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("/Views/mRegister.fxml"));
        }
        else if(event.getSource()==register && a.isSelected()){
            stage=(Stage) register.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/aRegister.fxml"));
        }
        else if(event.getSource()==login && a.isSelected()){
            stage=(Stage) login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/aHomepage.fxml"));
        }
        else if(event.getSource()==login && m.isSelected()){
            stage=(Stage) login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/mHomepage.fxml"));
        }

        // Register pages
        else if(event.getSource()==mRegister){
            stage=(Stage) mRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/mHomepage.fxml"));
        }
        else if(event.getSource()==aRegister){
            stage=(Stage) aRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/aHomepage.fxml"));
        }

        // The back buttons to login page
        else if(event.getSource()==mHomepageBack){
            stage=(Stage) mHomepageBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        }
        else if(event.getSource()==mRegisterBack){
            stage=(Stage) mRegisterBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        }
        else if(event.getSource()==aHomepageBack){
            stage=(Stage) aHomepageBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        }
        else if(event.getSource()==aRegisterBack){
            stage=(Stage) aRegisterBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        }
        else if(event.getSource()==SearchPageBack){
            stage=(Stage) SearchPageBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        }

        // To search page
        else if(event.getSource()==LoginPageSearch){
            stage=(Stage) LoginPageSearch.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/SearchPage.fxml"));
        }
        else if(event.getSource()==mRegisterSearch){
            stage=(Stage) mRegisterSearch.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/SearchPage.fxml"));
        }
        else if(event.getSource()==aRegisterSearch){
            stage=(Stage) aRegisterSearch.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/SearchPage.fxml"));
        }
        else if(event.getSource()==mHomepageSearch){
            stage=(Stage) mHomepageSearch.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../Views/SearchPage.fxml"));
        }

        else{
            stage=(Stage) mHomepageBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        }


        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Pop-up windows
     */
//    @FXML
//    public void popWindow(MouseEvent event) throws IOException {
//
//        sm.popWindow();
//
//        Stage stage;
//        Parent root;
//
//        if(event.getSource()==pop)
//        {
//            stage = new Stage();
//            root = FXMLLoader.load(getClass().getResource("/UI/Views/mortgage.fxml"));
//            stage.setScene(new Scene(root));
//            stage.setTitle("idk what to pop so here's a fake mortgage calculator");
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.initOwner(pop.getScene().getWindow());
//            stage.showAndWait();
//        }
//        else
//        {
//            stage=(Stage)mHomepageBack.getScene().getWindow();
//            stage.close();
//        }
//
//    }

    /**
     * Enables the login btn and the register btn if radio buttons select and text fields are filled.
     * Disable otherwise
     */
//    @FXML
//    public void validateButton(){
//        if(m.isSelected() || a.isSelected()){
//            register.setDisable(false);
//            if (username.getText().isEmpty() || password.getText().isEmpty()) {
//                login.setDisable(true);
//            } else {
//                login.setDisable(false);
//            }
//        }
//        else{
//            register.setDisable(true);
//            login.setDisable(true);
//        }
//    }

    /**
     * Validate manufacturer register button
     */
    @FXML
    public void validatemRegister(){
        if(repID.getText().isEmpty()){
            mRegister.setDisable(true);
        }
        else if(repID.getText() != null){
            mRegister.setDisable(false);
        }
    }

    /**
     * Validate manufacturer register button
     */
    @FXML
    public void validateaRegister(){
        if(agentID.getText().isEmpty()){
            aRegister.setDisable(true);
        }
        else if(agentID.getText() != null){
            aRegister.setDisable(false);
        }
    }

    @FXML
    RadioButton m;
    @FXML
    RadioButton a;

    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    TextField repID;
    @FXML
    TextField agentID;

    @FXML
    Button register;
    @FXML
    Button mRegister;
    @FXML
    Button aRegister;
    @FXML
    Button login;

    // Back buttons
    @FXML
    Button mHomepageBack;
    @FXML
    Button mRegisterBack;
    @FXML
    Button aHomepageBack;
    @FXML
    Button aRegisterBack;
    @FXML
    Button SearchPageBack;

    // Search buttons
    @FXML
    Button LoginPageSearch;
    @FXML
    Button mRegisterSearch;
    @FXML
    Button mHomepageSearch;
    @FXML
    Button aRegisterSearch;

    @FXML
    Button pop;
}
