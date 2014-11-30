<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256" 
         pageEncoding="windows-1256"  %> 
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
                 <img src="images/Voice.jpg" alt="Logo" width="192" height="144" border="1" />
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

        <div class="menubar">
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
                    <h4>Send a request to join Network: </h4><br/>
                    <form action="emailRequestServlet" id="lkup">
                        <input type="text" id="accountSettingInput" name="lookupmember">
                        <h4>enter email address</h4>
                        <input type="button" name="userRequest" id="accountSettingInput" value="Send a Request"/>
                    </form>
                    <br/>
                    <h3>Member Lookup</h3>
                    <form action="lookupUserServlet" id="lkup">
                        <input type="text" id="accountSettingInput" name="lookupmember">
                        <br/><h4>enter last name </h4>
                        <input type="button" name="userRequest" id="accountSettingInput" value="LookUp"/>
                    </form>
                </div>
            </div>

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
        
        <div class="content">
            <h1>&nbsp;</h1>
            <h1>Newsfoil</h1>
            <p>&nbsp;</p>

            <ul class="article">
                <c:forEach items="${articleList}" var="article">
                    <li>
                        <h1><a href="Article?id=${article.getArticle_Id()}">${article.getArticle_Title()}</a></h1>
                        <h4><fmt:formatDate pattern="MMMM dd, yyyy" value="${article.getArticle_Date()}" /> by ${article.getUser().getUser_Name()}</h4>
                        <h3>${article.getArticle_Description()}</h3>
                    </li>
                </c:forEach>
            </ul>

            <!-- end .content --></div>
        <div class="sidebar2">
            <ul class="nav">
                <li><a href="NFServlet">Home</a>&nbsp;</li>
                <li><a href="CreateArticle">New Article</a>&nbsp;</li>
                <li><a href="ProfilePage">Profile</a>&nbsp;</li>
                <li><a href="AccountSettings.jsp">Settings</a> &nbsp;</li>
                <li><a href="About.html">About</a> &nbsp;</li>
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
