/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author dentm_000
 */
public class updateAccount {
    
    static Connection currentCon = null;
    
     
     public static void accountInsert(UserBean bean) { 
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
       
System.out.println("Going to try " + query);

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
         
          }
 
    
}
