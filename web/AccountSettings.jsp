<%@ page language="java" contentType="text/html; charset=windows-1256" 
         pageEncoding="windows-1256" 
         import="ProgramFiles.UserBean" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Account Settings</title>

        <link href="css/login.css" rel="stylesheet" type="text/css" />
         <link href="css/sprycss.css" rel="stylesheet" type="text/css" />
        <script src="js/CollapsiblePanel.js" type="text/javascript"></script>
        
       
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
                    <a href="MyNewsRoom.jsp"><img src="images/logo.jpg" alt="Logo" align="middle" /></a>
                </div>



                <div class="fltrt">
                    
                 
                </div>
          
                <div class="accountSettingText">
                    <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                    <jsp:setProperty name="currentSessionUser" property="*"/>
                    <jsp:getProperty name = "currentSessionUser" property="user_Name" />
                    
                    
                    <div id="CollapsiblePanel1" class="CollapsiblePanel">
                        <div class="CollapsiblePanelTab" tabindex="1"> &gt; &nbsp; Change Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <jsp:getProperty name = "currentSessionUser" property="message" /> </div>
                        <div class="CollapsiblePanelContent">
                            <form id= "ResetPW" name="ResetPW" action="ResetPasswordServlet" method = "post">                    
                                Old Password: <input type="password" name="OldPassword" value=""/>
                                <br/><br/>
                                New Password: <input type="password" name="NewPassword"/>
                                <br/><br/>
                                Retype New Password: <input type="password" name="NewPassword2"/>
                                <input type="button" value="Change Password" onClick="populateform()"/>
                                <br/>
                                <span class="emsg" id="errormsg"/>
                                <br/>
                                <jsp:getProperty name = "currentSessionUser" property="message" />
                                <br/>
                            </form>
                        </div>
                    </div>

                    <form id= "account" name="account" action="ProfileServlet" method = "post"> 
                        <input type="hidden" name="password"/>
                        
                        <div class="accountInput">
                        <label class ="lbl">Photo: <input type="button" value="Download"/>
                        </label> 
                        </div> 
                        <div class="clearfloat"></div>
                        <div class="accountInput">
                        <label class ="lbl">Username: <input type="text" name="myUsername" id="accountSettingInput" value="<%= currentSessionUser.getUser_Name()%>" />
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        
                        <div class="accountInput">
                        <label class ="lbl">First Name: <input type="text" name="firstName" id="accountSettingInput" value="<%= currentSessionUser.getUser_First_Name()  %>"/>
                        </label>
                        </div>
                        <div class="accountInput">
                        <label class ="lbl">Middle Name: <input type="text" name="middleName" id="accountSettingInput" value="<%= currentSessionUser.getUser_Middle_Name()  %>"/>
                        </label>
                        </div>
                        <div class="accountInput">
                        <label class ="lbl">Last Name: <input type="text" name="lastName" id="accountSettingInput" value="<%= currentSessionUser.getUser_Last_Name() %>"/>
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        
                        <div class="accountInput">        
                        <label class ="lbl">City: <input type="text" name="myCity" id="accountSettingInput" value="<%= currentSessionUser.getUser_City() %>"/>
                        </label>
                        </div>
                        <div class="accountInput">
                        <label class ="lbl">State: <input type="text" name="myState" id="accountSettingInput" value="<%= currentSessionUser.getUser_State() %>"/>
                        </label>
                        </div>
                        <div class="accountInput">
                        <label class ="lbl">Zip: <input type="text" name="myZip" id="myZip" value="<%= currentSessionUser.getUser_Zip() %>"/>
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        
                        <div class="accountInput">
                        <label class ="lbl">Email address: <input type="text" name="myEmail" id="myEmail" value="" value="<%= currentSessionUser.getUser_Email() %>" /> 
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        
                        <div class="accountInput">
                        <label class ="lbl">Tagline: <input type="text" name="myTagline" id="myTagline" value="<%= currentSessionUser.getUser_Tag_Line() %>"/>
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        
                        <div class="accountInput">
                        <label class ="lbl">Political Party: <select name="myParty" id="myParty" >
                            <option value="volvo"><%= currentSessionUser.getUser_Political_Party() %></option>
                            <option value="volvo">I don't know</option>
                            <option value="saab">I don't care</option>
                            <option value="fiat">Republican</option>
                            <option value="audi">Democrat</option>
                            <option value="audi">Independent</option>
                            <option value="audi">Libertarian</option>
                            <option value="audi">Progressive</option>
                            <option value="audi">Conservative</option>
                            <option value="audi">Green</option>
                            <option value="audi">Not saying</option>
                            <option value="audi">Mickey Mouse</option>
                            <option value="audi">Miss Piggy</option>
                            <option value="audi">Other</option>
                        </select>
                            </label>
                        </div>
                            
                            <div class="clearfloat"></div>
                        <div class="accountInput">    
                        <label class ="lbl">Bio: <textarea name="myBio" id="myBio" rows="4" cols="50"></textarea>
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        <div class="accountInput">
                        <label class ="lbl">Education: <textarea name="myEducation" id="myEducation" rows="4" cols="50"></textarea>
                        </label>
                        </div>
                        <div class="clearfloat"></div>
                        <span class="emsg" id="errormsg">
                        </span>
                        <div class="clearfloat"></div>
                        <input type="submit" value="Update Profile" />

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



