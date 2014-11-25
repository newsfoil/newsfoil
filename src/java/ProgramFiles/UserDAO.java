
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
System.out.println("************ I made it to starting the profile query");
         try { 
//connect to DB  
             stmt=currentCon.createStatement();
             rs = stmt.executeQuery(searchQuery);
             boolean more = rs.next(); 
// if user does not exist set the isValid variable to false 
             if (more) 
             {
             System.out.println("************ It ran the profile query and had results...") ;
              
                 
              String user_First_Name = rs.getString("User_First_Name");
              System.out.println("************ It ran the profile query and had results..." + user_First_Name);
              
              String user_Middle_Name = rs.getString("User_Middle_Name");
              System.out.println("1");
              String user_Last_Name = rs.getString("User_Last_Name");
              System.out.println("2");
              String user_City = rs.getString("User_City");
             System.out.println("3");
              String user_State = rs.getString("User_State");
             System.out.println("4");
              String user_Zip = rs.getString("User_Zip");
             System.out.println("5"); 
              String user_Tag_Line = rs.getString("User_Tag_Line");
            System.out.println("6");
              String user_Political_Party = rs.getString("User_Political_Party");
              System.out.println("7");
              String user_Bio = rs.getString("User_Bio");
              System.out.println("8");
              String user_Education = rs.getString("User_Education");
              String user_Photo = rs.getString("User_Photo");
              
              System.out.println("************ It ran the profile query and had results..." + user_First_Name+user_Last_Name);
              
              bean.setUser_First_Name(user_First_Name); 
              bean.setUser_Middle_Name(user_Middle_Name);
              bean.setUser_Last_Name(user_Last_Name);
              bean.setUser_City(user_City);
              bean.setUser_State(user_State);
              bean.setUser_Zip(user_Zip);
              bean.setUser_Tag_Line(user_Tag_Line);
              bean.setUser_Political_Party(user_Political_Party);
              bean.setUser_Bio (user_Bio);
              bean.setUser_Education (user_Education);
              bean.setUser_Photo (user_Photo);
              
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