package Managers;

import Datatypes.Account;
import Datatypes.Form;
import Fuzzy.FuzzyContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Sam Silver & Percy
 * @version It 2
 * manages the cache, provides access to cached info
 */
public class CacheManager {
    private Connection dbConn;
    private DatabaseManager dbM;
    private Form form;
    private Account acct;
    private int formLimit;

    public CacheManager(DatabaseManager dbM) {
        this.dbConn = dbConn;
        this.dbM = dbM;
        this.form = new Form();
    }

//    public CacheManager(Connection dbConn) {
//        this.dbConn = dbConn;
//        this.form = new Form();
//    }
//

    // Getters and Setters
    public Connection getDbConn() {
        return dbConn;
    }
    public void setDbConn(Connection dbConn) {
        this.dbConn = dbConn;
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

    // Facade stuff

    // The register function
    public void register(Connection conn){
        acct.register(dbConn);
    }

    // Form
    public void approveForm(Connection conn){
        form.approve(dbConn);
    }
    public void denyForm(Connection conn){
        form.deny(dbConn);
    }
    public void insertApp(Connection connection) throws SQLException {
        form.addApp(dbConn);
    }
    public void insertForm(Connection connection) throws SQLException{
        form.insert(dbConn);
    }

}
