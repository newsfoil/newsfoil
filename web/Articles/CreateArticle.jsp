<%-- 
    Document   : CreateArticle
    Created on : Nov 25, 2014, 1:26:57 AM
    Author     : dent
--%>

<%@ page language="java" contentType="text/html; charset=windows-1256" 
         pageEncoding="windows-1256" 
         import="ProgramFiles.articles.ArticleBean" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Account Settings</title>

        <link href="css/login.css" rel="stylesheet" type="text/css" />

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
                        <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                        <jsp:setProperty name="currentSessionUser" property="*"/>
                        <jsp:getProperty name = "currentSessionUser" property="user_Name" />
                </div>

    

                <div class="accountSettingText">
                    
                   

                    <form id= "account" name="account" action="ArticleServlet" method = "post"> 
                        
                        
                        
                        <hr/><br/>
                        Article Title: <input type="text" name="articleTitle"/> 
                     
                        <br/><br/>
                        <br/><br/>
                        Article: <textarea rows="4" cols="50" name="Article"></textarea>
                        <br/><br/>
                        <br/><br/>
                        <input type="button" value="Create Article"/>

                    </form> 






                    <div class="element"></div>
                    <!-- end .content --></div>

                <!-- end .container --></div>
        </div>
    </body>
</html>



