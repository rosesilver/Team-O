package UI.Controllers;

import Datatypes.Agent;
import Datatypes.agentScore;
import Managers.CacheManager;
import Managers.SceneManager;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class Scores {
    private SceneManager sceneM;
    private CacheManager cacheM;

    public Scores(SceneManager sceneM, CacheManager cacheM) {
        this.sceneM = sceneM;
        this.cacheM = cacheM;

    }
    @FXML private FlowPane loadScores;

    @FXML private Label score;
    @FXML private Label approved;
    @FXML private Label numDenied;
    @FXML private Label passed;
    @FXML private JFXButton back;
    @FXML private Label first;
    @FXML private Label second;
    @FXML private Label third;
    @FXML private ImageView theRookie;
    @FXML private ImageView gettingStarted;
    @FXML private ImageView seasonedPro;
    @FXML private ImageView threePointer;
    @FXML private ImageView backFromTheDead;
    @FXML private ImageView strikeThree;
    @FXML private ImageView passingTheBuck;
    @FXML private ImageView expertProcrastination;
    @FXML private ImageView expertDelegation;
    @FXML private ImageView pleasantMood;
    @FXML private ImageView yesMan;
    @FXML private ImageView goodVibrations;
    @FXML private ImageView highStandards;
    @FXML private ImageView denied;
    @FXML private ImageView itsAllWrong;

    @FXML public void initialize() {
        Connection connection = cacheM.getDbM().getConnection();
        Agent A = (Agent) cacheM.getAcct();
        A.rankAgents(connection);
        A.calculateScore(connection);
        score.setText(Integer.toString(A.getScore()));
        approved.setText(Integer.toString(A.getNumberApproved()));
        numDenied.setText(Integer.toString(A.getNumberDenied()));
        passed.setText(Integer.toString(A.getNumberPassed()));
        first.setText(A.getAgentPlaces().get(0).getAgentName());
        second.setText(A.getAgentPlaces().get(1).getAgentName());
        third.setText(A.getAgentPlaces().get(2).getAgentName());

        ArrayList<agentScore> agents = ((Agent) cacheM.getAcct()).getAgentPlaces();

        for (agentScore agent : agents) {
            Pane leaderBoard;
            System.out.println(agent.getAgentName());
            try {
                leaderBoard = FXMLLoader.load(getClass().getResource("/UI/Views/leaderboard.fxml"));
                Node hbox = leaderBoard.getChildren().get(0);
                if (hbox instanceof HBox) {

                    Node uName = ((HBox) hbox).getChildren().get(0);
                    Node score = ((HBox) hbox).getChildren().get(1);

                    ((Label) uName).setText(agent.getAgentName());
                    ((Label) score).setText(Integer.toString(agent.getAgentScore()));

                }
                loadScores.getChildren().add(leaderBoard);

            } catch (IOException e) {
                e.printStackTrace();

            }
        }





//
//
//        if (A.getAchievments()[1]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/1.png").toExternalForm());
//            theRookie= new ImageView(image);
//        }
//        if (A.getAchievments()[2]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/2.png").toExternalForm());
//            gettingStarted= new ImageView(image);
//        }
//        if (A.getAchievments()[3]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/3.png").toExternalForm());
//            seasonedPro= new ImageView(image);
//        }
//        if (A.getAchievments()[4]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/4.png").toExternalForm());
//            threePointer= new ImageView(image);
//        }
//        if (A.getAchievments()[5]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/5.png").toExternalForm());
//            backFromTheDead= new ImageView(image);
//        }
//        if (A.getAchievments()[6]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/6.png").toExternalForm());
//            strikeThree= new ImageView(image);
//        }
//        if (A.getAchievments()[7]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/7.png").toExternalForm());
//            passingTheBuck= new ImageView(image);
//        }
//        if (A.getAchievments()[8]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/8.png").toExternalForm());
//            expertProcrastination= new ImageView(image);
//        }
//        if (A.getAchievments()[9]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/9.png").toExternalForm());
//            expertDelegation= new ImageView(image);
//        }
//        if (A.getAchievments()[10]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/10.png").toExternalForm());
//            pleasantMood= new ImageView(image);
//        }
//        if (A.getAchievments()[11]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/11.png").toExternalForm());
//            yesMan= new ImageView(image);
//        }
//        if (A.getAchievments()[12]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/12.png").toExternalForm());
//            goodVibrations= new ImageView(image);
//        }
//        if (A.getAchievments()[13]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/13.png").toExternalForm());
//            highStandards= new ImageView(image);
//        }
//        if (A.getAchievments()[14]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/14.png").toExternalForm());
//            denied= new ImageView(image);
//        }
//        if (A.getAchievments()[15]==1){
//            Image image = new Image(getClass().getResource("@../SoftEngAchieveColor/15.png").toExternalForm());
//            itsAllWrong= new ImageView(image);
//        }



    }
    @FXML
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Views/aHomepage.fxml"));
        sceneM.changeScene(loader, new aHomepage(sceneM, cacheM));
    }
}
