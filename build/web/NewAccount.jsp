
<%@ page language="java" contentType="text/html; charset=windows-1256" 
 pageEncoding="windows-1256" 
 import="ProgramFiles.NewAccount" 
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Newsfoil Login</title>

        <link href="css/login.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript">
        var keylist="abcdefghijklmnopqrstuvwxyz123456789";
        var temp='';

        function generatepass(){
        temp='';
                for (i = 0; i < 7; i++)
                    temp += keylist.charAt(Math.floor(Math.random() * keylist.length));
                return temp;
            }

            function populateform() {

                var screenMsg = " ";
                document.account.password.value = generatepass();


                if (validateFields() === "true")
                    document.forms["account"].submit();
            }

        </script>

        <script language="JavaScript1.2">

            function validateFields()
            {
                var testresults = "";
                var str = document.account.email.value;
                var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                var screenMsg = "";
                if (!document.account.username.value)
                    screenMsg = "Please enter a username ";
                else if (!document.account.email.value)
                {
                    if (screenMsg == "")
                        screenMsg = "Please enter a email";
                    else
                        screenMsg = screenMsg + "<br/> Please enter a email. ";
                }
                else if (document.account.email.value != document.account.email2.value)
                {
                    screenMsg = "Emails do not match";
                }
                else {
                    if (filter.test(str))
                        testresults = "true";
                    else
                        screenMsg = "Email is not valid";
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
                    <form action="http://newsfoil.com:8080/login/NFLoginServlet" method = "post">             
                        <input ID="tb1" type="text" name="username" placeholder="username/ email" autocomplete="false"/>
                        <input  ID="tb1" type="password" name="password" placeholder="password" value="" autocomplete="off"/>
                        <input  type="submit" value="Sign In"/>
                    </form>
                    
                    <a class="pwitem" href="http://newsfoil.com:8080/login/NewAccount.html"> &nbsp; New Account &nbsp;</a>
                    <a class="pwitem" href="http://newsfoil.com:8080/login/ResetPassword.jsp">&nbsp; Forgot Password &nbsp;</a>
                   <br/><br/>
                   <a href="http://newsfoil.com:8080/login/About.html"> About Us</a>
                   
                </div>
            </div>

                <div class="content2">

                    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
                    <script src="typed.js" type="text/javascript"></script>



                    <form name="account" action="NAServlet" method = "post"> 
                        <input type="hidden" name="password">
                            <input type="hidden" name="targetpage" value="NewAccount">
                                <h2>Account Sign Up</h2>
                                <span style="font-size: 120%; line-height: 1.4;color: #3A3A3A">To sign up we need a little information to help set up the account. Don't worry, you only have 
                                    27 more pages of information to fill out where we ask for your Aunt Margaret's maiden name and every type of car you've purchased.  No not really,
                                    all the information you need to fill out is on this page.  We're too lazy to ask any more questions.<p></p>
                                    To make you feel at ease we have a privacy policy which you can 
                                    read <a href="http://newsfoil.com:8080/login/PrivacyPolicy.html"> here.</a> Now that you have not
                                    read our policy (no one ever reads those things) what you need to know it we won't sell any of your information
                                    or put you on email list that ask you to buy Viagra.  We will only use you information to improve our site.  
                                    How do we do this? we don't know yet, we're three college students making our first web site.  Oh, we may send you 
                                    emails from time to time letting you know what's going on with your account, like if some friend wants you to join 
                                    their network.  Don't worry, we won't be as annoying as Facebook who send emails for everything.  "For reals" as my 11-year-old
                                    niece says, we won't send you emails telling you Uncle Charlie post posted his toenail clipping schedule.  I'll even pinky swear to that.  But here is what we need:</span>
                                </br></br> 
                                </br></br> 
                                <h3>Your name (We have to know what to call you)</h3>  
                                     
                        <label class ="lbl">First Name: <input type="text" name="firstName" id="accountSettingInput" value=""/>
                        </label>
                       
                        <label class ="lbl">Middle Name: <input type="text" name="middleName" id="accountSettingInput" value=""/>
                        </label>
                       
                        <label class ="lbl">Last Name: <input type="text" name="lastName" id="accountSettingInput" value=""/>
                        </label>
                        
                                
                        <br/><br/>
                        <p></p>
                        <h3>A Username for you (so you can login)</h3>
                         <label class ="lbl">Username: <input type="text" name="username" id="accountSettingInput" value=""/>
                        </label>        
                                
                                
                        <br/><br/>
                        <p></p>
                        <h2> And yes, we need you email for when you forget your password.</h2>       
                        <label class ="lbl">Email: <input type="text" name="email" id="accountSettingInput" value=""/>
                        </label>   
                                
                        <br/><br/>
                        <p></p>
                        <h2>You're email one more time, we never get things right the first time...</h2>        
                        <label class ="lbl">Confirm Email: <input type="text" name="email2" id="accountSettingInput" value=""/>
                        </label> 
                                 <br/><br/>
                                <p></p>
                                
                                <span class="emsg" id="errormsg">
                                </span><br/><br/>
                                <input type="button" value="Sign Up" onClick="populateform()">


                                    </form> 


                                    <div class="element"></div>
                                    <!-- end .content --></div>

                                    <!-- end .container --></div>
                                    </body>
                                    </html>


