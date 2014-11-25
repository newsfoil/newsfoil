package ProgramFiles.profiles;

import ProgramFiles.ConnectionManager;
import ProgramFiles.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Class which handles profile create/retrieve/update/delete database operations.
 * @author Larry Morales
 */
public class ProfileDAO {
    
    private static final String GET_PROFILE = 
            "select * from PROFILES, USERS where PROFILES.User_ID=? "
            + "and USERS.User_ID=PROFILES.User_ID";
    private static final String CREATE_PROFILE = 
            "insert into PROFILES (User_Id, User_First_Name, User_Middle_Name, "
            + "User_Last_Name, User_City, User_State, User_Zip, User_Tag_Line, "
            + "User_Political_Party, User_Bio, User_Education, User_Photo) "
            + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_PROFILE = 
            "update PROFILES set User_Id=?, User_First_Name=?, User_Middle_Name=?, "
            + "User_Last_Name=?, User_City=?, User_State=?, User_Zip=?, "
            + "User_Tag_Line=?, User_Political_Party=?, "
            + "User_Bio=?, User_Education=?, User_Photo=? "
            + "where Profile_Id=?";
    private static final String DELETE_PROFILE =
            "delete from PROFILES where Profile_Id=?";

    
    /**
     * Get a single profile by its owner's user ID.
     * @param User_Id The unique user ID
     * @return <code>ProfileBean</code> representing the profile
     */
    public static ProfileBean getProfile(int User_Id) {

        ProfileBean profile = null;

        // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PROFILE)) {
            
            statement.setInt(1, User_Id);
            ResultSet resultSet = statement.executeQuery();
            
            // process query results
            if (resultSet.next()) {
                profile = new ProfileBean();
                
                // populate user data
                UserBean user = new UserBean();
                user.setUser_Email(resultSet.getString("User_Email"));
                user.setUser_Name(resultSet.getString("User_name"));
                user.setUser_ID(resultSet.getString("User_ID"));
                profile.setUser(user);
                
                // populate profile data
                profile.setProfile_ID(resultSet.getInt("Profile_ID"));
                profile.setUser_First_Name(resultSet.getString("User_First_Name"));
                profile.setUser_Middle_Name(resultSet.getString("User_Middle_Name"));
                profile.setUser_Last_Name(resultSet.getString("User_Last_Name"));
                profile.setUser_City(resultSet.getString("User_City"));
                profile.setUser_State(resultSet.getString("User_State"));
                profile.setUser_Zip(resultSet.getString("User_Zip"));
                profile.setUser_Tag_Line(resultSet.getString("User_Tag_Line"));
                profile.setUser_Political_Party(resultSet.getString("User_Political_Party"));
                profile.setUser_Bio(resultSet.getString("User_Bio"));
                profile.setUser_Education(resultSet.getString("User_Education"));
                profile.setUser_Photo(resultSet.getString("User_Photo"));
                
            }

        } catch (Exception ex) {
            System.err.println("Query GET_PROFILE failed: An Exception has occurred! " + ex);
        }

         // connection resources automatically closed in try-catch-resource syntax
        
        return profile;
    }

    /**
     * Create a new profile.
     * @param profile <code>ProfileBean</code> containing new profile info
     * @return <code>boolean</code> indicating operation success
     */
    public static boolean createProfile(ProfileBean profile) {
        boolean success = false;
        
         // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();  
            PreparedStatement statement = connection.prepareStatement(CREATE_PROFILE);) {
            statement.setString(1, profile.getUser().getUser_ID());
            statement.setString(2, profile.getUser_First_Name());
            statement.setString(3, profile.getUser_Middle_Name());
            statement.setString(4, profile.getUser_Last_Name());
            statement.setString(5, profile.getUser_City());
            statement.setString(6, profile.getUser_State());
            statement.setString(7, profile.getUser_Zip());
            statement.setString(8, profile.getUser_Tag_Line());
            statement.setString(9, profile.getUser_Political_Party());
            statement.setString(10, profile.getUser_Bio());
            statement.setString(11, profile.getUser_Education());
            statement.setString(12, profile.getUser_Photo());
        
            int rows = statement.executeUpdate();
            if(rows > 0) {
                success = true;
            }

        } catch (Exception ex) {
            System.err.println("Query CREATE_PROFILE failed: An Exception has occurred! " + ex);
        }
        
         // connection resources automatically closed in try-catch-resource syntax
        
        return success;
    }

    /**
     * Update an existing profile with the given parameters.
     * @param profile Contains updated profile info (must have valid ID)
     * @return <code>boolean</code> indicating operation success
     */
    public static boolean updateProfile(ProfileBean profile) {
        boolean success = false;
        
        // prepare and execute SQL update
        try (Connection connection = ConnectionManager.getConnection();
              PreparedStatement statement = connection.prepareStatement(UPDATE_PROFILE)) {
            
            statement.setString(1, profile.getUser().getUser_ID());
            statement.setString(2, profile.getUser_First_Name());
            statement.setString(3, profile.getUser_Middle_Name());
            statement.setString(4, profile.getUser_Last_Name());
            statement.setString(5, profile.getUser_City());
            statement.setString(6, profile.getUser_State());
            statement.setString(7, profile.getUser_Zip());
            statement.setString(8, profile.getUser_Tag_Line());
            statement.setString(9, profile.getUser_Political_Party());
            statement.setString(10, profile.getUser_Bio());
            statement.setString(11, profile.getUser_Education());
            statement.setString(12, profile.getUser_Photo());
             statement.setInt(13, profile.getProfile_ID());
            
            int rows = statement.executeUpdate();
            if(rows > 0) {
                success = true;
            }

        } catch (Exception ex) {
            System.err.println("Query UPDATE_PROFILE failed: An Exception has occurred! " + ex);
        }
        
         // connection resources automatically closed in try-catch-resource syntax
        
        return success;
    }

    /**
     * Deletes the profile matching the provided ID.
     * @param Profile_Id The ID of the profile to delete
     * @return <code>boolean</code> indicating operation success
     */
    public static boolean deleteProfile(int Profile_Id) {
        boolean success = false;
        
        // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROFILE)) {
            statement.setInt(1, Profile_Id);
            statement.execute();
            success = true;
        } catch (Exception ex) {
            System.err.println("Query DELETE_PROFILE failed: An Exception has occurred! " + ex);
        }
        
         // connection resources automatically closed in try-catch-resource syntax
        
        return success;
    }
    
}
