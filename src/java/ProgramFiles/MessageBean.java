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
public class MessageBean {
    
    String user_Subject;
    String user_Message;
    String from_Name;
    int message_ID;
    int from_User_id;
    int to_User_id;

    public int getMessage_ID() {
        return message_ID;
    }

    public void setMessage_ID(int message_ID) {
        this.message_ID = message_ID;
    }

    public String getFrom_Name() {
        return from_Name;
    }

    public void setFrom_Name(String from_Name) {
        this.from_Name = from_Name;
    }

    public int getTo_User_id() {
        return to_User_id;
    }

    public void setTo_User_id(int to_User_id) {
        this.to_User_id = to_User_id;
    }

    public String getUser_Subject() {
        return user_Subject;
    }

    public void setUser_Subject(String user_Subject) {
        this.user_Subject = user_Subject;
    }

    public String getUser_Message() {
        return user_Message;
    }

    public void setUser_Message(String user_Message) {
        this.user_Message = user_Message;
    }

    public int getFrom_User_id() {
        return from_User_id;
    }

    public void setFrom_User_id(int from_User_id) {
        this.from_User_id = from_User_id;
    }
    
}
