
package ProgramFiles;

/**
 *
 * @author Mark Dent
 */
public class SentMessageBean {
    String user_Subject;
    String user_Message;
    int from_User_id;
    int to_User_id;

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
