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
   <a class="menuitem" href="ProfilePage.jsp">Profile </a> <br/>
   <a class="menuitem" href="network.jsp">Network </a> <br/>
   <a class="menuitem" href="about.jsp">About </a> <br/>
  
  </div>
  <div class="content">
  
  <h1>&nbsp;</h1>
  <h1>Newsfoil</h1>
  
  <p>&nbsp;</p>
  
    <h1>%Username%&#39;s Profile</h1>
	<form target="_blank" onsubmit="return window.confirm(&quot;You are submitting information to an external page.\nAre you sure?&quot;);">
		<fieldset>
			<legend>Profile:</legend>
			Name: David Yox<br>
			E-Mail: <a href="mailto:daveyox@gmail.com" target="_blank">daveyox@gmail.com</a><br>
			Member Since: October 20, 2014<br>
			Articles Written: 3<br>
			Articles Rated: 1<br>
			Favorite Genre: Technology<br>
		</fieldset>
	</form>
  
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

