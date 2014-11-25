
 package ProgramFiles;

 import java.text.*; 
 import java.util.*; 
 import java.sql.*; 
 
 public class UserDAO { 
     
     static Connection currentCon = null;
     static ResultSet rs = null; 
     
     public static UserBean login(UserBean bean) { 
//preparing some objects for connection 
         Statement stmt = null; 
         String userLogin = bean.getUser_Login();
         String password = bean.getUser_Password(); 
         String searchQuery = "select * from USERS where (User_Name='" + userLogin + "' OR User_Email='" + userLogin +"') AND User_Password='" + password + "'"; 

         
         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             rs = stmt.executeQuery(searchQuery);
             boolean more = rs.next(); 
// if user does not exist set the isValid variable to false 
             if (!more) {  
             bean.setValid(false);
             } 
             
//if user exists set the isValid variable to true 
             else if (more) 
             {
              
              String email = rs.getString("User_Email");
              String userID = rs.getString("User_ID");
              String username = rs.getString("User_name");
              
              System.out.println("Welcome " + email); 
              
              bean.setUser_Email(email); 
              bean.setUser_Name(username);
              bean.setUser_ID(userID); 
              bean.setValid(true);
             }
         }
         catch (Exception ex) 
         { 
             System.out.println("Log In failed: An Exception has occurred! " + ex);
         }
         
         
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
         
         return bean; }
 
 }
