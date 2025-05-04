/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telu.todo.utilities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dany
 */
public class DatabaseUtilities {
    
    private static Connection connection;

    public static Connection getConnection() {
        if (connection==null) {
            
            Driver driver;
            try {
                driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
                
                String url="jdbc:mysql://localhost:3306/java_mvc";
                String user="root";
                String password="";
                
                connection=DriverManager.getConnection(url, user, password);
                //System.out.println("Koneksi Berhasil");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return connection;
    }
    
    public static void closeConnection(){
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
