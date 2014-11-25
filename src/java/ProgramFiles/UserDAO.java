
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
                    
              bean.setUser_Email(email); 
              bean.setUser_Name(username);
              bean.setUser_ID(userID); 
              bean.setValid(true);
              profile(bean);
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
 
  
private static int profile(UserBean bean){
    
 Statement stmt = null; 
         String user_ID = bean.getUser_ID(); 
         String searchQuery = "select * from PROFILES where User_id=" + user_ID; 

         try { 
//connect to DB  
             stmt=currentCon.createStatement();
             rs = stmt.executeQuery(searchQuery);
             boolean more = rs.next(); 
// if user does not exist set the isValid variable to false 
             if (more) 
             {
              
              bean.setUser_First_Name(rs.getString("User_First_Name")); 
              bean.setUser_Middle_Name(rs.getString("User_Middle_Name"));
              bean.setUser_Last_Name(rs.getString("User_Last_Name"));
              bean.setUser_City(rs.getString("User_City"));
              bean.setUser_State(rs.getString("User_State"));
              bean.setUser_Zip(rs.getString("User_Zip"));
              bean.setUser_Tag_Line(rs.getString("User_Tag_Line"));
              bean.setUser_Political_Party(rs.getString("User_Political_Party"));
              bean.setUser_Bio (rs.getString("User_Bio"));
              bean.setUser_Education (rs.getString("User_Education"));
              bean.setUser_Photo (rs.getString("User_Photo"));
              
             } else if (!more)
             {
             String query ="INSERT INTO PROFILES (`Profile_ID`, `User_ID`) VALUES ( NULL,'" + user_ID +"')";
        
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             boolean T =stmt.execute(query);    
            currentCon.close();
      
             }
                 
         }
         catch (Exception ex) 
         {   
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
    
return 1;
    }
 }