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
"<title>Login</title>\n" +
"<style type=\"text/css\">\n" +
".title {\n" +
"	font-size: 16px;\n" +
"	font-weight: bold;\n" +
"}\n" +
".items {\n" +
"	font-size: 16px;\n" +                        
"	font-weight: bold;\n" +
"	color: #00F;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<div>\n" +
"<a href=\"http://newsfoil.com:8080/login/LoginPage.jsp\"><img src=\"http://newsfoil.com:8080/login/logo.jpg\" alt=\"newfoil\" name=\"Logo\" width=\"480\" height=\"144\" /></a>\n" +
"<br/>\n" +
"Welcome to Newsfoil! We are glad to have you as part of our community.<br/>\n" +
"But you probably want to get started so here is your username and password:<br/>\n" +
"<br/>\n" +
"<span class=\"title\">   Username: &nbsp;&nbsp;</span><span class=\"items\">"+ account.getUsername() + "</span><br/>\n" +
"<span class=\"title\">   Password: &nbsp;&nbsp;</span><span class=\"itmes\">"+ account.getUserPassword() +   "</span><br/>\n" +
"<br/>\n" +
"Login here: &nbsp;<a href=\"http://newsfoil.com:8080/login/LoginPage.jsp\">newsfoil.com</a>\n" +
"<br/><br/>\n" +
"Use your password to login.  You can change your password when you login by selecting \"Setting.\"\n" +
"<br/>\n" +
"You have a voice. Be heard.\n" +
"</div>\n" +
"</body>\n" +
"</HTML>");
 email.Send();
    
return true;
}    
    
    
}
