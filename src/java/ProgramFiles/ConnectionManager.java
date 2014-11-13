package ProgramFiles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;

public class ConnectionManager {

    static Connection con;
    static String url;
    static String userName = "marksdent";
    static String password = "Scratch44!";

    public static Connection getConnection() {

        try {
            url = "jdbc:mysql:" + "//192.169.249.38:3306/newsfoil";
// assuming "DataSource" is your DataSource name 

            Class.forName("com.mysql.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, userName, password);
// assuming your SQL Server's username is "username" // and password is "password" 
                 System.out.println("####### CONNECTION MADE #############################"); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return con;
    }

}
