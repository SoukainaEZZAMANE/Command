/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author khalid
 *
 */
public class Connect {

    private String url = "jdbc:mysql://localhost:3306/commande";
    private String user = "root";
    private String passwd = "";
    private Connection conn;
    private static Connect mycnx;

    // update insert et delete
    public static int exec(String requtte) throws SQLException {
        Connection conn = Connect.connectionFactory().getConn();
        Statement state = (Statement) conn.createStatement();
        return state.executeUpdate(requtte);
    }
// select
    public static ResultSet load(String requette) throws SQLException {
        Connection conn = Connect.connectionFactory().getConn();
        Statement state = (Statement) conn.createStatement();
        ResultSet resultSet = state.executeQuery(requette);
        return resultSet;
    }

    public static Connect connectionFactory() {
        if (mycnx == null) {
            mycnx = new Connect();
        }
        return mycnx;
    }

    public Connect(Connection conn) {
        this.conn = conn;
    }

    private Connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER OK ! ");

            conn = (Connection) DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connect(String url, String user, String passwd) {
        super();
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
}
