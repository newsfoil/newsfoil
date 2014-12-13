
package ProgramFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NetworkRequestDOA {
    
      
     private static final String CREATE_REQUEST_EMAIL = 
     "INSERT INTO NNREQUESTS (NNRequest_ID, Sender_ID, Target_Email,Requestor_Name) VALUES (NULL ,?, ?,?)";
     private static final String GET_REQUEST_EMAIL = 
     "select * from USERS WHERE User_Email=?";
     private static final String CREATE_REQUEST_USERNAME = 
     "INSERT INTO NNREQUESTS (NNRequest_ID, Sender_ID, Target_Email,Requestor_Name) VALUES (NULL ,?, ?,?)";
     private static final String GET_REQUEST_USERNAME = 
     "select * from USERS WHERE User_Name=?";
     private static final String CREATE_MEMBER_USERNAME = 
     "INSERT INTO MYNEWSNETWORK (MyNewsNetrwork_ID, User_ID, Member_ID, Member_Name) VALUES (NULL ,?, ?,?)";
      private static final String DELETE_MEMBER_USERNAME = 
     "DELETE FROM NNREQUESTS WHERE Sender_ID = ?";  
     private static final String CREATE_MESSAGE = "INSERT INTO Messages (Message_ID, To_ID, From_ID, Subject, Message) VALUES (NULL,?,?,?,?)";
     private static final String DELETE_MESSAGE = "DELETE FROM Messages WHERE Message_ID = ?";

    public static boolean deleteMessage(MessageBean message ){
      
      try (Connection connection = ConnectionManager.getConnection();
               PreparedStatement statement = connection.prepareStatement(DELETE_MESSAGE)){
       
          
          statement.setInt(1, message.getMessage_ID());
          statement.execute();
          
          
         return true; 
      } catch (Exception ex) 
         { 
             System.out.println("*** Message not Deleted exception " + ex);
             return false;
         }
      
      
  }   
    
     
  public static boolean createMessage(UserBean user, SentMessageBean message ){
      
      try (Connection connection = ConnectionManager.getConnection();
               PreparedStatement statement = connection.prepareStatement(CREATE_MESSAGE)){
       
          
          statement.setInt(1, message.to_User_id);
          statement.setInt(2, message.from_User_id);
          statement.setString(3, message.user_Subject);
          statement.setString(4, message.getUser_Message());
          
          statement.execute();
          
         return true; 
      } catch (Exception ex) 
         { 
             System.out.println("*** Message not sent exception " + ex);
             return false;
         }
      
      
  }   
     
    public static boolean reguestByEmail(String targetEmail, UserBean user) {
//preparing some objects for connection 

        if (targetEmail.equals(user.getUser_Email())) {
            
           
        } else {

            try (Connection connection = ConnectionManager.getConnection();
                    PreparedStatement statement = connection.prepareStatement(GET_REQUEST_EMAIL)) {
//connect to DB 
                statement.setString(1, targetEmail);
                ResultSet resultset = statement.executeQuery();
                boolean more = resultset.next(); 
                
           

// if user does not exist set the isValid variable to false 
                
                    try (Connection connection2 = ConnectionManager.getConnection();
                        PreparedStatement statement2 = connection2.prepareStatement(CREATE_REQUEST_EMAIL)) {

                        statement2.setInt(1, Integer.parseInt(user.getUser_ID()));
                        statement2.setString(2, targetEmail);
                        statement2.setString(3, user.getUser_First_Name() + " " + user.getUser_Last_Name());
                        boolean success = statement2.execute();
                       
                    } catch (Exception ex) {
                        
                         System.out.println("*****Create Request Email user name " + user.getUser_First_Name() + " " + user.getUser_Last_Name());
                    }
                if (more) {

                } else {
                    
                    CreateEmail.pleaseJoin(user, targetEmail);                    
                }

//if user exists set the isValid variable to true 
            } catch (Exception ex) {
                System.out.println("Log In failed: An Exception has occurred! " + ex);
            }

// exception handling 
        }
        return true;
    }
 
    public static boolean reguestByUser(String lkupMember, UserBean user) { 
//preparing some objects for connection 
      
                
         try (Connection connection = ConnectionManager.getConnection();
              PreparedStatement statement = connection.prepareStatement(GET_REQUEST_USERNAME)) { 
//connect to DB 
             
            statement.setString(1, lkupMember);
            boolean more = statement.execute();
             
// if user does not exist set the isValid variable to false 
             if (more){
         
           try (Connection connection2 = ConnectionManager.getConnection();
              PreparedStatement statement2 = connection2.prepareStatement(CREATE_REQUEST_USERNAME)) {
           
            statement2.setInt(1, Integer.parseInt(user.getUser_ID()));
            statement2.setString(2, lkupMember);
            statement2.setString(3, user.getUser_First_Name() +" " + user.getUser_Last_Name());
            boolean success = statement2.execute();
            
            if (success)
            {}
            else
            {}
                     }catch(Exception ex){
                     
                     
                     }
                 
          
             
             }
             else { 
              
                  
             } 
             
//if user exists set the isValid variable to true 
             
         }
         catch (Exception ex) 
         { 
             System.out.println("Log In failed: An Exception has occurred! " + ex);
         }
         
         
// exception handling 
         
         return true; }  
 
    public static boolean acceptReguest(String requestorID,String requestorName, UserBean user){
  
      
                
         try (Connection connection = ConnectionManager.getConnection();
              PreparedStatement statement = connection.prepareStatement(CREATE_MEMBER_USERNAME)) { 
//connect to DB      
             statement.setInt(1, Integer.parseInt(user.getUser_ID()));
             statement.setInt(2, Integer.parseInt(requestorID));
             statement.setString(3, requestorName);
            boolean more = statement.execute();
            
            statement.setInt(1, Integer.parseInt(requestorID));
            statement.setInt(2, Integer.parseInt(user.getUser_ID())); 
            statement.setString(3, user.getUser_First_Name() +" " + user.getUser_Last_Name());
            more = statement.execute();
             
// if user does not exist set the isValid variable to false 
             
             
             declineReguest(requestorID,user);
             
                
                     }catch(Exception ex){  System.out.println("************** we don't have sucess !!!!" + ex);}
          
  return true;           
                  
  }
                    
   public static boolean declineReguest(String requestorID, UserBean user){
  
        try (Connection connection = ConnectionManager.getConnection();
              PreparedStatement statement = connection.prepareStatement(DELETE_MEMBER_USERNAME)) { 
//connect to DB 
             statement.setInt(1, Integer.parseInt(requestorID));
         
            boolean more = statement.execute();
            
           if (more){
           user.setNetworkRequests(requestorID);
           
           }
// if user does not exist set the isValid variable to false 
            
             
                     }catch(Exception ex){ System.out.println("*********this is the exception : " +ex);}
          
  return true;
  } 
  
}
