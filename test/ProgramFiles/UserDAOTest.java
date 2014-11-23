package ProgramFiles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Larry Morales
 * Integration tests for login functionality
 */
public class UserDAOTest {

    /**
     * Test whether a valid user object can login
     */
    @Test
    public void testLogin() {
        UserBean testUser = new UserBean();
        testUser.setUser_Email("testUser@test.org");
        testUser.setUser_Name("testUser");
        testUser.setUser_Password("ff!x23Qz93");
        
        UserBean resultUser = UserDAO.login(testUser);
        assertTrue(resultUser.isValid());
        
    }
    
    /**
     * Test whether an invalid user can login (fail test)
     */
    @Test
    public void testLoginFail() {
        UserBean testUser = new UserBean();
        testUser.setUser_Email("nobody@not-in-database.org");
        testUser.setUser_Name("nobody");
        testUser.setUser_Password("password");
        
        UserBean resultUser = UserDAO.login(testUser);
        assertFalse(resultUser.isValid());
        
    }
}
