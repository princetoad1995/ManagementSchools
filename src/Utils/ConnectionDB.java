/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PRINCE D. TOAD
 */
public class ConnectionDB {

    public static Connection getConnection() {
        Connection conn = null;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            String dbUrl = "jdbc:mysql://localhost:3306/highschools";
            conn = DriverManager.getConnection(dbUrl, "root", "thangpro");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("" + e);
        }
        return conn;
    }

//    public static void main(String[] args) {
//        ConnectionDB conn = new ConnectionDB();
//        System.out.println("" + conn.getConnection());
//    }
}
