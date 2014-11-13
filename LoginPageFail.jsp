<%-- 
    Document   : loginPage
    Created on : Nov 5, 2014, 8:14:01 AM
    Author     : dentm_000
--%>

<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" 
         %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"> 
        <title>Login Page</title> 
    </head> 
    <body> 
        
        <form action="NFServlet" method = "post"> 
          
            <h1> login failed </h1> 
            <input type="hidden" name="targetpage" value="Login">
            <h1>  Please enter your username </h1>
            <input type="text" name="username" value = ""/>
            <br> <h1> Please enter your password</h1> 
            <input type="password" name="password"/> 
            <input type="submit" value="submit" name="Login"> 
        </form> 
    </body> 
</html> 