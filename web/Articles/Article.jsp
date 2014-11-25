<%-- 
    Document   : Article
    Created on : Nov 25, 2014, 2:07:22 AM
    Author     : dentm_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="currentSessionUser" class = "ProgramFiles.UserBean" scope="session"/>
                    <jsp:setProperty name="currentSessionUser" property="*"/>
                    <jsp:useBean id="articleBean" class = "ProgramFiles.articles.ArticleBean" scope="session"/>
                    <jsp:setProperty name="articleBean" property="*"/>
                    
                    <jsp:getProperty name = "currentSessionUser" property="user_Name" />
                    <jsp:getProperty name = "currentSessionUser" property="user_Name" />
                    
                    
                    <jsp:getProperty name = "articleBean" property="article_Id" />
                    <jsp:getProperty name = "articleBean" property="article_Date" />
                    <jsp:getProperty name = "articleBean" property="article_Description" />
                    <jsp:getProperty name = "articleBean" property="article_Title" />
        
        
        <h1>Hello World!</h1>
    </body>
</html>
