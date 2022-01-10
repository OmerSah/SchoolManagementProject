/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omersahin
 */
import java.sql.*;

public class DBConnection {
    private Connection conn;
    private static DBConnection dbConnection;

    private DBConnection() {
        private String password;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", this.password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    
    public Connection getConnection() {
        return conn;
    }

    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}

