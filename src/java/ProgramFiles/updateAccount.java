/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dentm_000
 */
public class updateAccount {
    
    static Connection currentCon = null;
    
     
     public static void accountInsert(UserBean bean) throws FileNotFoundException { 
//preparing some objects for connection 
         Statement stmt = null; 
       
        
String query ="UPDATE `newsfoil`.`PROFILES` SET `User_First_Name` = '" + bean.getUser_First_Name()+"',\n" +
"`User_Middle_Name` = '" + bean.getUser_Middle_Name()+"',\n" +
"`User_Last_Name` = '" + bean.getUser_Last_Name()+"',\n" +
"`User_City` = '" + bean.getUser_City()+"',\n" +
"`User_State` = '" + bean.getUser_State()+"',\n" +
"`User_Zip` = '" + bean.getUser_Zip()+"',\n" +
"`User_Tag_Line` = '" + bean.getUser_Tag_Line()+"',\n" +
"`User_Political_Party` = '" + bean.getUser_Political_Party()+"',\n" +
"`User_Bio` = '" + bean.getUser_Bio()+"',\n" +
"`User_Education` = '" + bean.getUser_Education()+"' WHERE `PROFILES`.`User_ID` ="+bean.getUser_ID();        
       


         try { 
//connect to DB 
             currentCon = ConnectionManager.getConnection();   
             stmt=currentCon.createStatement();
             boolean T =stmt.execute(query);
             
            currentCon.close();
         }
         catch (Exception ex) 
         { 
 System.out.println("didn't work except: " + ex);
            
         }
         
         
// exception handling 
         finally { 
             
             
             
             if (currentCon != null) 
             { try 
             { currentCon.close(); } 
             catch (Exception e) { } 
             
             currentCon = null; } }
         
    PrintWriter writer;
        try {
            writer = new PrintWriter( "c:\\login\\" + bean.getUser_Last_Name()+"_"+bean.getUser_Last_Name()+ bean.getUser_ID() + "Profile.jsp", "UTF-8");
            writer.println("<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>\n" +
"<%@ taglib prefix=\"fmt\" uri=\"http://java.sun.com/jsp/jstl/fmt\" %>\n" +
"<%@ page language=\"java\" contentType=\"text/html; charset=windows-1256\" \n" +
"         pageEncoding=\"windows-1256\"  %> \n" +
"\n" +
"\n" +
"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> \n" +
"\n" +
"\n" +
"<head>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"    <title>"+ bean.getUser_First_Name() +" " + bean.getUser_Last_Name() +" Profile Page</title>\n" +
"    <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
"    <link href=\"css/sprycss.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
"    <script src=\"js/CollapsiblePanel.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"\n" +
"    <div class=\"container\">\n" +
"        <div class=\"header\">\n" +
"            <div class=\"fltlft\">\n" +
"                <img src=\"images/Voice.jpg\" alt=\"Logo\" width=\"192\" height=\"144\" border=\"1\" /></a>\n" +
"            </div>\n" +
"            <div class=\"fltcent\">\n" +
"                <a href=\"NFServlet\"><img src=\"images/logo.jpg\" alt=\"Logo\" align=\"middle\" /></a>\n" +
"            </div>\n" +
"            <div class=\"fltrt\">\n" +
"\n" +
"\n" +
"                <jsp:useBean id=\"currentSessionUser\" class = \"ProgramFiles.UserBean\" scope=\"session\"/>\n" +
"                <jsp:setProperty name=\"currentSessionUser\" property=\"*\"/>\n" +
"                <jsp:getProperty name = \"currentSessionUser\" property=\"user_Name\" />\n" +
"\n" +
"            </div>\n" +
"        </div>\n" +
"\n" +
"        <div class=\"menubar\">\n" +
"\n" +
"\n" +
"\n" +
"        </div>\n" +
"\n" +
"\n" +
"        <div class=\"clearfloat\"></div>\n" +
"        <div class=\"sidebar1\">\n" +
"\n" +
"\n" +
"\n" +
"            <div class = \"influence\">\n" +
"                Influence\n" +
"                <br/>\n" +
"                Current:  58%\n" +
"                <br/>\n" +
"                Variance: 46%\n" +
"                <br/>\n" +
"                Network Factor: 120%\n" +
"                <br/><br/><br/>\n" +
"\n" +
"\n" +
"            </div>     \n" +
"            <div id=\"CollapsiblePanel1\" class=\"CollapsiblePanel\">\n" +
"                <div class=\"CollapsiblePanelTab\" tabindex=\"1\"> &gt; &nbsp; Network Group </div>\n" +
"                <div class=\"CollapsiblePanelContent\">\n" +
"                    <h4>Network Members: </h4>\n" +
"                    This will contain a list of all members in network\n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"            <div id=\"CollapsiblePanel2\" class=\"CollapsiblePanel\">\n" +
"                <div class=\"CollapsiblePanelTab\" tabindex=\"2\"> &gt; &nbsp; Network Requests </div>\n" +
"                <div class=\"CollapsiblePanelContent\">\n" +
"                    <h4>Send a request to join Network: </h4><br/>\n" +
"                    <form action=\"emailRequestServlet\" id=\"lkup\">\n" +
"                        <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\n" +
"                        <h4>enter email address</h4>\n" +
"                        <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"Send a Request\"/>\n" +
"                    </form>\n" +
"                    <br/>\n" +
"                    <h3>Member Lookup</h3>\n" +
"                    <form action=\"lookupUserServlet\" id=\"lkup\">\n" +
"                        <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\n" +
"                        <br/><h4>enter last name </h4>\n" +
"                        <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"LookUp\"/>\n" +
"                    </form>\n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"            <div id=\"CollapsiblePanel3\" class=\"CollapsiblePanel\">\n" +
"                <div class=\"CollapsiblePanelTab\" tabindex=\"3\"> &gt; &nbsp; My Articles </div>\n" +
"                <div class=\"CollapsiblePanelContent\">\n" +
"                    <form action=\"lookupArticleServlet\" id=\"lkup\">\n" +
"                        <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\n" +
"                        <h4>Search Your Articles</h4>\n" +
"                        <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"Search\"/>\n" +
"                    </form>\n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"            <div id=\"CollapsiblePanel4\" class=\"CollapsiblePanel\">\n" +
"                <div class=\"CollapsiblePanelTab\" tabindex=\"4\"> &gt; &nbsp; Messages </div>\n" +
"                <div class=\"CollapsiblePanelContent\">\n" +
"                    <form action=\"sendmessage\" id=\"lkup\">\n" +
"                        <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\n" +
"                        <h4>Send a Message</h4>\n" +
"                        <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"Message\"/>\n" +
"                    </form>\n" +
"\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"\n" +
"        <div class=\"content\">\n" +
"\n" +
"            <h1>&nbsp;</h1>\n" +
"            <h1></h1>\n" +
"            <div class=\"find\">\n" +
"                <label for=\"search\">Search Writers: </label><input type=\"text\" name=\"search\" id=\"search\" value=\"username\">&nbsp;<input type=\"button\" value=\"Search\" onClick=\"populateform()\"/><br><br>\n" +
"            </div>\n" +
"            <h1><jsp:getProperty name = \"currentSessionUser\" property=\"user_Name\" /> Profile</h1>\n" +
"            <div class=\"tagline\"><%= currentSessionUser.getUser_Tag_Line()%></div>\n" +
"            <p>&nbsp;</p>\n" +
"            <img class=\"imgfltlft\" src=\"image/image\" alt=\"userimage\" width=\"248\" height=\"248\" />\n" +
"\n" +
"\n" +
"            <h2>Profile:</h2>\n" +
"            <h4>" + bean.getUser_First_Name() + " " + bean.getUser_Middle_Name() + " " + bean.getUser_Last_Name() + "\n" +
"            <br><br>\n" +
"            " + bean.getUser_City() +", " + bean.getUser_State() +" "+ bean.getUser_Zip() +"\n" +
"            <h4> E-Mail: "+ bean.getUser_Email()+ "</h4>\n" +
"            <h4> Political Party: " + bean.getUser_Political_Party() + "</h4><br><br>\n" +
"\n" +
"\n" +
"            <!-- end .content --></div>\n" +
"         <div class=\"sidebar2\">\n" +
"            <ul class=\"nav\">\n" +
"                <li><a href=\"NFServlet\">Home</a>&nbsp;</li>\n" +
"                <li><a href=\"CreateArticle\">New Article</a>&nbsp;</li>\n" +
"                <li><a href=\"ProfilePage\">Profile</a>&nbsp;</li>\n" +
"                <li><a href=\"AccountSettings.jsp\">Settings</a> &nbsp;</li>\n" +
"                <li><a href=\"About.jsp\">About</a> &nbsp;</li>\n" +
"            </ul>\n" +
"        </div>\n" +
"\n" +
"        <div class=\"footer\">\n" +
"            <p></p>\n" +
"            <!-- end .footer --></div>\n" +
"        <!-- end .container --></div>\n" +
"\n" +
"\n" +
"    <script type=\"text/javascript\">\n" +
"        var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel1\", {contentIsOpen: false});\n" +
"        var CollapsiblePanel2 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel2\", {contentIsOpen: false});\n" +
"        var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel3\", {contentIsOpen: false});\n" +
"        var CollapsiblePanel4 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel4\", {contentIsOpen: false});\n" +
"    </script>\n" +
"</body>\n" +
"</html>\n" +
"");
            System.out.println("it is written... ");
            writer.close();     
         
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(updateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

         
          }
     
     
     private static void createProfilePage(){
     
     
     }
 
    
}
