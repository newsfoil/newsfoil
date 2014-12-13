/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;


public class CreateEmail {
 
public static boolean newAccount(NewAccount account){

  SendEmail email = new SendEmail();
                
email.setUserName(account.getUserFristName()+ " "+ account.getUserLastName());
email.setUserEmail(account.getUseremail());
email.setUserSubject("Password");
email.setUserMessage("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<title>Email</title>\n" +
"<style type=\"text/css\">\n" +
".title {\n" +
"	font-size: 16px;\n" +
"	font-weight: bold;\n" +
"}\n" +
".items {\n" +
"	font-size: 16px;\n" +                        
"	font-weight: bold;\n" +
"	color: #00F;\n" +
"	color: #00F;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<div>\n" +
"<a href=\"http://newsfoil.com\"><img src=\"http://newsfoil.com/images/logo.jpg\" alt=\"newfoil\" name=\"Logo\" width=\"480\" height=\"144\" /></a>\n" +
"<br/>\n" +
"Welcome to Newsfoil! We are glad to have you as part of our community.<br/>\n" +
"But you probably want to get started so here is your username and password:<br/>\n" +
"<br/>\n" +
"<span style=\"padding-left: 20px;font-weight: bold\">  Username: &nbsp;&nbsp;</span><span style=\"color:blue; padding-left: 20px;font-weight: bold\">"+ account.getUsername() + "</span><br/>\n" +
"<span style=\"padding-left: 20px;font-weight: bold\">   Password: </span><span style=\"color:blue; padding-left: 20px;font-weight: bold\">"+ account.getUserPassword() +   "</span><br/>\n" +
"<br/>\n" +
"Login here: &nbsp;<a href=\"http://newsfoil.com:8080/login/LoginPage.jsp\">newsfoil.com</a>\n" +
"<br/><br/>\n" +
"Use your password to login.  You can change your password when you login by selecting \"Settings.\"\n" +
"<br/>\n" +
"You have a voice. Be heard.\n" +
"</div>\n" +
"</body>\n" +
"</HTML>");
 email.Send();
    
return true;
}    
    
public static boolean pleaseJoin(UserBean user, String targetEmail){
    SendEmail email = new SendEmail();

                    email.setUserName(targetEmail);
                    email.setUserEmail(targetEmail);
                    email.setUserSubject(user.getUser_First_Name() + " " + user.getUser_Last_Name() + " wants you to join Newsfoil");

                    email.setUserMessage("<p>\n"
                           
                           + "<a href=\"http://newsfoil.com\"><img src=\"http://newsfoil.com/images/logo.jpg\" alt=\"newfoil\" name=\"Logo\" width=\"480\" height=\"144\" /></a>\n" 
                            +    "<br/>\n" 
                            + "Hello,\n"
                            + "</p>\n"
                            + "<p>\n"
                            + user.getUser_First_Name() + " " + user.getUser_Last_Name() + " wants you to join some site called Newsfoil and be a part of this thingy called \"News Network.\"\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>What is Newsfoil you ask?  We are a very \"exclusive site\", that anyone can join (I mean, we let your friend join so we can't be that picky...).\n"
                            + "  \n"
                            + "</p>\n"
                            + "<p>We really only require that you have the very narrow viewpoint, that \"people are free to share their ideas.\"  You also have to love bacon, because who doesn't love bacon???  Oh, you're a Vegan?  Sorry... But don't worry, we have initiated a \"don't ask don't tell\" policy on bacon, so we we'll never know...\n"
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


return true;
}

}
