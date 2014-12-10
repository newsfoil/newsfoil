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
import="java.util.List" %> 

  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Create Article</title>
        <link href="css/main.css" rel="stylesheet" type="text/css" />
        <link href= "css/sprycss.css" rel="stylesheet" type="text/css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script src="js/CollapsiblePanel.js" type="text/javascript"></script>
        <script src="js/jquery.validate.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/CollapsibleLists.js"></script>
        <script type="text/javascript" src="js/tinymce/tinymce.min.js"></script>
        
        <script type="text/javascript"> runOnLoad(function(){CollapsibleLists.apply(); });</script>
 
      <script type="text/javascript">  
        tinymce.init({
    selector: "textarea",
    theme: "modern",
    plugins: [
        "advlist autolink lists link image charmap print preview hr anchor pagebreak",
        "searchreplace wordcount visualblocks visualchars code fullscreen",
        "insertdatetime media nonbreaking save table contextmenu directionality",
        "emoticons template paste textcolor colorpicker textpattern"
    ],
    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
    toolbar2: "print preview media | forecolor backcolor emoticons",
    image_advtab: true,
    
});

       
            
    </script>

    </head>

<body>
    
    <ul class="collapsibleList">
  <li>
    Parent item
    <ul>
      <li>Child item</li>
      <li>Child item</li>
    </ul>
  </li>
  <li>
    Parent item
    <ul>
      <li>Child item</li>
      <li>Child item</li>
    </ul>
  </li>
</ul>

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
<!--sidebar 1 -->        
        <div class="sidebar1">

 <ul class="collapsibleList">
  <li>
    Parent item
    <ul>
      <li>Child item</li>
      <li>Child item</li>
    </ul>
  </li>
  <li>
    Parent item
    <ul>
      <li>Child item</li>
      <li>Child item</li>
    </ul>
  </li>
</ul>
            
            
        </div>
<!--end of sidebar1 -->
       
     
                <!-- 
            * <div class="content">
            *
            *<div class="articleForm">
            start content -->
                
                 
        <div class="content2">  
                    
                     <h1 class="articleFormHeading">Create New Article</h1>
                <br>
                    <form id= "articleSubmitForm" name="articleSubmitForm" action="CreateArticle" method = "post"> 
                         <input type="submit" value="Create Article"/>
                        <br/><br/>
                        <h4>Article Title:</h4>
                         <input type="text" style="width: 400px" name="articleTitle" required/> 
                        <br/><br/>
                        <h4>Article Description:</h4>
                          <input type="text" style="width: 800px" name="articleDescription" required/> 
                        <br/><br/>
                        <h4>Article:</h4>
                        <textarea rows="40"  name="articleContent" required></textarea>
                        <br/><br/>
                        <br/><br/>
                        <div class="articleButtonSection">
                           
                        </div>
                    </form> 
            </div>        
                 
                
              <!--   
                
                <div class="content2">  
                 <h1 class="articleFormHeading">Create New Article</h1>
                <br>
                    <form id= "articleSubmitForm" name="articleSubmitForm" action="CreateArticle" method = "post"> 
                         <input type="submit" value="Create Article"/>
                        <br/><br/>
                        <h4>Article Title:</h4>
                         <input type="text" style="width: 400px" name="articleTitle"/> 
                        <br/><br/>
                        <h4>Article Description:</h4>
                          <input type="text" style="width: 800px" name="articleDescription"/> 
                        <br/><br/>
                        <h4>Article:</h4>
                        <textarea rows="40"  name="articleContent" ></textarea>
                        <br/><br/>
                        <br/><br/>
                        <div class="articleButtonSection">
                           
                        </div>
                    </form> 
              
               
	</div>
          end .content -->
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
        CollapsibleLists.applyTo(document.getElementById('ArticleList'));
    </script>
                    
</body>
</html>

