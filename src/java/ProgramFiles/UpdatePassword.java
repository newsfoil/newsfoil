package ProgramFiles;


import ProgramFiles.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;


public class UpdatePassword {
    
      static Connection currentCon = null;
    
     
     public static void login(String userPassword, String Email) { 
//preparing some objects for connection 
         Statement stmt = null; 
       
        String query ="UPDATE USERS SET User_Password = '"+ userPassword + "'WHERE User_Email='" + Email + "'";
         //String query ="INSERT INTO USERS VALUES ( NULL, 'James', 'password', 'email')";
 
        
         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             boolean T =stmt.execute(query);
             
            currentCon.close();
         }
         catch (Exception ex) 
         { 
             
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
