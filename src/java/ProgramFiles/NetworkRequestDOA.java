
package ProgramFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
     private static final String CREATE_MESSAGE = "INSERT INTO MESSAGE (Message_ID, To_ID, From_ID, Subject, Message) VALUES (NULL,?,?,?,?)";
     
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
             System.out.println("Log In failed: An Exception has occurred! " + ex);
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
                boolean more = statement.execute();

// if user does not exist set the isValid variable to false 
                if (more) {

                    try (Connection connection2 = ConnectionManager.getConnection();
                            PreparedStatement statement2 = connection2.prepareStatement(CREATE_REQUEST_EMAIL)) {

                        statement2.setInt(1, Integer.parseInt(user.getUser_ID()));
                        statement2.setString(2, targetEmail);
                        statement2.setString(3, user.getUser_First_Name() + " " + user.getUser_Last_Name());
                        boolean success = statement2.execute();
                       
                        
                        System.out.println("*****Create Request Email user name " + user.getUser_First_Name() + " " + user.getUser_Last_Name());
                    } catch (Exception ex) {
                    }

                } else {

                    SendEmail email = new SendEmail();

                    email.setUserName(user.getUser_Name());
                    email.setUserEmail(targetEmail);
                    email.setUserSubject(user.getUser_First_Name() + " " + user.getUser_Last_Name() + " wants you to join Newsfoil");

                    email.setUserMessage("<p>\n"
                            + "Hello,\n"
                            + "</p>\n"
                            + "<p>\n"
                            + user.getUser_First_Name() + " " + user.getUser_Last_Name() + " wants you to join some site called Newsfoil and be a part of this thingy called \"News Network.\"\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>What is Newsfoil you ask?  We are a very \"exclusive site\", that anyone can join (I mean, we let your friend join so we can't be that picky...).\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>We really only require that you have the very narrow viewpoint, that \"people are free to share their ideas.\"  You also have to love bacon, because who doesn't love bacon???  Oh, you're a Vegan?  Sorry... But don't worry, we have initiated a \"don't ask don't tell\" policy on bacon, so we will never know...\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p><strong>Here are some reasons you SHOULD NOT JOIN this site:\n"
                            + "  \n"
                            + "</strong></p>\n"
                            + "<p>1) You do not have access to a computer and only received this message by linking into Wi-Fi with a tinfoil hat.\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>2) The name of the site is \"NEWSFOIL\"... who came up with a name like that?  You use foil to wrap the grates on a grill, why put news in foil? \n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>3) They still have not told me what this site is. They're playing all \"coy with me\" by providing a non-answer to my question \"what is Newsfoil?\" They think that by not answering, I just might go to their site and click on the \"About\" button.  Can you believe them?  \n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>4) You said the \"site is exclusive\" but you let everyone join?  That is not exclusive! I WILL NOT JOIN A SITE THAT LIES TO ME IN THEIR EMAIL!   \n"
                            + "  \n"
                            + "</p>\n"
                            + "<p><strong>Here are some reasons you SHOULD JOIN Newsfoil: \n"
                            + "  \n"
                            + "</strong></p>\n"
                            + "<p>1) Your friend asked you to join, are you gong to become a disappointment to your friend? (Yes we're laying it on thick...)\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>2)  We just said \"your friend asked you to join\" do we need more then that?  Oh, " + user.getUser_First_Name() + " " + user.getUser_Last_Name() + " is not your freind?  Oh sorry... We'll leave you alone.\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>Anyway, here's the link to the site, you can sign-up and become a part of " + user.getUser_First_Name() + " " + user.getUser_Last_Name() + " News Network:  </p>\n"
                            + "<p><a href=\"http://Newsfoil.com\"><strong>Newsfoil.com</strong></a>  </p>\n"
                            + "<p>Thanks and hope to see you on the site,  </p>\n"
                            + "<p>Newsfoil Team </p>");
                    email.Send();

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
