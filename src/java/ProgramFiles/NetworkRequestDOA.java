
package ProgramFiles;

import static ProgramFiles.UpdatePassword.currentCon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NetworkRequestDOA {
    
     static Connection currentCon = null;
     static ResultSet rs = null; 
     
     public static boolean login(String targetEmail, UserBean user) { 
//preparing some objects for connection 
         Statement stmt = null; 
        
         String searchQuery = "select * from USERS WHERE User_Email='" + targetEmail +"'"; 

         
         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             rs = stmt.executeQuery(searchQuery);
             boolean more = rs.next(); 
// if user does not exist set the isValid variable to false 
             if (!more) { 
                 
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
             else if (more) 
             {            
             
             }    
           
             
             String query2 =   "INSERT INTO `newsfoil`.`NNREQUESTS` (\n" +
                "`NNRequest_ID` ,\n" +
                "`User_ID` ,\n" +
                "`Target_Email`\n" +
                ")\n" +
                "VALUES (\n" +
                "NULL , '"+user.getUser_ID()+"', '"+ targetEmail +"'\n" +
                ") ";
           
           Statement stmt2 = null;   
           stmt2=currentCon.createStatement();
           boolean T =stmt2.execute(query2);
           
            
             
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
         
         return true; }
 
  
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
              bean.setUser_Email(rs.getString("User_Email"));
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
