<%-- 
    Document   : LoginPage
    Created on : Nov 17, 2014, 8:47:34 AM
    Author     : dentm_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Newsfoil Login</title>

<link href="css/login.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div class="container">

 
  
<div class="header"><!-- end .header -->
  
  <div class="fltlft">
  <img src="images/Voice.jpg" alt="Logo" width="192" height="144" border="1" />
  </div>
  
  <div class="fltcent">
  <img src="images/logo.jpg" alt="Logo" align="middle" />
  </div>
  
  
  
  <div class="fltrt">
   <form action="NFLoginServlet" method = "post">             
            
             <input ID="tb1" type="username" name="username" placeholder="username"/>
            <input  ID="tb1" type="password" name="password" placeholder="password"/>
      <input ID="tb1" type="submit" value="Sign In">   
            <input type="hidden" name="targetpage" value="Login"/>
   </form>
   
    <a class="pwitem" href="NewAccount.html">&nbsp;New Account &nbsp;</a>
        <a class="pwitem" href="ResetPassword.jsp">&nbsp; Forgot Password &nbsp;</a>
      </div>
       
  
  <div class="content">
    
    Login failed.  Please reenter your username and password.

<div class="element"></div>
    <!-- end .content --></div>
    
  <!-- end .container --></div>
</body>
</html>
