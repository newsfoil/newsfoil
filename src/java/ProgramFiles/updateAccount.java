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
            writer = new PrintWriter( "/var/www/html/profiles/" + bean.getUser_ID() + "profile.html", "UTF-8");
            writer.println("<!DOCTYPE html>\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"    <title>"+ bean.getUser_First_Name() +" " + bean.getUser_Last_Name() +" Profile Page</title>\n" +
"        <link href=\"css/profile.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container\">\n" +
"            <div class=\"header\"><!-- end .header -->\n" +
"\n" +
"                <div class=\"fltlft\">\n" +
"                    <img src=\"images/Voice.jpg\" alt=\"Logo\" width=\"192\" height=\"144\" border=\"1\" />\n" +
"                </div>\n" +
"\n" +
"                <div class=\"fltcent\">\n" +
"                    <img src=\"images/logo.jpg\" alt=\"Logo\" align=\"middle\" />\n" +
"                </div>\n" +
"                <div class=\"fltrt\">\n" +
"                    <a class=\"pwitem\" href=\"http://newsfoil.com\">&nbsp; Newsfoil &nbsp;</a>\n" +
"                   <br/><br/>\n" +
"                   <a href=\"http://newsfoil.com:8080/login/About.html\"> About Us</a>\n" +
"                   \n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"                <div class=\"profile\">\n" +
"\n" +
"                   <!-- Add Content\n" +
"                   *\n" +
"                   *\n" +
"                   *\n" +
"                   -->\n" +
"\n" +
"                   <h1>&nbsp;</h1>\n" +
"            <h1></h1>\n" +
"            \n" +
"            <img class=\"imgfltlft\" src=\"image/image\" alt=\" \" width=\"248\" height=\"248\" />\n" +
"            <br>\n" +
"            <span style=\"font-size: 200%; line-height: 1.4; font-weight:bold; padding-left: 10px\">  \n" +
"                "+ bean.getUser_First_Name() + " " + bean.getUser_Middle_Name() + " " + bean.getUser_Last_Name()+ "\n" +
"            </span>\n" +
"                <br>\n" +
"                <span style=\"color: #676662; font-size: 100%; line-height: 1.4; padding-left: 40px\"> \n" +
"                " + bean.getUser_City() +", " + bean.getUser_State() +" " + bean.getUser_Zip() + "\n" +
"            </span>\n" +
"                <br>\n" +
"            <span style=\"color: #a00; font-size: 150%; line-height: 1.4; font-weight:bold; padding-left: 40px\">"
                    + bean.getUser_Tag_Line() +" </span>\n" +
"            <br><br>\n" +
"            <h4> E-Mail: <a href=\"mailto:" + bean.getUser_Email() + "\">" + bean.getUser_Email() +"</a> </h4>\n" +
"            <h4> Political Party: " + bean.getUser_Political_Party() +"</h4><br><br>\n" +
"            \n" +
"           <span style=\"font-size: 150%; line-height: 1.4; font-weight:bold; padding-left: 10px\"> \n" +
"               My Bio </span>\n" +
"           <div class=\"profileText\">\n" +
           bean.getUser_Bio() +"\n" +
"           </div>    \n" +
"           <br><br>\n" +
"            <span style=\"font-size: 150%; line-height: 1.4; font-weight:bold; padding-left: 10px\"> \n" +
"               My Education </span>\n" +
"            <div class=\"profileText\">\n" +
            bean.getUser_Education() +"\n" +
"           </div> \n" +
"            \n" +
"            <br><br>\n" +
"            \n" +
" \n" +
"                   <!-- End Add Content\n" +
"                   *\n" +
"                   *\n" +
"                   *\n" +
"                   -->\n" +
"\n" +
"                    <div class=\"element\"></div>\n" +
"                    <!-- end .content --></div>\n" +
"\n" +
"                <!-- end .container --></div>\n" +
"    </body>\n" +
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
