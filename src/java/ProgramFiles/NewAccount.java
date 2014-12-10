
package ProgramFiles;


public class NewAccount {
    
   private String jspMessage;
   private String username;
   private String useremail;
   private String userPassword;
   private String userFristName;
   private String userMiddleName;
   private String userLastName;
   private boolean email;
   private int userID;
   private boolean userName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFristName() {
        return userFristName;
    }

    public void setUserFristName(String userFristName) {
        this.userFristName = userFristName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

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
