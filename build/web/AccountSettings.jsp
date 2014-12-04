<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"         
 pageEncoding="windows-1256" 
import="ProgramFiles.articles.ArticleBean" 
import="ProgramFiles.NetworkRequestBean" 
import="java.util.List" %> 
<% List<ArticleBean> articleList = (List<ArticleBean>)session.getAttribute("articleList"); %>

           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My News Room</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
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
        <div class="header">
            <div class="fltlft">
                <img src="images/Voice.jpg" alt="Logo" align="right" width="192" height="144" border="1" />
            </div>
            <div class="fltcent">
                <a href="NFServlet"><img src="images/logo.jpg" alt="Logo" align="middle" /></a>
            </div>
            <div class="fltrt">
                <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                <jsp:setProperty name="currentSessionUser" property="*"/>
                <jsp:getProperty name = "currentSessionUser" property="user_Name" />
            </div>
        </div>



        <div class="clearfloat"></div>
        <div class="sidebar1">

            <div class = "influence">
                Influence
                <br/>
                Current:  58%
                <br/>
                Variance: 46%
                <br/>
                Network Factor: 120%
                <br/><br/><br/>
                    
            </div>     
            <div id="CollapsiblePanel1" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="1"> &gt; &nbsp; Network Group </div>
                <div class="CollapsiblePanelContent">
                    <h4>Network Members: </h4>
                    This will contain a list of all members in network
                </div>
            </div>


            <div id="CollapsiblePanel2" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="2"> &gt; &nbsp; Network Requests </div>
                <div class="CollapsiblePanelContent">
                    <h3>Send a request so friends can join your News Network: </h3>
                    <form id="lkup" action="NewsNetworkRequestServlet" method="post" >
                        <input type="text" id="accountSettingInput" name="TargetEmail" placeholder="email">
                        <input type="text" id="accountSettingInput" name="lookupmember"placeholder="or username">
                        <input type="submit" id="accountSettingInput" value="Send a Request"/>
                    </form>
                    <br/>
                    <h3>These friends want you to join their News Network: </h3>
                    <%

                        try {
                            List<NetworkRequestBean> all_Request = currentSessionUser.getNetworkRequests();

                            for (int x = 0; x < all_Request.size(); x++) {
                                NetworkRequestBean RequestItem = all_Request.get(x);
                                out.println("<div class = \"requestdiv\">");
                                out.println(RequestItem.getRequestor_Name());
                                RequestItem.getSender_ID();
                                out.println("<form action=\"ProcessRequestServlet\" id=\"lkup\"<br/>"
                                        + "<input type=\"hidden\" name=\"Requestor\" value=\"" + RequestItem.getSender_ID() + "\"/>"
                                        + "<input type=\"submit\" name=\"acceptRequest\" id=\"accountSettingInput\" value=\"Accept\"/>"
                                        + "<input type=\"submit\" name=\"DeclineRequest\" id=\"accountSettingInput\" value=\"Decline\"/>"
                                        + "</form>");
                                out.println("</div>");

                            }
                        } catch (Exception ex) {
                        }


                    %>



                </div>
            </div> <!--end of CollapisablePanel2  -->
            <div id="CollapsiblePanel3" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="3"> &gt; &nbsp; My Articles </div>
                <div class="CollapsiblePanelContent">
                    <form action="lookupArticleServlet" id="lkup">
                        <input type="text" id="accountSettingInput" name="lookupmember">
                        <h4>Search Your Articles</h4>
                        <input type="button" name="userRequest" id="accountSettingInput" value="Search"/>
                    </form>
                </div>
            </div>

            <div id="CollapsiblePanel4" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="4"> &gt; &nbsp; Messages </div>
                <div class="CollapsiblePanelContent">
                    <form action="sendmessage" id="lkup">
                        <input type="text" id="accountSettingInput" name="lookupmember">
                        <h4>Send a Message</h4>
                        <input type="button" name="userRequest" id="accountSettingInput" value="Message"/>
                    </form>

                </div>
            </div>
        </div>

       
     
                <!-- 
            * <div class="content">
            *
            *
            start content -->
           <div class="accountSettingText2">
                  
               </br>
                       <h2> Change Password: </h2> </br> 
                            <form id= "ResetPW" name="ResetPW" action="ResetPasswordServlet" method = "post">                    
                                Old Password: <input type="password" name="OldPassword" value="" autocomplete="off"/>
                                <br/><br/>
                                New Password: <input type="password" name="NewPassword" autocomplete="off"/>
                                <br/><br/>
                                Retype New Password: <input type="password" name="NewPassword2" autocomplete="off"/>
                                <input type="button" value="Change Password" onClick="populateform()"/>
                                <br/>
                                <span class="emsg" id="errormsg"/>
                                <br/>
                                <jsp:getProperty name = "currentSessionUser" property="message" />
                                <br/>
                            </form>
                       <hr>
                       </br>
                       <h2> Change Profile: </h2> </br>
                    <form id= "account" name="account" action="ProfileServlet" method = "post">
                        <input type="submit" value="Update Profile" />
                        
                        Email address: <%= currentSessionUser.getUser_Email() %> 
                        
                        <br/><br/>
                        <p></p>
                        
                        <label class ="lbl">Photo: <input type="button" value="Download"/>
                        </label> 
                        (This element is not working yet)
                        <br/><br/>
                        
                        
                        <label class ="lbl">Username: <input type="text" name="myUsername" id="accountSettingInput" value="<%= currentSessionUser.getUser_Name()%>" />
                        </label>
                        <br/><br/>
                        <p></p>
                        
                        
                        <label class ="lbl">First Name: <input type="text" name="firstName" id="accountSettingInput" value="<%= currentSessionUser.getUser_First_Name()  %>"/>
                        </label>
                       
                        <label class ="lbl">Middle Name: <input type="text" name="middleName" id="accountSettingInput" value="<%= currentSessionUser.getUser_Middle_Name()  %>"/>
                        </label>
                       
                        <label class ="lbl">Last Name: <input type="text" name="lastName" id="accountSettingInput" value="<%= currentSessionUser.getUser_Last_Name() %>"/>
                        </label>
                        
                        <br/><br/>
                        <p></p>
                        
                        <label class ="lbl">City: <input type="text" name="myCity" id="accountSettingInput" value="<%= currentSessionUser.getUser_City() %>"/>
                        </label>
                        
                        
                        <label class ="lbl">State: <input type="text" name="myState" id="accountSettingInput" value="<%= currentSessionUser.getUser_State() %>"/>
                        </label>
                        
                        <label class ="lbl">Zip: <input type="text" name="myZip" id="myZip" value="<%= currentSessionUser.getUser_Zip() %>"/>
                        </label>
                        
                        
                        <br/><br/>
                        <p></p>
                        
                        <label class ="lbl">Tagline: <input type="text" name="myTagline" id="myTagline" value="<%= currentSessionUser.getUser_Tag_Line() %>"/>
                        </label>
                        
                        <br/><br/>
                        <p></p>
                        
                        <label class ="lbl">Political Party: <select name="myParty" id="myParty" >
                            <option value="<%= currentSessionUser.getUser_Political_Party() %>"><%= currentSessionUser.getUser_Political_Party() %></option>
                            <option value="I don't know">I don't know</option>
                            <option value="I don't care">I don't care</option>
                            <option value="Republican">Republican</option>
                            <option value="Democrat">Democrat</option>
                            <option value="Independent">Independent</option>
                            <option value="Libertarian">Libertarian</option>
                            <option value="Progressive">Progressive</option>
                            <option value="Conservative">Conservative</option>
                            <option value="Green">Green</option>
                            <option value="Not saying">Not saying</option>
                            <option value="Mickey Mouse">Mickey Mouse</option>
                            <option value="Other">Other</option>
                        </select>
                            </label>
                        
                        <br/><br/>
                        <p></p>    
                       <div class ="articleText">
                        <label>Bio: <textarea name="myBio" id="myBio" rows="4" cols="50"><%= currentSessionUser.getUser_Bio() %></textarea>
                        </label>
                        
                        <br/><br/>
                        <br/><br/>
                        
                        <br/><br/>
                        <p></p>
                       </div>
                        
                        <label class ="lbl">Education: <textarea name="myEducation" id="myEducation" rows="4" cols="50" ><%= currentSessionUser.getUser_Education() %></textarea>
                        </label>
                        
                        <br/><br/>
                        <br/><br/>
                        <br/><br/>
                        <p></p>

                        <span class="emsg" id="errormsg">
                        </span>
                        
                        <input type="submit" value="Update Profile" />

                    </form> 

                    
                   </div> 
                    <!-- end .content -->
            <!-- 
            *
            *</div>
            
            end content -->
        
        
                    
        <div class="sidebar2">
            <ul class="nav">
                <li><a href="NFServlet">Home</a>&nbsp;</li>
                <li><a href="CreateArticle">New Article</a>&nbsp;</li>
                <li><a href="ProfilePage">Profile</a>&nbsp;</li>
                <li><a href="AccountSettings.jsp">Settings</a> &nbsp;</li>
                <li><a href="About.jsp">About</a> &nbsp;</li>
            </ul>
        </div>

        <div class="footer">
            <p></p>
            <!-- end .footer --></div>
        <!-- end .container --></div>


    <script type="text/javascript">
        var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1", {contentIsOpen: false});
        var CollapsiblePanel2 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel2", {contentIsOpen: false});
        var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel3", {contentIsOpen: false});
        var CollapsiblePanel4 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel4", {contentIsOpen: false});
    </script>
                    
</body>
</html>
