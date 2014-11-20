<%@ page language="java" contentType="text/html; charset=windows-1256" 
 pageEncoding="windows-1256" 
 import="ProgramFiles.NewAccount"
 import="ProgramFiles.UserBean" %> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Account Settings</title>

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
  
    <% try {    
            UserBean currentUser = (UserBean) session.getAttribute("currentSessionUser");%> 
             Welcome <% out.println(currentUser.getUser_Name());} catch (Exception ex){} 
             %>   
      
      
  </div>
       
  
  <div class="accountSettingText">
    
      <form id= "account" name="account" action="ResetServlet" method = "post"> 
          <input type="hidden" name="password"/>
             <input type="hidden" name="targetpage" value="NewAccount"/>
            Photo: <input type="text" name="userName"/><input type="button" value="Download"/>
            <hr/><br/>
            User Name:  <input type="text" name="userName"/> 
            Password:   <input type="text" name="password"/> <input type="button" value="Change Password"/>
            <hr/><br/>
            First Name: <input type="text" name="firstName"/> 
            Middle Name: <input type="text" name="middleName"/> 
            Last Name: <input type="text" name="lastName"/> 
            <br/><br/>
            City: <input type="text" name="city"/>
            State: <input type="text" name="state"/>
            Zip: <input type="text" name="zip"/>
            <br/><br/>
            Email address: <input type="text" name="email"/> 
            <hr/><br/>
            Tag line: <input type="text" name="tag"/>
            <br/><br/> 
            Political Party: <select name="Political Party">
                <option value="volvo"></option>
                <option value="volvo">I don't know</option>
                <option value="saab">I don't care</option>
                <option value="fiat">Republican</option>
                <option value="audi">Democrat</option>
                <option value="audi">Independent</option>
                <option value="audi">Progressive</option>
                <option value="audi">Conservative</option>
                <option value="audi">Green</option>
                <option value="audi">Not saying</option>
                <option value="audi">Mickey Mouse</option>
                <option value="audi">Miss Piggy</option>
                <option value="audi">Other</option>
                </select>
            
            
            <br/><br/>
            Bio: <textarea rows="4" cols="50" name="bio"></textarea>
            <br/><br/>
            Education: <textarea rows="4" cols="50" name="education"></textarea>
            <br/><br/>
           
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
            <input type="button" value="Update Profile" onClick="populateform()"/>
            
            
        </form> 
        


          
        

<div class="element"></div>
    <!-- end .content --></div>
    
  <!-- end .container --></div>
</div>
</body>
</html>


        
