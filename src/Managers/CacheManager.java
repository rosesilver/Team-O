package Managers;

import Datatypes.Account;
import Datatypes.Agent;
import Datatypes.Alcy;
import Datatypes.Form;
import Datatypes.SearchResult;
import Fuzzy.FuzzyContext;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sam Silver & Percy
 * @version It 2
 * manages the cache, provides access to cached info
 */
public class CacheManager {
    private DatabaseManager dbM;
    private Form form;
    private Account acct;
    private SearchResult selectedResult;
    private int formLimit = 5;
    private String fuzzy = "hiddenScore";
    private char format = ',';
    private String search = "";
    private String style = "-fx-background-color: #ff9395;";
    private Alcy alcy = new Alcy(this);
    private int fromTTB = 0;
    private int toTTB = 100;
    private boolean filter = false;
    private boolean filter2 = false;
    private String searchState = "";


    public CacheManager(DatabaseManager dbM) {
        this.dbM = dbM;
        this.form = new Form();
    }

    // Getters and Setters


    public String getSearchState() {
        return searchState;
    }

    public void setSearchState(String searchState) {
        this.searchState = searchState;
    }

    public boolean isFilter2() {
        return filter2;
    }

    public void setFilter2(boolean filter2) {
        this.filter2 = filter2;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public int getFromTTB() {
        return fromTTB;
    }

    public void setFromTTB(int fromTTB) {
        this.fromTTB = fromTTB;
    }

    public int getToTTB() {
        return toTTB;
    }

    public void setToTTB(int toTTB) {
        this.toTTB = toTTB;
    }

    public DatabaseManager getDbM() {
        return dbM;
    }
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
         this.form = form;
    }
    public Account getAcct() {
        return acct;
    }
    public void setAcct(Account acct) {
        this.acct = acct;
    }
    public SearchResult getSelectedResult() {
        return selectedResult;
    }
    public void setSelectedResult(SearchResult selectedResult) {
        this.selectedResult = selectedResult;
    }
    public int getFormLimit() {
        return formLimit;
    }
    public void setFormLimit(int formLimit) {
        this.formLimit = formLimit;
    }
    public String getFuzzy() {
        return fuzzy;
    }
    public void setFuzzy(String fuzzy) {
        this.fuzzy = fuzzy;
    }
    public char getFormat() {
        return format;
    }
    public void setFormat(char format) {
        this.format = format;
    }
    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public Alcy getAlcy() { return alcy; }
    public void setAlcyImageView(ImageView imageView) { this.alcy.setImageView(imageView); }

    // Facade stuff
    // Form
    public void approveForm(Connection conn) throws IOException {
        System.out.println("cManager approve Form");
        System.out.println(form.getFormID());
        System.out.println(form.getSignature());
        System.out.println(form.getDateIssued());
        ((Agent) this.getAcct()).setScore(((Agent) this.getAcct()).getScore() + 5);
        ((Agent) this.getAcct()).setNumberProcessed(( ((Agent) this.getAcct()).getNumberProcessed() + 1));
        form.approve(conn);

    }
    public void denyForm(Connection conn) throws Exception{
        ((Agent) this.getAcct()).setScore(((Agent) this.getAcct()).getScore() + 5);
        ((Agent) this.getAcct()).setNumberProcessed(( ((Agent) this.getAcct()).getNumberProcessed() + 1));
        form.deny(conn);
    }
    public void insertForm(Connection connection) throws Exception {
        form.insertForm(connection);
    }
    public ResultSet getApprovedApplications(Connection conn, String condition, String type) throws SQLException{
        return form.getApprovedApplications(conn, condition, type);
    }
    public boolean passForm(Connection connection, long formID,  String ttbUsername) {
        return form.passForm(connection, formID, ttbUsername);
    }

}
