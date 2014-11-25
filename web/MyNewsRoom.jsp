<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=windows-1256" 
 pageEncoding="windows-1256" 
 import="ProgramFiles.UserBean" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My News Room</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
     <div class="header">
        <div class="fltlft">
            <img src="images/Voice.jpg" alt="Logo" width="192" height="144" border="1" />
        </div>
        <div class="fltcent">
            <img src="images/logo.jpg" alt="Logo" align="middle" />
        </div>
        <div class="fltrt">
            
            <% 
            try {    
            UserBean currentUser = (UserBean) session.getAttribute("currentSessionUser");%> 
             Welcome <% out.println(currentUser.getUser_Name());} catch (Exception ex){} 
             %> 
    
            
        </div>
     </div>
    
  		<div class="menubar">
		  
          
          
  		</div>
    
    
    
   		
    <div class="clearfloat"></div>
  <div class="sidebar1">
    
   <a class="menuitem" href="#/">Home</a><br/>
          <a class="menuitem" href="AccountSettings.jsp">Account Settings</a><br/>
          <a class="menuitem" href="network.jsp">Network </a> <br/>
          <a class="menuitem" href="about.jsp">About </a> <br/>
  
  </div>
  <div class="content">
  
  <h1>&nbsp;</h1>
  <h1>Newsfoil</h1>
  
  <p>&nbsp;</p>
  
  <ul class="article">
      <c:forEach items="${articleList}" var="article">
          <li>
            <h1><a href="#">${article.getArticle_Title()}</a></h1>
            <h4><fmt:formatDate pattern="MMMM dd, yyyy" value="${article.getArticle_Date()}" /> by ${article.getUser().getUser_Name()}</h4>
            <h3>${article.getArticle_Description()}</h3>
          </li>
      </c:forEach>
  </ul>

  <!-- TODO: Remove if we like the above template -->
  
  <!--
   <ul class="article">
      <li>
        <a href="#"><span class="articletitle">Article 1</span></a>
        <span class="articledate">November 1, 2014</span><span class="articleauthor"> by John Doe</span><br />
       <span class="articledescription">This is the description of the article that is listed above.  It will have a max length of something, I'm just not sure yet...</span>
      </li>
      <li>
        <h1><a href="#">Article 2</a></h1>
        <h4>November 1, 2014 by John Doe</h4>
       <h3>This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</h3>
      </li>
      <li>
        <h1><a href="#">Article 3</a></h1>
        <h4>November 1, 2014 by John Doe</h4>
       <h3>This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</h3>
      </li>
      <li>
        <h1><a href="#">Article 4</a></h1>
        <h4>November 1, 2014 by John Doe</h4>
       <h3>This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</h3>
      </li>
      
    </ul>
    -->
  
    <!-- end .content --></div>
  <div class="sidebar2">
    <ul class="nav">
     <li><a href="#/account">Latest Article</a>&nbsp;</li>
     <li><a href="#/network">Create Article </a> &nbsp;</li>
     <li><a href="#/about">Your Network </a> &nbsp;</li>
     <li><a href="#/about">Settings </a> &nbsp;</li>
    </ul>
    </div>
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
</html>
