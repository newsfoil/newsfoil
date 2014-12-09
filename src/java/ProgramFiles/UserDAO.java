
 package ProgramFiles;

 import java.sql.*; 
 
 public class UserDAO { 
     
     static Connection currentCon = null;
     static ResultSet rs = null; 
     private static final String GET_ALL_MESSAGES = "select * from Messages right join PROFILES on Messages.From_ID = PROFILES.User_ID where To_ID=?";
     private static final String GET_ALL_REQUESTS = "select * from NNREQUESTS where Target_Email=?";
     private static final String GET_USER = "SELECT * from USERS where (User_Name=? OR User_Email=?) AND User_Password=?";
     private static final String GET_NETWORK_MEMBERS = "SELECT * from MYNEWSNETWORK where User_ID =?";
     private static final String GET_PROFILE = "SELECT * from PROFILES where User_ID =?";
     private static final String CREATE_PROFILE = "INSERT INTO newsfoil.PROFILES (Profile_ID, User_ID, User_First_Name, User_Middle_Name, User_Last_Name, User_City, User_State, User_Zip, User_Tag_Line, User_Political_Party, User_Bio, User_Education, User_Photo) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     private static final String UPDATE_PROFILE = "UPDATE newsfoil.PROFILES SET User_First_Name = ?, User_Middle_Name = ?, User_Last_Name = ?," +
        "User_City = ?, User_State = ?, User_Zip = ?, User_Tag_Line = ?, User_Political_Party = ?, User_Bio = ?, User_Education = ? WHERE PROFILES.User_ID = ?";
  
     
public static int updateProfile(UserBean bean){

   
  
    try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROFILE)) {
            
           statement.setString(1, bean.getUser_First_Name());
           statement.setString(2, bean.getUser_Middle_Name());
           statement.setString(3, bean.getUser_Last_Name() );
           statement.setString(4, bean.getUser_City());
           statement.setString(5, bean.getUser_State());
           statement.setString(6, bean.getUser_Zip());
           statement.setString(7, bean.getUser_Tag_Line());
           statement.setString(8, bean.getUser_Political_Party());
           statement.setString(9, bean.getUser_Bio());
           statement.setString(10, bean.getUser_Education());
           statement.setString(11, bean.getUser_ID());
          
            boolean more = statement.execute();
          
     }
        catch (Exception ex) 
         {  
             
             System.out.println("****There is an exception: " + ex);
         }

    

    
    
return 1;
}
      
public static UserBean login(UserBean bean) { 
         
         try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            
           statement.setString(1, bean.getUser_Login());
           statement.setString(2, bean.getUser_Login());
           statement.setString(3, bean.getUser_Password());
           
           ResultSet resultSet = statement.executeQuery();
           boolean more = resultSet.next(); 
        
             if (!more) {  
             bean.setValid(false);
             } 
             
//if user exists set the isValid variable to true 
             else if (more) 
             {            
              
              bean.setUser_Email(resultSet.getString("User_Email")); 
              bean.setUser_Name(resultSet.getString("User_name"));
              bean.setUser_ID(resultSet.getString("User_ID")); 
              bean.setValid(true);
              
             }
         }
         catch (Exception ex) 
         { 
             
         }
         
      
         return bean; }

public static int createProfile(int userID){

     try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_PROFILE)) {
            
           statement.setInt(1, userID);
           statement.setString(2, " ");
           statement.setString(3, " ");
           statement.setString(4, " ");
           statement.setString(5, " ");
           statement.setString(6, " ");
           statement.setString(7, " ");
           statement.setString(8, " ");
           statement.setString(9, " ");
           statement.setString(10, " ");
           statement.setString(11, " ");
           statement.setString(12, " ");
              
            boolean more = statement.execute();
          
     }
        catch (Exception ex) 
         {  
         }

return 1;
}

public static int profile(UserBean bean){
    
        
          try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PROFILE)) {
            
           statement.setInt(1, Integer.parseInt(bean.getUser_ID()));
          
         
              
            ResultSet resultSet = statement.executeQuery();
            
         boolean more = resultSet.next(); 
        
             
             if (more) 
             {  
                 
              bean.setUser_First_Name(resultSet.getString("User_First_Name")); 
              bean.setUser_Middle_Name(resultSet.getString("User_Middle_Name"));
              bean.setUser_Last_Name(resultSet.getString("User_Last_Name"));
              bean.setUser_City(resultSet.getString("User_City"));
              bean.setUser_State(resultSet.getString("User_State"));
              bean.setUser_Zip(resultSet.getString("User_Zip"));
              bean.setUser_Tag_Line(resultSet.getString("User_Tag_Line"));
              bean.setUser_Political_Party(resultSet.getString("User_Political_Party"));
              bean.setUser_Bio (resultSet.getString("User_Bio"));
              bean.setUser_Education (resultSet.getString("User_Education"));
              bean.setUser_Photo (resultSet.getString("User_Photo"));
         
             } else {
             createProfile(Integer.parseInt(bean.getUser_ID()));
             HTMLWritter.createProfilePage(bean); 
             }
      
    
         }
         catch (Exception ex) 
         {  
             
         }
              
// exception handling 
         finally { 
             
             
             }
    
return 1;
    }

public static int getMessages(UserBean bean) throws SQLException{
   
         
          try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_MESSAGES)) {
            
              System.out.println("***I am running query for messages");
           statement.setInt(1, Integer.parseInt(bean.getUser_ID()));
              
              try (ResultSet resultSet = statement.executeQuery()) {
                  while (resultSet.next()) {
                       System.out.println("***There are messages");
                      MessageBean messageBean = new MessageBean();
                      
                      
                      
                      
                      
                      messageBean.setFrom_User_id(Integer.parseInt(resultSet.getString("FROM_ID")));
                      messageBean.setFrom_Name(resultSet.getString("User_First_Name") + resultSet.getString("User_Last_Name") );
                      messageBean.setUser_Subject(resultSet.getString("Subject"));
                      messageBean.setUser_Message(resultSet.getString("Message"));
                      
                      bean.setMessages(messageBean);
                  } }
          }
         catch (Exception ex) 
         {   
             System.out.println("***Exception" + ex);
         }
         
            
return 1;
    }

public static int NetworkRequest(UserBean bean) throws SQLException{
    
          
          try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_REQUESTS)){
              
              
              //String GET_ALL_REQUESTS = "select * from NNREQUESTS where Target_Email=?";
              
            statement.setString(1, bean.getUser_Email());  
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) { 
                NetworkRequestBean NRBean = new NetworkRequestBean();
                NRBean.setSender_ID(resultSet.getString("Sender_ID"));
                NRBean.setRequestor_Name(resultSet.getString("Requestor_Name"));
                try {bean.setNetworkRequests(NRBean);} catch (Exception ex)
                {System.out.println("exception = " + ex);}   
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

public static int getNetworkUsers(UserBean bean) throws SQLException{
   
          try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_NETWORK_MEMBERS)) {
            
           statement.setInt(1, Integer.parseInt(bean.getUser_ID()));
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                NetworkMemberBean memberBean = new NetworkMemberBean();    
                memberBean.setMember_ID(resultSet.getInt("Member_ID"));
                memberBean.setUser_ID(resultSet.getInt("User_ID"));
                memberBean.setMember_Name(resultSet.getString("Member_Name"));
                bean.setMembers(memberBean);
               
            }
            
          }
         catch (Exception ex) 
         {   
         }
               
        
            
return 1;
    }
 }