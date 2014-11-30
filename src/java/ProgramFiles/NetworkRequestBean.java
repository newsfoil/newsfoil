
package ProgramFiles;


public class NetworkRequestBean {
    private String target_Email;
    private String sender_ID;
    private String requestor_Name;

    public String getRequestor_Name() {
        return requestor_Name;
    }

    public void setRequestor_Name(String requestor_Name) {
        this.requestor_Name = requestor_Name;
    }

    public NetworkRequestBean() {
    }

    public String getTarget_Email() {
        return target_Email;
    }

    public void setTarget_Email(String target_Email) {
        this.target_Email = target_Email;
    }

    public String getSender_ID() {
        return sender_ID;
    }

    public void setSender_ID(String sender_ID) {
        this.sender_ID = sender_ID;
    }
    
    
}
