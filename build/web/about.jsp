<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"         
 pageEncoding="windows-1256" 
import="ProgramFiles.articles.ArticleBean" 
import="ProgramFiles.NetworkRequestBean" 
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
