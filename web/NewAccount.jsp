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
   
 document.nAccount.password.value= generatepass();
 document.forms["nAccount"].submit();
}
</script>





        
        <form id= "nAccount" name="nAccount" action="NFServlet" method = "post"> 
          <input type="hidden" name="password">
             <input type="hidden" name="targetpage" value="NewAccount">
            <h1>  Please enter a username </h1>
            <input type="text" name="username"/>
            <br> <h1> Please enter a email address</h1> 
            <input type="text" name="email"/> 
            <br> <h1> Please re-enter email address</h1> 
            <input type="text" name="email"/> 
            
            <input type="button" value="Sign Up" onClick="populateform()">
            
        </form> 
    </body> 
</html> 