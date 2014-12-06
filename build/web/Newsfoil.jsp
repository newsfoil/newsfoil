<%-- 
    Document   : loginPage
    Created on : Nov 5, 2014, 8:14:01 AM
    Author     : dentm
--%>

<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" 
         %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Newsfoil.com</title>
<link href="main.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
  <div class="header">
  		<div class="logo">
  		<!--<a href="#"><img src="" alt="Insert Logo Here" name="Insert_logo"  height="40" id="Insert_logo" style="background: #8090AB; display:block;" /></a> -->
  		</div>
  		<div class="menubar">
		  
          <a class="menuitem" href="#/">Home</a> &nbsp;
          <a class="menuitem" href="#/account">Account</a>&nbsp;
          <a class="menuitem" href="#/network">Network </a> &nbsp;
          <a class="menuitem" href="#/about">About </a> &nbsp;
          
  		</div>
    
   		<div class="signin">
         <form action="NFLoginServlet" method = "post">             
            <input class="input" type="submit" value="Sign In"/>   
            <input type="hidden" name="targetpage" value="Login"/>
            <input class="input" type="password" name="password" placeholder="password"/>
             <input class="input" type="username" name="username" placeholder="username"/>
        </form>
        <br/><br/> 
        
        <a class="pwitem" href="NewAccount.jsp"> &nbsp; &nbsp;New Account &nbsp;</a>
          <a class="pwitem" href="ForgottenPassword.jsp">Forgot Password &nbsp;&nbsp;</a>
       
   		</div>
        
    <!-- end .header -->
    </div>
    <div class="clearfloat"></div>
  <div class="sidebar1">
    
    <p> </p>
    <!-- end .sidebar1 --></div>
  <div class="content">
  
  <h1>&nbsp;</h1>
  <h1>Newsfoil</h1>
  
  <p>&nbsp;</p>
  
   <ul class="article">
      <li>
        <a href="#"><span class="articletitle">Article 1</span></a>
        <span class="articledate">November 1, 2014</span><span class="articleauthor"> by John Doe</span><br />
       <span class="articledescription">This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</span>
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
    <!-- end .content --></div>
  <div class="sidebar2">
    <h4>You Have a Voice.</h4>
    <h4>Be Heard</h4>
    <p></p><p></p>
    <!-- end .sidebar2 -->
    
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
