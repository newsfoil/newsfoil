<%@ page language="java" contentType="text/html; charset=windows-1256" 
         pageEncoding="windows-1256" 
         import="ProgramFiles.UserBean" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Account Settings</title>

        <link href="css/login.css" rel="stylesheet" type="text/css" />
        <script src="js/CollapsiblePanel.js" type="text/javascript"></script>
        <link href="css/sprycss.css" rel="stylesheet" type="text/css" />
        
        
        
        
        
        
        
        <script type="text/javascript">

        var temp='';

            function populateform() {
                var screenMsg = " ";
               
                if (validateFields() === "true")
               document.forms["ResetPW"].submit();
            }

        </script>


        <script language="JavaScript1.2">

            function validateFields()
            {
                var testresults = "";
                var screenMsg = "";
                
                if (!document.ResetPW.OldPassword.value)
                    screenMsg = "Please enter a your current password. ";
                
                 else if (!document.ResetPW.NewPassword.value)
                {
                    screenMsg = "Passwords do not match, Please re-enter.";
                }
                
                else if (document.ResetPW.NewPassword.value != document.ResetPW.NewPassword.value)
                {
                    screenMsg = "Passwords do not match, Please re-enter.";
                }
                else {
                    testresults = "true";
                }

                document.getElementById("errormsg").innerHTML = screenMsg;
                return testresults;
            }
        </script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
                </div>
          
                <div class="accountSettingText">
                    <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                    <jsp:setProperty name="currentSessionUser" property="*"/>
                    <jsp:getProperty name = "currentSessionUser" property="user_Name" />
                    
                    
                    <div id="CollapsiblePanel1" class="CollapsiblePanel">
   <div class="CollapsiblePanelTab" tabindex="1"> &gt; &nbsp;; Change Password</div>
  <div class="CollapsiblePanelContent">
   <form id= "ResetPW" name="ResetPW" action="ResetPasswordServlet" method = "post">                    
  Old Password: <input type="password" name="OldPassword" value=""/>
  <br/><br/>
  New Password: <input type="password" name="NewPassword"/>
  <br/><br/>
  Retype Password: <input type="password" name="NewPassword2"/>
   
  <input type="button" value="Change Password" onClick="populateform()"/>
  <br/>
<span class="emsg" id="errormsg"/>
  <br/><br/>
   </form>
  </div>
</div>
                    
                    

                    <form id= "account" name="account" action="ResetServlet" method = "post"> 
                        <input type="hidden" name="password"/>
                        <input type="hidden" name="targetpage" value="NewAccount"/>
                        Photo: <input type="text" name="userName"/><input type="button" value="Download"/>
                        <hr/><br/>
                        User Name:  <input type="text" name="userName" value="<%= currentSessionUser.getUser_Name()%>" /> 
                        Password:   <input type="button" value="Change Password"/>
                        <hr/><br/>
                        First Name: <input type="text" name="firstName" value="<%= currentSessionUser.getUser_First_Name()  %>"/> 
                        Middle Name: <input type="text" name="middleName" value="<%= currentSessionUser.getUser_Middle_Name()  %>"/> 
                        Last Name: <input type="text" name="lastName" value="<%= currentSessionUser.getUser_Last_Name() %>"/> 
                        <br/><br/>
                        City: <input type="text" name="city" value="<%= currentSessionUser.getUser_City() %>"/>
                        State: <input type="text" name="state" value="<%= currentSessionUser.getUser_State() %>"/>
                        Zip: <input type="text" name="zip" value="<%= currentSessionUser.getUser_Zip() %>"/>
                        <br/><br/>
                        Email address: <input type="text" name="email" value="" value="<%= currentSessionUser.getUser_Email() %>" /> 
                        <hr/><br/>
                        Tag line: <input type="text" name="tag" value="<%= currentSessionUser.getUser_Tag_Line() %>"/>
                        <br/><br/> 
                        Political Party: <select name="Political Party" >
                            <option value="volvo"><%= currentSessionUser.getUser_Political_Party() %></option>
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
                        Bio: <textarea rows="4" cols="50" name="bio" placeholder="<%= currentSessionUser.getUser_Bio() %>"></textarea>
                        <br/><br/>
                        Education: <textarea rows="4" cols="50" name="education" placeholder="<%= currentSessionUser.getUser_Education() %>"></textarea>
                        <br/><br/>

                        <span class="emsg" id="errormsg">




                        </span><br/><br/>
                        <input type="botton" value="Update Profile" onClick="populateform()"/>


                    </form> 


                    <div class="element"></div>
                    <!-- end .content --></div>

                <!-- end .container --></div>
        </div>
            <script type="text/javascript">
            var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1", {contentIsOpen:false});
            </script>
    </body>
</html>



