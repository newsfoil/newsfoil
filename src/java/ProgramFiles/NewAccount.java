
package ProgramFiles;


public class NewAccount {
    
    String jspMessage;
    String username;
    boolean email;
    boolean userName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NewAccount() {
        this.jspMessage = "";
    }

    public String getJspMessage() {
        return jspMessage;
    }

    public void setJspMessage(String jspMessage) {
        this.jspMessage = jspMessage;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isUserName() {
        return userName;
    }

    public void setUserName(boolean userName) {
        this.userName = userName;
    }

   
    
    
}
