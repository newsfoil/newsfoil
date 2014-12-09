<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"         
 pageEncoding="windows-1256" 
import="ProgramFiles.articles.ArticleBean" 
import="ProgramFiles.NetworkRequestBean" 
import="ProgramFiles.NetworkMemberBean" 
import="ProgramFiles.MessageBean" 
import="java.util.List" %> 

           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My News Room</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="css/sprycss.css" rel="stylesheet" type="text/css" />
    <script src="js/CollapsiblePanel.js" type="text/javascript"></script>

</head>

<body>

    <div class="container">
        
       <!-- header -->        
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
    
<!-- Sidebar1 --> 
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
              <div class="content2">  
                  
             <h1>About Newsfoil.com</h1>
	
		
		<br>
		<p>Newsfoil.com is an interactive website where users can read news articles and rank the 
		articles.  Users are able to post their own articles. The ranking system for articles consists
		of 3 components - the “weighted score”, ”Number of Rankings” and “Primacy”.  The weighted 
		score and number of rankings come from the user rankings and are based on the “influence” of 
		the users.  Users are able to create “news networks”. A news network consists of other users 
		on the site.  A user can invite any user he/she wants to be part of their news network.  The 
		user has their own page and will receive articles to their page.  The user will receive 5 
		articles in each subject area they choose based on the rankings of the articles.  They will 
		also receive one random “wildcard” article that is not at the top of their list, but has met 
		some minimal requirements.  The user also receives all articles posted by members in their 
		network, regardless of ranking, the most recent ones listed first. Below is a more detailed 
		description of how rankings are calculated:</p>
		
                <h3>INFLUENCE:</h3>
		<p>
		Each user has “influence” which is a gauge of how much impact their rating will have.  Influence 
		is based on how they rank articles.  Two-thirds of this score will be based on if they rank the 
		articles higher or lower than their average ranking. Ranking articles lower than their average 
		increases their influence but lowers their average ranking.  Ranking articles high reduces their 
		influence but increases their average ranking.  The remaining one-third of the formula will be 
		based on the distribution of their rankings.  If the user fully distributes their ratings (say 
		for 10 articles they rate them 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 then they would have a perfect score, 
		any deviation will reduce this score).</p>
		
                <h3> WEIGHTED SCORE:</h3><p>
		The weighted score of an article is based on the ranking and influence of the individual.  If a 
		person has 50% influence and rates an article a 10, the score will be 5/.5 so the articles score 
		would be 10.00.  However if another user with 100% influence rates the same article a 0 his/her 
		score would be added 0/1 so the new score would be 5/1.5 or 3.33.  This allows users with more 
		influence to have a greater impact on the article.</p>
		
                <h3>NUMBER OF RANKINGS:</h3>
		
                <p>    This is simply the influence portion of the equation.  If two people rate the article, one having 
		an influence of 50% and another with an influence of 100%, the number of rankings will be 1.5.  
		This number always increases as the article is rated.  This number is then divided by the article 
		with the highest number of rankings.  If the lead article number of rankings is 50, and another 
		article has 25 rankings, the lead article will score 100% in this area and the other article will 
		have 25/50 or 50%.</p>
		
		<h3>PRIMACY:</h3>
		
                <p>    This portion of the ranking is based on how recently an article was posted.  Articles start out 
		with 100% and lose 1 percent every day until it reaches 0.</p>
	</div>
          <!-- end .content -->
            <!-- 
            *
            *
            
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
