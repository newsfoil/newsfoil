<%-- 
    Document   : CreateArticle
    Created on : Nov 25, 2014, 1:26:57 AM
    Authors     : dent, morales
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256" 
         pageEncoding="windows-1256" 
         
    import="ProgramFiles.articles.ArticleBean" 
    import="ProgramFiles.NetworkRequestBean" 
    import="ProgramFiles.NetworkMemberBean" 
    import="ProgramFiles.MessageBean" 
    import="java.util.List" %> 
         
         
          

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Account Settings</title>

        <link href="<c:url value="css/main.css"/>" rel="stylesheet" type="text/css" />
        <link href="<c:url value="css/sprycss.css"/>" rel="stylesheet" type="text/css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="<c:url value="js/CollapsiblePanel.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/jquery.validate.js"/>" type="text/javascript"></script>
<script type="text/javascript" src="js/tinymce/tinymce.min.js"></script>

<script type="text/javascript">  
          function getParameterByName(name) {
      name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
      var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
          results = regex.exec(location.search);
      return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
          }
</script> 


    </head>

    <body>

        <div class="container">
            
            
            
            <div class="header"><!-- end .header -->

                <div class="fltlft">
                    <img src="<c:url value="images/Voice.jpg"/>" alt="Logo" align="right"  width="192" height="144" border="1" />
                </div>

                <div class="fltcent">
                    <a href="NFServlet"> <img src="<c:url value="images/logo.jpg"/>" alt="Logo" align="middle" /></a>
                </div>

                <div class="fltrt">
                    <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                    <jsp:setProperty name="currentSessionUser" property="*"/>
                    <jsp:getProperty name = "currentSessionUser" property="user_Name" />
                </div>
            </div>

            <div class="menubar"></div>
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
            </div>

            
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
            <div id="CollapsiblePanel3" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="3"> &gt; &nbsp; My Articles </div>
                <div class="CollapsiblePanelContent">
                    <form action="lookupArticleServlet" id="lkup">
                        <input type="text" id="accountSettingInput" name="lookupmember">
                        <h4>Search Your Articles</h4>
                        <input type="button" name="userRequest" id="accountSettingInput" value="Search"/>
                    </form>
               
        <!-- articles...-->        
                   
            <div id="CollapsiblePanel5" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="6"> Network Articles </div>
                <div class="CollapsiblePanelContent">
                    hello
                </div>
            </div>
                    
            <div id="CollapsiblePanel6" class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="5"> Other Articles </div>
                <div class="CollapsiblePanelContent">
                    hello
                </div>
            </div>         
                
         <!-- articles...-->          
                
                </div>
            </div>

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
                                      + "</form>");
                                      
                              
                              out.println("</div>");

                          }
                      } catch (Exception ex) {
                      }
                  %>
             
           
                </div>
            </div>
        </div>
        
            <!-- place text here 
            *
            *
            *
            --->
            
            
            <div class="article-section">
                
                
                
                 <%
                    
                      try {
                          MessageBean this_message = currentSessionUser.getMessages().get(Integer.parseInt(request.getParameter("messageNo")));

                          
                            out.println("<span style=\"font-weight: Bold; font-size: 120%\"> From:</span> <span style=\"font-weight:normal;color:#333; font-size: 100%\">" + this_message.getFrom_Name() + "</span></br>");
                            out.println("<span style=\"font-weight: Bold; font-size: 120%\"> Subject:</span> <span style=\"font-weight:normal;color:#333; font-size: 100%\">" + this_message.getUser_Subject() + "</span></br></br>");
                            out.println("<h2>Message:</h2>"
                                      +"<div class= \"messageText\">"
                                      + this_message.getUser_Message()
                                      + "</div>");
                         
                      } catch (Exception ex) {
                      }
                  %> 
                
              
            </div>
                
                <!-- END place text here 
            *
            *
            *
            --->

            <div class="sidebar2">
                <ul class="nav">
                    <li><a href="NFServlet">Home</a>&nbsp;</li>
                    <li><a href="CreateArticle">New Article</a>&nbsp;</li>
                    <li><a href="ProfilePage">Profile</a>&nbsp;</li>
                    <li><a href="AccountSettings.jsp">Settings</a> &nbsp;</li>
                    <li><a href="About.jsp">About</a> &nbsp;</li>
                </ul>
            </div>
                
        <!-- end .container --></div>

      

        <script>
            $(function () {
                $(".articleForm").validate();
                var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1", {contentIsOpen: false});
                var CollapsiblePanel2 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel2", {contentIsOpen: false});
                var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel3", {contentIsOpen: false});
                var CollapsiblePanel4 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel4", {contentIsOpen: false});
                var CollapsiblePanel5 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel5", {contentIsOpen: false});
                
            });
        </script>
    </body>
</html>



