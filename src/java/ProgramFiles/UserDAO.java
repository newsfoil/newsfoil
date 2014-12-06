
 package ProgramFiles;

 import java.sql.*; 
 
 public class UserDAO { 
     
     static Connection currentCon = null;
     static ResultSet rs = null; 
     private static final String GET_ALL_MESSAGES = "select * from MESSAGES where To_ID=?";
     private static final String GET_ALL_REQUESTS = "select * from NNREQUESTS where Target_Email=?";
     private static final String GET_USER = "SELECT * from USERS where (User_Name=? OR User_Email=?) AND User_Password=?";
 
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
              
              bean.setUser_Email(rs.getString("User_Email")); 
              bean.setUser_Name(rs.getString("User_name"));
              bean.setUser_ID(rs.getString("User_ID")); 
              bean.setValid(true);
              profile(bean);
              System.out.println("this is user email: " +bean.getUser_Email() + " and " + rs.getString("User_Email"));
              NetworkRequest(bean);
              Message(bean);
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
             try { rs.close(); } 
             catch (Exception e) {}
             try { stmt.close(); } 
                 catch (Exception e) {} 
                 
         }
         catch (Exception ex) 
         {   
         }
              
// exception handling 
         finally { 
             
             
             }
    
return 1;
    }

private static int Message(UserBean bean) throws SQLException{
   
         
          try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_MESSAGES)) {
            
           statement.setString(1, bean.getUser_ID());
              
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                
                MessageBean messageBean = new MessageBean();    
                messageBean.setFrom_User_id(resultSet.getString("FROM_ID"));
                messageBean.setUser_Subject(resultSet.getString("Subject"));
                messageBean.setUser_Message(resultSet.getString("Message"));
                
                bean.setMessages(messageBean);
            }
            resultSet.close();
          }
         catch (Exception ex) 
         {   
         }
              
// exception handling 
         finally { 
              
             } 
            
return 1;
    }

public static int NetworkRequest(UserBean bean) throws SQLException{
    
          
          try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_REQUESTS)){
              
              
              //String GET_ALL_REQUESTS = "select * from NNREQUESTS where Target_Email=?";
              
            statement.setString(1, bean.getUser_Email());  
            ResultSet resultSet = statement.executeQuery();
            System.out.println("***********Request is tried 4... = "+ bean.getUser_Email() );
                
            while (resultSet.next()) { 
                NetworkRequestBean NRBean = new NetworkRequestBean();
                NRBean.setSender_ID(resultSet.getString("Sender_ID"));
                NRBean.setRequestor_Name(resultSet.getString("Requestor_Name"));
                try {bean.setNetworkRequests(NRBean);} catch (Exception ex){System.out.println("***********this is the exception = " + ex);}   
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
             
            
             
             if (currentCon != null) 
             { try 
             { currentCon.close(); } 
             catch (Exception e) { } 
             
             currentCon = null; } }
    
return 1;
    }


 }