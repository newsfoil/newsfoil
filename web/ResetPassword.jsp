<%@ page language="java" contentType="text/html; charset=windows-1256" 
 pageEncoding="windows-1256" 
 import="ProgramFiles.NewAccount"  
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reset Password</title>

<link href="css/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

var keylist="abcdefghijklmnopqrstuvwxyz123456789";
var temp='';

function generatepass(){
temp='';
for (i=0;i<7;i++)
temp+=keylist.charAt(Math.floor(Math.random()*keylist.length));
return temp;
}

function populateform(){
 
 var screenMsg = " ";
 document.account.password.value= generatepass();
 
 
 if (validateFields() === "true")
    document.forms["account"].submit();
}

</script>


<script language="JavaScript1.2">

function validateFields()
{
var testresults = "";
var str=document.account.email.value;
var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
var screenMsg = "";

		if (filter.test(str))
		testresults = "true";
		else
		screenMsg = "Email is not valid";
    
	
	document.getElementById("errormsg").innerHTML = screenMsg;
	return testresults;
}
</script>

</head>

<body>

<div class="container">

 
  
    <div class="header">
        <div class="fltlft">
            <img src="images/Voice.jpg" alt="Logo" width="192" height="144" border="1" />
        </div>
        <div class="fltcent">
            <img src="images/logo.jpg" alt="Logo" align="middle" />
        </div>
        <div class="fltrt">
            <form name="login" action="NFLoginServlet" method = "post">             

                <input ID="tb1" type="username" name="username" placeholder="username/email" autocomplete="false"/>
                <input  ID="tb1" type="password" name="password" placeholder="password" value="" autocomplete="off"/>
                <input ID="tb1" type="submit" value="Sign In">   
                    <input type="hidden" name="targetpage" value="Login"/>
            </form>

            <a class="pwitem" href="NewAccount.html">&nbsp;New Account &nbsp;</a>
            <a class="pwitem" href="ResetPassword.jsp">&nbsp; Forgot Password &nbsp;</a>
        </div>

  <div class="content">
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="typed.js" type="text/javascript"></script>
    


        <form id= "account" name="account" action="ResetServlet" method = "post"> 
          <input type="hidden" name="password">
             <input type="hidden" name="targetpage" value="NewAccount">
            To reset you password enter the email you used to sign up for the account. A new password will be sent to this account.<br/><br/>
            <span class="contentText">  Email address: </span>
            <input type="text" name="email"/> <br/><br/>
            <span class="emsg" id="errormsg">
             <% 
    try {NewAccount currentUser = (NewAccount) session.getAttribute("thisUser");
                    out.println(currentUser.getJspMessage());
                    currentUser.setJspMessage("");
    }
             catch (Exception ex){
             
             }
             %>  

                
            </span><br/><br/>
            <input type="button" value="Send Email" onClick="populateform()">
            
            
        </form> 
        

<div class="element"></div>
    <!-- end .content --></div>
    
  <!-- end .container --></div>
</body>
</html>


        