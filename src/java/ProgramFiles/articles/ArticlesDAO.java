package ProgramFiles.articles;

import ProgramFiles.ConnectionManager;
import ProgramFiles.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class which handles article create/retrieve/update/delete database operations.
 * @author Larry Morales
 */
public class ArticlesDAO {
    
    // SQL Query Templates
    private static final String GET_ALL_ARTICLES = 
            "select * from WORLD_ARTICLES inner join USERS on WORLD_ARTICLES.User_Id=USERS.User_Id order by Article_Date desc";
    private static final String GET_ARTICLES_BY_USER = 
            "select * from WORLD_ARTICLES, USERS where WORLD_ARTICLES.User_ID=? and USERS.User_Id=? order by Article_Date desc";
    private static final String GET_ARTICLE = 
            "select * from WORLD_ARTICLES, USERS where WORLD_ARTICLES.Article_Id=? and USERS.User_ID=WORLD_ARTICLES.User_ID";
    private static final String CREATE_ARTICLE = 
            "insert into WORLD_ARTICLES (User_Id, Article_Rank, Article_Title, Article_Date, Article_Description, Article_Location, Article_Content) values(?,?,?,?,?,?,?)";
    private static final String UPDATE_ARTICLE = 
            "update WORLD_ARTICLES set Article_Rank=?, Article_Title=?, Article_Description=?, Article_Location=?, Article_Content=? where Article_Id=?";
    private static final String DELETE_ARTICLE = 
            "delete from WORLD_ARTICLES where Article_Id=?";

