/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import static ProgramFiles.AddUser.currentCon;
import static ProgramFiles.Articles.currentCon;
import static ProgramFiles.UserDAO.currentCon;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author dentm_000
 */
public class Articles {
    
    UserBean user;
    static Connection currentCon = null;
     static ResultSet rs = null; 
     
    
    public void getArticles(){}
   /* currentCon = ConnectionManager.getConnection();   
    stmt=currentCon.createStatement();
    */
}
