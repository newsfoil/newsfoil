/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestNewAccount {
   
     static Connection currentCon = null;
     static ResultSet rs = null; 
     static ResultSet rs2 = null; 
     public static NewAccount login(NewAccount account, String username, String email) { 
//preparing some objects for connection 
        Statement stmt = null; 
        Statement stmt2 = null; 
        String searchQuery = "select * from USERS where User_name='" + username + "'"; 
        String searchQuery2 = "select * from USERS where User_Email='" + email + "'";
         
         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             rs2 = stmt.executeQuery(searchQuery2);
             
// if username does not exist set the isValid variable to false             
     
            boolean more = rs2.next(); 
             if (!more) 
                 account.setEmail(false);
             else if (more) 
             {account.setEmail(true); 
             account.setJspMessage("There is already an account for this email");
             }
            stmt2=currentCon.createStatement(); 
            rs = stmt2.executeQuery(searchQuery); 
             
            more = rs.next(); 
             if (!more) 
                 account.setUserName(false);
             else if (more) 
              account.setUserName(true);  
         }
         catch (Exception ex) 
         {  }
         
// exception handling 
         finally { 
             if (rs != null) 
             { try { rs.close(); } 
             catch (Exception e) {}   
             rs = null; 
             } 
             
             if (stmt != null) { 
                 try { stmt.close(); } 
                 catch (Exception e) {} 
                 stmt = null; } 
             
             if (currentCon != null) 
             { try 
             { currentCon.close(); } 
             catch (Exception e) { } 
             
             currentCon = null; } }
         
         return account; }
     
     public static NewAccount resetEmail(NewAccount account, String email) { 
//preparing some objects for connection 
        Statement stmt = null; 
        String searchQuery2 = "select * from USERS where User_Email='" + email + "'";
         
         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             rs2 = stmt.executeQuery(searchQuery2);
             
// if username does not exist set the isValid variable to false             
     
            boolean more = rs2.next(); 
             if (!more) {
             account.setEmail(false);
             
             } else if (more) 
             {account.setEmail(true); 
             String userID = rs2.getString("User_name");
             account.setUsername(userID);
             
             }           
         }
         catch (Exception ex) 
         {  }
         
// exception handling 
         finally { 
             if (rs != null) 
             { try { rs.close(); } 
             catch (Exception e) {} 
             
             rs = null; 
             } 
             
             if (stmt != null) { 
                 try { stmt.close(); } 
                 catch (Exception e) {} 
                 stmt = null; } 
             
             if (currentCon != null) 
             { try 
             { currentCon.close(); } 
             catch (Exception e) { } 
             
             currentCon = null; } }
         
         return account; }
 
 }