    /**
     * Retrieve all articles in the database, sorted descending by date.
     * @return <code>List</code> of available articles as <code>ArticleBean</code>
     */
    public static List<ArticleBean> getAllArticles() {
        List<ArticleBean> articleList = new ArrayList<>();
        
        // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ARTICLES)) {
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ArticleBean article = new ArticleBean();

                // populate user data
                UserBean user = new UserBean();
                user.setUser_Email(resultSet.getString("User_Email"));
                user.setUser_Name(resultSet.getString("User_name"));
                user.setUser_ID(resultSet.getString("User_ID"));
                article.setUser(user);
                
                // populate article data
                article.setArticle_Id(resultSet.getInt("Article_Id"));
                article.setArticle_Rank(resultSet.getInt("Article_Rank"));
                article.setArticle_Description(resultSet.getString("Article_Description"));
                article.setArticle_Title(resultSet.getString("Article_Title"));
                article.setArticle_Content(resultSet.getString("Article_Content"));
                article.setArticle_Location(resultSet.getString("Article_Location"));
                article.setArticle_Date(resultSet.getDate("Article_Date"));

                articleList.add(article);
            }

        } catch (Exception ex) {
            System.err.println("Query GET_ALL_ARTICLES failed: An Exception has occurred! " + ex);
        }

        // connection resources automatically closed in try-catch-resource syntax
        
        // TODO: make efficient
        Collections.sort(articleList);
        Collections.reverse(articleList);
        
        return articleList;
    }

    /**
     * Retrieve all articles authored by the given user
     * @param User_ID Unique ID representing the author of the articles
     * @return <code>List</code> of articles associated with user
     */
    public static List<ArticleBean> getArticlesByUser(String User_ID) {
        List<ArticleBean> articleList = new ArrayList<>();
        
        // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ARTICLES_BY_USER)) {
            
            statement.setString(1, User_ID);
            statement.setString(2, User_ID);
            ResultSet resultSet = statement.executeQuery();

            // process query results
            while (resultSet.next()) {
                ArticleBean article = new ArticleBean();
               
                // populate user data
                UserBean user = new UserBean();
                user.setUser_Email(resultSet.getString("User_Email"));
                user.setUser_Name(resultSet.getString("User_name"));
                user.setUser_ID(resultSet.getString("User_ID"));
                
                // populate article data
                article.setUser(user);
                article.setArticle_Id(resultSet.getInt("Article_Id"));
                article.setArticle_Rank(resultSet.getInt("Article_Rank"));
                article.setArticle_Description(resultSet.getString("Article_Description"));
                article.setArticle_Title(resultSet.getString("Article_Title"));
                article.setArticle_Content(resultSet.getString("Article_Content"));
                article.setArticle_Location(resultSet.getString("Article_Location"));
                article.setArticle_Date(resultSet.getDate("Article_Date"));
                articleList.add(article);
            }

        } catch (Exception ex) {
            System.err.println("Query GET_ARTICLES_BY_USER failed: An Exception has occurred! " + ex);
        }

         // connection resources automatically closed in try-catch-resource syntax
        
        // TODO: make efficient
        Collections.sort(articleList);
        Collections.reverse(articleList);
  
        return articleList;
    }

    /**
     * Get a single article by its ID.
     * @param Article_Id The unique article ID
     * @return <code>ArticleBean</code> representing the article
     */
    public static ArticleBean getArticle(int Article_Id) {

        ArticleBean article = null;

        // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ARTICLE)) {
            
            statement.setInt(1, Article_Id);
            ResultSet resultSet = statement.executeQuery();
            
            // process query results
            if (resultSet.next()) {
                article = new ArticleBean();
                
                // populate user data
                UserBean user = new UserBean();
                user.setUser_Email(resultSet.getString("User_Email"));
                user.setUser_Name(resultSet.getString("User_name"));
                user.setUser_ID(resultSet.getString("User_ID"));
                article.setUser(user);
                
                // populate article data
                article.setArticle_Id(resultSet.getInt("Article_Id"));
                article.setArticle_Rank(resultSet.getInt("Article_Rank"));
                article.setArticle_Description(resultSet.getString("Article_Description"));
                article.setArticle_Title(resultSet.getString("Article_Title"));
                article.setArticle_Content(resultSet.getString("Article_Content"));
                article.setArticle_Location(resultSet.getString("Article_Location"));
                article.setArticle_Date(resultSet.getDate("Article_Date"));
            }

        } catch (Exception ex) {
            System.err.println("Query GET_ARTICLE failed: An Exception has occurred! " + ex);
        }

         // connection resources automatically closed in try-catch-resource syntax
        
        return article;
    }

    /**
     * Create a new article.
     * @param article <code>ArticleBean</code> containing new article info
     * @return <code>boolean</code> indicating operation success
     */
    public static boolean createArticle(ArticleBean article) {
        boolean success = false;
        
         // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();  
            PreparedStatement statement = connection.prepareStatement(CREATE_ARTICLE);) {
            statement.setString(1, article.getUser().getUser_ID());
            statement.setInt(2, article.getArticle_Rank());
            statement.setString(3, article.getArticle_Title());
            statement.setDate(4, new java.sql.Date(article.getArticle_Date().getTime()));
            statement.setString(5, article.getArticle_Description());
            statement.setString(6, article.getArticle_Location());
            statement.setString(7, article.getArticle_Content());
            success = statement.execute();

        } catch (Exception ex) {
            System.err.println("Query CREATE_ARTICLE failed: An Exception has occurred! " + ex);
        }
        
         // connection resources automatically closed in try-catch-resource syntax
        
        return success;
    }

    /**
     * Update an existing article with the given parameters.
     * @param article Contains updated article info (must have valid ID)
     * @return 
     */
    public static boolean updateArticle(ArticleBean article) {
        boolean success = false;
        
        // prepare and execute SQL update
        try (Connection connection = ConnectionManager.getConnection();
              PreparedStatement statement = connection.prepareStatement(UPDATE_ARTICLE)) {
            
            statement.setInt(1, article.getArticle_Rank());
            statement.setString(2, article.getArticle_Title());
            statement.setString(3, article.getArticle_Description());
            statement.setString(4, article.getArticle_Location());
            statement.setString(5, article.getArticle_Content());
            statement.setInt(6, article.getArticle_Id());
            int rows = statement.executeUpdate();
            if(rows > 0) {
                success = true;
            }

        } catch (Exception ex) {
            System.err.println("Query UPDATE_ARTICLE failed: An Exception has occurred! " + ex);
        }
        
         // connection resources automatically closed in try-catch-resource syntax
        
        return success;
    }

    /**
     * Deletes the article matching the provided ID.
     * @param Article_Id The ID of the article to delete
     * @return <code>boolean</code> indicating operation success
     */
    public static boolean deleteArticle(int Article_Id) {
        boolean success = false;
        
        // prepare and execute SQL query
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLE)) {
            statement.setInt(1, Article_Id);
            statement.execute();
            success = true;
        } catch (Exception ex) {
            System.err.println("Query DELETE_ARTICLE failed: An Exception has occurred! " + ex);
        }
        
         // connection resources automatically closed in try-catch-resource syntax
        
        return success;
    }

}
