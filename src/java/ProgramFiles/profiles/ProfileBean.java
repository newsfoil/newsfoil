package ProgramFiles.profiles;

import ProgramFiles.UserBean;

/**
 * Model class representing a user profile.
 * @author Larry Morales
 */
public class ProfileBean {
    
    private UserBean user;
    private int Profile_ID;
    private String User_First_Name;
    private String User_Middle_Name;
    private String User_Last_Name;
    private String User_City;
    private String User_State;
    private String User_Zip;
    private String User_Tag_Line;
    private String User_Political_Party;
    private String User_Bio;
    private String User_Education;
    private String User_Photo;
    
    public ProfileBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public ProfileBean(UserBean user, String User_First_Name, String User_Middle_Name, String User_Last_Name, String User_City, String User_State, String User_Zip, String User_Tag_Line, String User_Political_Party, String User_Bio, String User_Education, String User_Photo) {
        this.user = user;
        this.User_First_Name = User_First_Name;
        this.User_Middle_Name = User_Middle_Name;
        this.User_Last_Name = User_Last_Name;
        this.User_City = User_City;
        this.User_State = User_State;
        this.User_Zip = User_Zip;
        this.User_Tag_Line = User_Tag_Line;
        this.User_Political_Party = User_Political_Party;
        this.User_Bio = User_Bio;
        this.User_Education = User_Education;
        this.User_Photo = User_Photo;
    }

    /**
     * Retrieves the unique ID for this profile.
     * @return Profile ID
     */
    public int getProfile_ID() {
        return Profile_ID;
    }

    /**
     * Sets the unique ID for this profile.
     * @param Profile_ID Profile ID
     */
    public void setProfile_ID(int Profile_ID) {
        this.Profile_ID = Profile_ID;
    }
    
    /**
     * Retrieves the user associated with this profile.
     * @return <code>UserBean</code> representing the profile's owner
     */
    public UserBean getUser() {
        return user;
    }

    /**
     * Sets the user associated with this profile.
     * @param user <code>UserBean</code> representing the profile's owner
     */
    public void setUser(UserBean user) {
        this.user = user;
    }

    /**
     * Retrieves the profile owner's first name.
     * @return First name
     */
    public String getUser_First_Name() {
        return User_First_Name;
    }

    /**
     * Sets the profile owner's first name.
     * @param User_First_Name  First name
     */
    public void setUser_First_Name(String User_First_Name) {
        this.User_First_Name = User_First_Name;
    }

    /**
     * Retrieves the profile owner's middle name.
     * @return Middle name
     */
    public String getUser_Middle_Name() {
        return User_Middle_Name;
    }

    /**
     * Sets the profile owner's middle name.
     * @param User_Middle_Name Middle name
     */
    public void setUser_Middle_Name(String User_Middle_Name) {
        this.User_Middle_Name = User_Middle_Name;
    }

    /**
     * Retrieves the profile owner's last name.
     * @return Last name
     */
    public String getUser_Last_Name() {
        return User_Last_Name;
    }

    /**
     * Sets the profile owner's last name.
     * @param User_Last_Name Last name
     */
    public void setUser_Last_Name(String User_Last_Name) {
        this.User_Last_Name = User_Last_Name;
    }

    /**
     * Retrieves the profile owner's city.
     * @return City
     */
    public String getUser_City() {
        return User_City;
    }

    /**
     * Sets the profile owner's city.
     * @param User_City  City
     */
    public void setUser_City(String User_City) {
        this.User_City = User_City;
    }

    /**
     * Retrieves the profile owner's state.
     * @return State
     */
    public String getUser_State() {
        return User_State;
    }

    /**
     * Sets the profile owner's state.
     * @param User_State State
     */
    public void setUser_State(String User_State) {
        this.User_State = User_State;
    }

    /**
     * Retrieves the profile owner's zip code.
     * @return Zip Code
     */
    public String getUser_Zip() {
        return User_Zip;
    }

    /**
     * Sets the profile owner's zip code.
     * @param User_Zip Zip code
     */
    public void setUser_Zip(String User_Zip) {
        this.User_Zip = User_Zip;
    }

    /**
     * Retrieves the profile owner's tag line.
     * @return tag line
     */
    public String getUser_Tag_Line() {
        return User_Tag_Line;
    }

    /**
     * Sets the profile owner's tag line.
     * @param User_Tag_Line Tag line
     */
    public void setUser_Tag_Line(String User_Tag_Line) {
        this.User_Tag_Line = User_Tag_Line;
    }

    /**
     * Retrieves the profile owner's political party.
     * @return Political party
     */
    public String getUser_Political_Party() {
        return User_Political_Party;
    }

    /**
     * Sets the profile owner's political party.
     * @param User_Political_Party Political party
     */
    public void setUser_Political_Party(String User_Political_Party) {
        this.User_Political_Party = User_Political_Party;
    }

    /**
     * Retrieves the profile owner's bio.
     * @return Bio
     */
    public String getUser_Bio() {
        return User_Bio;
    }

    /**
     * Sets the profile owner's bio.
     * @param User_Bio Bio
     */
    public void setUser_Bio(String User_Bio) {
        this.User_Bio = User_Bio;
    }

    /**
     * Retrieves the profile owner's education.
     * @return Education
     */
    public String getUser_Education() {
        return User_Education;
    }

    /**
     * Sets the profile owner's education.
     * @param User_Education Education
     */
    public void setUser_Education(String User_Education) {
        this.User_Education = User_Education;
    }

    /**
     * Retrieves the URL of the profile owner's photo.
     * @return Photo URL
     */
    public String getUser_Photo() {
        return User_Photo;
    }

    /**
     * Sets the URL of the profile owner's photo.
     * @param User_Photo Photo URL
     */
    public void setUser_Photo(String User_Photo) {
        this.User_Photo = User_Photo;
    }
    
}
