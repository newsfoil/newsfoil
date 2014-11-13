/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

/**
 *
 * @author dentm_000
 */
public class UserBean {
    
    
     private String User_Name;
     private String User_Password; 
     private String User_Email; 
     private String User_ID; 
     public boolean valid; 
     
     
     public String getUser_Email() 
        { return User_Email; } 
        
        public void setUser_Email(String newUser_Email) 
        { User_Email = newUser_Email; } 
        
        public String getUser_ID() 
        { return User_ID; } 
       
        public void setUser_ID(String newUser_ID) 
        { User_ID = newUser_ID; }
      
        public String getUser_Password() 
        { return User_Password; } 
      
        public void setUser_Password(String newUser_Password) 
        { User_Password = newUser_Password; } 
     
        public String getUser_Name() 
        { return User_Name; } 
    
        public void setUser_Name(String newUser_Name) 
        { User_Name = newUser_Name; } 
      
        public boolean isValid() 
        { return valid; } 
     
        public void setValid(boolean newValid) 
        { valid = newValid; } 
    
}
