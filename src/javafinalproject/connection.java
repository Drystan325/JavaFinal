
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author student.admin
 */
public class connection {
    static final String DB_URL = "jdbc:mysql://localhost/javafinal";
    static final String USER ="root";
    static final String PASS = "";

  public static  Connection connectDB(){
       Connection conn = null;
    
       try{
//          Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
           return conn;
       }catch(Exception ex){
           System.out.println("There were errors while connecting to db.");
           return null;
       }
    

}

    static Connection connectDb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    PreparedStatement prepareStatement(String select__from_user_where_username_and_pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
