/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import java.util.*;


public class UserBean {
    
    
    private String User_ID;
    private String Profile_ID;
    private String message;
    //login information
     private String User_Login;
     private String User_Name;
     private String User_Password; 
     private String User_Email; 
     public boolean valid;  
     //Profile Information
     private String User_Photo;
     private String User_First_Name;
     private String User_Middle_Name;
     private String User_Last_Name;
     private String User_City;
     private String User_State;
     private String User_Zip;
     private String User_Bio;
     private String User_Education;
     private String User_Tag_Line;
     private String User_Political_Party;
     private final ArrayList<NetworkRequestBean> NetworkRequests = new ArrayList();
     private final ArrayList<MessageBean> Messages = new ArrayList();
     private final ArrayList<NetworkMemberBean> Members = new ArrayList();
     int numberOfRequest;
     int numberOfMessages;
     int numberOfMembers;

    public int getNumberOfRequest() {
        return NetworkRequests.size();
    }

    public int getNumberOfMessages() {
        return Messages.size();
    }

    public int getNumberOfMembers() {
        return Members.size();
    }
     

     public List<NetworkMemberBean> getMembers() {
        return Members;
    }

    public void setMembers(NetworkMemberBean Member) {
        this.Members.add(Member);
    }
    public void setMembers(String request) {
        if (request.equals("Delete"))
        this.Members.clear();
    } 
    
     
    public List<MessageBean> getMessages() {
        return Messages;
    }

    public void setMessages(MessageBean Message) {
        this.Messages.add(Message);
    }
     
    public List<NetworkRequestBean> getNetworkRequests() {
        return NetworkRequests;
    }

    public void setNetworkRequests(NetworkRequestBean Request) {
        this.NetworkRequests.add(Request);
    }
    public void setNetworkRequests(String request) {
        if (request.equals("Delete")) 
        this.NetworkRequests.clear();
    }
    public void setNetworkRequests(int requestID) {
        
        for (int i = 0; i< NetworkRequests.size(); i++){
            if (requestID  == Integer.parseInt(NetworkRequests.get(i).getSender_ID()))
                NetworkRequests.remove(i);
    }
       
        
    } 
    
    public String getMessage() {
        if (message == null)
            message ="";
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProfile_ID() {
         if (Profile_ID == null)
            Profile_ID ="";
        return Profile_ID;
    }

    public void setProfile_ID(String Profile_ID) {
        this.Profile_ID = Profile_ID;
    }

    public String getUser_Photo() {
        if (User_Photo == null)
            User_Photo ="";
        return User_Photo;
    }

    public void setUser_Photo(String User_Photo) {
        this.User_Photo = User_Photo;
    }

    public String getUser_First_Name() {
        if (User_First_Name == null)
            User_First_Name ="";
        return User_First_Name;
    }

    public void setUser_First_Name(String User_First_Name) {
        this.User_First_Name = User_First_Name;
    }

    public String getUser_Middle_Name() {
        if (User_Middle_Name ==null)
            User_Middle_Name ="";
        return User_Middle_Name;
    }

    public void setUser_Middle_Name(String User_Middle_Name) {
        this.User_Middle_Name = User_Middle_Name;
    }

    public String getUser_Last_Name() {
        if (User_Last_Name ==null)
            User_Last_Name ="";
        return User_Last_Name;
    }

    public void setUser_Last_Name(String User_Last_Name) {
        this.User_Last_Name = User_Last_Name;
    }

    public String getUser_City() {
        if (User_City ==null)
            User_City="";
        return User_City;
    }

    public void setUser_City(String User_City) {
        this.User_City = User_City;
    }

    public String getUser_State() {
        if(User_State ==null)
            User_State ="";
        return User_State;
    }

    public void setUser_State(String User_State) {
        this.User_State = User_State;
    }

    public String getUser_Zip() {
        if(User_Zip ==null)
            User_Zip ="";
        return User_Zip;
    }

    public void setUser_Zip(String User_Zip) {
        this.User_Zip = User_Zip;
    }

    public String getUser_Bio() {
        if (User_Bio ==null)
            User_Bio ="";
        return User_Bio;
    }

    public void setUser_Bio(String User_Bio) {
        this.User_Bio = User_Bio;
    }

    public String getUser_Education() {
        if (User_Education == null)
            User_Education ="";
        return User_Education;
    }

    public void setUser_Education(String User_Education) {
        this.User_Education = User_Education;
    }

    public String getUser_Tag_Line() {
        if (User_Tag_Line==null)
            User_Tag_Line ="";
        return User_Tag_Line;
    }

    public void setUser_Tag_Line(String User_Tag_Line) {
        this.User_Tag_Line = User_Tag_Line;
    }

    public String getUser_Political_Party() {
        if(User_Political_Party == null)
            User_Political_Party ="";
        return User_Political_Party;
    }

    public void setUser_Political_Party(String User_Political_Party) {
        this.User_Political_Party = User_Political_Party;
    }
        
    
    public String getUser_Login() {
        return User_Login;
    }

    public void setUser_Login(String newUser_login) {
        User_Login = newUser_login;
    }
     
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
