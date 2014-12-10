<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"         
 pageEncoding="windows-1256" 
import="ProgramFiles.articles.ArticleBean" 
import="ProgramFiles.NetworkRequestBean" 
import="ProgramFiles.NetworkMemberBean" 
import="ProgramFiles.MessageBean" 
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

  <script type="text/javascript" src="js/tinymce/tinymce.min.js"></script>
    <script type="text/javascript">
        tinymce.init({
        selector: "textarea"
        });
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
                
                <form method="post" action="LogoutServlet2">
                        <button type="submit">Logout</button>
                </form>
                
                 <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                 <jsp:setProperty name="currentSessionUser" property="*"/>
               
                <%out.println(currentSessionUser.getUser_Name()); %>
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
      
<!--CollapisablePanel1  -->       
            <div id="CollapsiblePanel1" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="1"> &gt; &nbsp; Network Group <span style="color:red; padding-left: 30px">
                      <% out.println(currentSessionUser.getNumberOfMembers()); %></span> </div>
                <div class="CollapsiblePanelContent">
                    <h4>Network Members: </h4>
                   
                   <%
                    
                      try {
                          List<NetworkMemberBean> all_Request = currentSessionUser.getMembers();

                          for (int x = 0; x < all_Request.size(); x++) {
                              NetworkMemberBean RequestItem = all_Request.get(x);
                              out.println("<div class = \"requestdiv\">");

                              out.println("<a href=\"http://newsfoil.com/profiles/" + RequestItem.getMember_ID()
                                      + "profile.html\" target=\"_new\">" + RequestItem.getMember_Name() + " </a> ");

                             // RequestItem.getMember_ID();
                              out.println("<form action=\"CreateMessage.jsp\" id=\"lkup\" method=\"get\"><br/>"
                                      + "<input type=\"hidden\" name=\"requestor\" value=\"" + RequestItem.getMember_ID() + "\"/>"
                                      + "<input type=\"hidden\" name=\"requestorName\" value=\"" + RequestItem.getMember_Name() + "\"/>"
                                      + "<input type=\"submit\" name=\"message\" id=\"accountSettingInput\" value=\"Send Message\"/>"
                                      + "</form>");
                              out.println("</div>");
                          }
                      } catch (Exception ex) {
                      }
                  %> 
            
                </div>
            </div> <!--end of CollapisablePanel1  --> 

<!--CollapisablePanel2  -->             
          <div id="CollapsiblePanel2" class="CollapsiblePanel">
              <div class="CollapsiblePanelTab" tabindex="2"> &gt; &nbsp; Network Requests  <span style="color:red; padding-left: 20px">
                      <%out.println(currentSessionUser.getNumberOfRequest()); %></span>   </div>
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

                              out.println("<a href=\"http://newsfoil.com/profiles/" + RequestItem.getSender_ID()
                                      + "profile.html\" target=\"_new\">" + RequestItem.getRequestor_Name() + " </a> ");

                              RequestItem.getSender_ID();
                              out.println("<form action=\"addMemberServlet\" id=\"lkup\" method=\"post\"><br/>"
                                      + "<input type=\"hidden\" name=\"requestor\" value=\"" + RequestItem.getSender_ID() + "\"/>"
                                      + "<input type=\"hidden\" name=\"requestorName\" value=\"" + RequestItem.getRequestor_Name() + "\"/>"
                                      + "<input type=\"submit\" name=\"requestType\" id=\"accountSettingInput\" value=\"Accept\"/>"
                                      + "<input type=\"submit\" name=\"requestType\" id=\"accountSettingInput\" value=\"Decline\"/>"
                                      + "</form>");
                              out.println("</div>");

                          }
                      } catch (Exception ex) {
                      }


                  %>
              </div>
          </div> <!--end of CollapisablePanel2  -->
          
<!--CollapisablePanel3  -->   
       
            <div id="CollapsiblePanel3" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="3"> &gt; &nbsp; My Articles </div>
                <div class="CollapsiblePanelContent">
                    <form action="lookupArticleServlet" id="lkup">
                        <input type="text" id="accountSettingInput" name="lookupmember">
                        <h4>Search Your Articles</h4>
                        <input type="button" name="userRequest" id="accountSettingInput" value="Search"/>
                    </form>
                </div>
            </div><!--end of CollapisablePanel3  -->

<!--CollapisablePanel4  --> 
            <div id="CollapsiblePanel4" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="4"> &gt; &nbsp; Messages <span style="color:red; padding-left: 40px">
                      <%out.println(currentSessionUser.getNumberOfMessages()); %></span> </div>
                <div class="CollapsiblePanelContent">
                    
                        <h4>Send a Message</h4>
                        <form method="post" action="CreateMessage.jsp">
                        <button type="submit">Send Message</button>
                        </form>
  
            <%
                      try {
                          
                           
                          List<MessageBean> all_Messages = currentSessionUser.getMessages();

                          for (int x = 0; x < all_Messages.size(); x++) {
                              MessageBean RequestMessage = all_Messages.get(x);
                              out.println("<div class = \"requestdiv\">");

                              out.println("<a href=\"http://newsfoil.com/profiles/" + RequestMessage.getFrom_User_id()
                                      + "profile.html\" target=\"_new\">" +  RequestMessage.getFrom_Name() + " </a> ");

                              RequestMessage.getFrom_Name();
                              out.println("<form method=\"get\" action=\"ViewMessage.jsp\">"
                                      + "<input type=\"hidden\" name=\"messageNo\" value=\"" + x + "\"/>"
                                      + "<button type=\"submit\">View</button>"
                                      + "</form>"
                                      );
                              
                              
                              
                              out.println("</div>");

                          }
                      } catch (Exception ex) {
                      }


                  %>
                
                </div>
            </div>
   </div> <!-- end of sidebar1 -->
       
       
     
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
                       <form method="get" action="http://newsfoil.com/profiles/<%=currentSessionUser.getUser_ID()%>profile.html" target="_Blank">
                        <button type="submit">View Profile</button>
                    </form>
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
                        
                        <label class ="lbl">City: &nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="myCity" id="accountSettingInput" value="<%= currentSessionUser.getUser_City() %>"/>
                        </label>
                        
                        <label class ="lbl">State: &nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="myState" id="accountSettingInput" value="<%= currentSessionUser.getUser_State() %>"/>
                        </label>
                        
                        <label class ="lbl">Zip: &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="myZip" id="accountSettingInput" value="<%= currentSessionUser.getUser_Zip() %>"/>
                        </label>
                        
                        
                        <br/><br/>
                        <p></p>
                        
                        <label class ="lbl">Tagline: <input type="text" name="myTagline" id="accountSettingInput" value="<%= currentSessionUser.getUser_Tag_Line() %>"/>
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
                       
                        Bio: 
                        
                        <textarea name="myBio" id="myBio" ><%= currentSessionUser.getUser_Bio() %></textarea>                         
                        <p></p>
                       
                        Education: <textarea name="myEducation" id="myEducation"><%= currentSessionUser.getUser_Education() %></textarea>
                        
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
                <li><a href=http://newsfoil.com/profiles/<%=currentSessionUser.getUser_ID()%>profile.html>Profile</a>&nbsp;</li>
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
