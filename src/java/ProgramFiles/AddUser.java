/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;


 import java.sql.*; 
 
 public class AddUser { 
     
     static Connection currentCon = null;
    
     
     public static void login(String userName, String userPassword, String Email) { 
//preparing some objects for connection 
         Statement stmt = null; 
       
        String query ="INSERT INTO USERS VALUES ( NULL, '"+ userName + "', '"+ userPassword + "', '" + Email + "')";
         //String query ="INSERT INTO USERS VALUES ( NULL, 'James', 'password', 'email')";
 
        
         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             boolean T =stmt.execute(query);
            System.out.println ("************WE HAVE A WINNER********************" + T); 
            currentCon.close();
         }
         catch (Exception ex) 
         { 
             System.out.println ("************WE HAVE NOOOOO WINNER********************"); 
             
         }
         
         
// exception handling 
         finally { 
             
             
             
             if (currentCon != null) 
             { try 
             { currentCon.close(); } 
             catch (Exception e) { } 
             
             currentCon = null; } }
         
          }
 
 }
