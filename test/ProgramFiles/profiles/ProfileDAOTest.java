package ProgramFiles.profiles;

import ProgramFiles.UserBean;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Integration tests for profile CRUD operations
 * @author Larry Morales
 */
public class ProfileDAOTest {

    /**
     * Tests whether the profile with the given ID is retrieved
     */
    @Test
    public void testGetProfile() {
        int Profile_ID = 4;
        ProfileBean profile = ProfileDAO.getProfile(Profile_ID);
        assertNotNull(profile);
        assertTrue(profile.getProfile_ID() == 4);
    }
    
    /**
     * Tests whether the profile with the given invalid ID is retrieved (fail test)
     */
    @Test
    public void testGetProfileFail() {
        int Profile_ID = -1;
        ProfileBean profile = ProfileDAO.getProfile(Profile_ID);
        assertNull(profile);
    }
    
    /**
     * Tests whether new profile can be created
     * (Delete Thomas Jefferson's profile in database first)
     */
    @Test
    public void testCreateProfile() {
        ProfileBean profile = new ProfileBean();
        String User_ID = "15";  // testUser
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        profile.setUser(user);
        
        profile.setUser_First_Name("Thomas");
        profile.setUser_Middle_Name("");
        profile.setUser_Last_Name("Jefferson");
        profile.setUser_City("Charlottesville");
        profile.setUser_State("VA");
        profile.setUser_Zip("22902");
        profile.setUser_Tag_Line("The tree of liberty must be refreshed from time to time with the blood of patriots and tyrants.");
        profile.setUser_Political_Party("Democratic-Republican");
        profile.setUser_Bio("From Wikipedia: The third of ten children, Thomas Jefferson was born on April 13, 1743 (April 2, 1743 OS) "
            + "at the family home in a one and a half story farmhouse not far from the Virginia wilderness... "
        );
        profile.setUser_Education("College of William and Mary");
        profile.setUser_Photo("");
        
        boolean success = ProfileDAO.createProfile(profile);
        assertTrue(success);
    }
    
    /**
     * Tests whether profile with invalid user can be created (fail test)
     */
    @Test
    public void testCreateInvalidProfile() {
        ProfileBean profile = new ProfileBean();
        String User_ID = "-1";
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        profile.setUser(user);
        
        boolean success = ProfileDAO.createProfile(profile);
        assertFalse(success);
    }
    
    /**
     * Tests whether existing article can be updated
     */
    @Test
    public void testUpdateProfile() {
        ProfileBean profile = new ProfileBean();
        String User_ID = "15"; // testUser
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        profile.setUser(user);
        
        profile.setProfile_ID(5);
        profile.setUser_First_Name("Attila");
        profile.setUser_Middle_Name("The");
        profile.setUser_Last_Name("Hun");
        profile.setUser_City("Hunnic Empire");
        profile.setUser_State("");
        profile.setUser_Zip("12345");
        profile.setUser_Tag_Line("It takes less courage to criticize the decisions of others than to stand by your own.");
        profile.setUser_Political_Party("Despot");
        profile.setUser_Bio("From Wikipedia: Attila (/ˈætɨlə/ or /əˈtɪlə/; ?–453), "
                + "frequently referred to as Attila the Hun, was the ruler of the Huns from 434 until his death in March 453. "
        );
        profile.setUser_Education("College of William and Mary");
        profile.setUser_Photo("");
        
        boolean success = ProfileDAO.updateProfile(profile);
        assertTrue(success);
    }
    
     /**
     * Tests whether profile with invalid ID can be updated (fail test)
     */
    @Test
    public void testUpdateInvalidProfile() {
        ProfileBean profile = new ProfileBean();
        String User_ID = "-1";
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        profile.setUser(user);
        
        profile.setProfile_ID(-1);
        profile.setUser_Bio("Update Fail Test");
        
        boolean success = ProfileDAO.updateProfile(profile);
        assertFalse(success);
    }
    
    
//    @Test
//    public void testDeleteProfile() {
//        boolean success = ProfileDAO.deleteProfile(8);
//        assertTrue(success);
//    }
}
