<%-- 
    Document   : CreateArticle
    Created on : Nov 25, 2014, 1:26:57 AM
    Authors     : dent, morales
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=windows-1256" 
         pageEncoding="windows-1256" 
         import="ProgramFiles.articles.ArticleBean" %> 

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

    </head>

    <body>

        <div class="container">


            <div class="header"><!-- end .header -->

                <div class="fltlft">
                    <img src="<c:url value="images/Voice.jpg"/>" alt="Logo" width="192" height="144" border="1" />
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

            <div class="articleForm">
                <h1 class="articleFormHeading">Submit New Article</h1>
                <br>
                    <form id= "articleSubmitForm" name="articleSubmitForm" action="CreateArticle" method = "post"> 
                        <br/><br/>
                        <label class="articleFormLabel"> Article Title:</label> <input type="text" name="articleTitle" required/> 
                        <br/><br/>
                        <br/><br/>
                        <label class="articleFormLabel"> Article Description:</label> <textarea rows="4" name="articleDescription" required></textarea>
                        <br/><br/>
                        <br/><br/>
                        <label class="articleFormLabel"> Article Content:</label> <textarea rows="8"  name="articleContent" required></textarea>
                        <br/><br/>
                        <br/><br/>
                        <div class="articleButtonSection">
                            <input type="submit" value="Create Article"/>
                        </div>
                    </form> 

                    <!-- end .content --></div>

            <!-- end .container --></div>
        </div>

        <div class="sidebar2">
            <ul class="nav">
                <li><a href="NFServlet">Home</a>&nbsp;</li>
                <li><a href="CreateArticle">New Article</a>&nbsp;</li>
                <li><a href="ProfilePage">Profile</a>&nbsp;</li>
                <li><a href="AccountSettings.jsp">Settings</a> &nbsp;</li>
                <li><a href="About.jsp">About</a> &nbsp;</li>
            </ul>
        </div>

        <script>
            $(function () {
                $(".articleForm").validate();
                var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1", {contentIsOpen: false});
                var CollapsiblePanel2 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel2", {contentIsOpen: false});
                var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel3", {contentIsOpen: false});
                var CollapsiblePanel4 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel4", {contentIsOpen: false});
            });
        </script>
    </body>
</html>



