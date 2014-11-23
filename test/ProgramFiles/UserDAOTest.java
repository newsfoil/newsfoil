/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author larry
 */
public class UserDAOTest {

    @Test
    public void testLogin() {
        UserBean testUser = new UserBean();
        testUser.setUser_Email("testUser@test.org");
        testUser.setUser_Name("testUser");
        testUser.setUser_Password("ff!x23Qz93");
        
        UserBean resultUser = UserDAO.login(testUser);
        assertTrue(resultUser.isValid());
        
    }
}
