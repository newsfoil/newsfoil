<%@ page language="java" contentType="text/html; charset=windows-1256" 
 pageEncoding="windows-1256" 
  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reset Password Confirmation</title>

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
        <form name="login" action="NFServlet" method = "post">             
            <input ID="tb1" type="username" name="username" placeholder="username/email" autocomplete="false"/>
            <input  ID="tb1" type="password" name="password" placeholder="password" value="" autocomplete="off"/>
            <input ID="tb1" type="submit" value="Sign In"/>   
            <input type="hidden" name="targetpage" value="Login"/>
        </form>

        <a class="pwitem" href="NewAccount.html">&nbsp;New Account &nbsp;</a>
        <a class="pwitem" href="ResetPassword.jsp">&nbsp; Forgot Password &nbsp;</a>
    </div>
       
  
  <div class="content">
    
   

          A email has been sent to you with your new password. Use this password to login to your account
        

<div class="element"></div>
    <!-- end .content --></div>
    
  <!-- end .container --></div>
</body>
</html>


        