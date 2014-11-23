package ProgramFiles.articles;

import ProgramFiles.UserBean;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Larry Morales
 * Integration tests for article CRUD operations
 * 
 */
public class ArticlesDAOTest {
    
    
    /**
     * Tests whether all available articles are retrieved
     */
    @Test
    public void testGetAllArticles() {
        List<ArticleBean> articleList = ArticlesDAO.getAllArticles();
        assertTrue(articleList.size() > 0);
    }
    
    /**
     * Tests whether all articles from given user are retrieved
     */
    @Test
    public void testGetArticlesByUser() {
        String User_ID = "10";
        List<ArticleBean> articleList = ArticlesDAO.getArticlesByUser(User_ID);
        assertTrue(articleList.size() > 0);
    }
    
    /**
     * Tests whether the article with the given ID is retrieved
     */
    @Test
    public void testGetArticle() {
        int Article_ID = 4;
        ArticleBean article = ArticlesDAO.getArticle(Article_ID);
        assertNotNull(article);
        assertTrue(article.getArticle_Id() == 4);
    }
    
    /**
     * Tests whether the article with the given invalid ID is retrieved (fail test)
     */
    @Test
    public void testGetArticleFail() {
        int Article_ID = -1;
        ArticleBean article = ArticlesDAO.getArticle(Article_ID);
        assertNull(article);
    }
    
    /**
     * Tests whether new article can be created
     */
    @Test
    public void testCreateArticle() {
        ArticleBean article = new ArticleBean();
        String User_ID = "10";
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        article.setUser(user);
        
        article.setArticle_Date(new Date(System.currentTimeMillis()));
        article.setArticle_Title("Create Test");
        article.setArticle_Description("JUnit Create Test");
        article.setArticle_Location("http://newsfoil.com");
        article.setArticle_Rank(5);
        
        boolean success = ArticlesDAO.createArticle(article);
        assertTrue(success);
    }
    
    /**
     * Tests whether article with invalid user can be created (fail test)
     */
    @Test
    public void testCreateInvalidArticle() {
        ArticleBean article = new ArticleBean();
        String User_ID = "-1";
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        article.setUser(user);
        
        article.setArticle_Date(new Date(System.currentTimeMillis()));
        article.setArticle_Title("Create Fail Test");
        article.setArticle_Description("Create Fail Test");
        article.setArticle_Location("http://newsfoil.com");
        article.setArticle_Rank(5);
        
        boolean success = ArticlesDAO.createArticle(article);
        assertFalse(success);
    }
    
    /**
     * Tests whether existing article can be updated
     */
    @Test
    public void testUpdateArticle() {
        ArticleBean article = new ArticleBean();
        String User_ID = "10";
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        article.setUser(user);
        
        article.setArticle_Id(4);
        article.setArticle_Date(new Date(System.currentTimeMillis()));
        article.setArticle_Title("Update Test");
        article.setArticle_Description("Update Test");
        article.setArticle_Location("http://newsfoil.com");
        article.setArticle_Rank(5);
        
        boolean success = ArticlesDAO.updateArticle(article);
        assertTrue(success);
    }
    
     /**
     * Tests whether article with invalid ID can be updated (fail test)
     */
    @Test
    public void testUpdateInvalidArticle() {
        ArticleBean article = new ArticleBean();
        String User_ID = "-1";
        
        UserBean user = new UserBean();
        user.setUser_ID(User_ID);
        article.setUser(user);
        
        article.setArticle_Id(-1);
        article.setArticle_Date(new Date(System.currentTimeMillis()));
        article.setArticle_Title("Update Fail Test");
        article.setArticle_Description("Update Faile Test");
        article.setArticle_Location("http://newsfoil.com");
        article.setArticle_Rank(5);
        
        boolean success = ArticlesDAO.updateArticle(article);
        assertFalse(success);
    }
    
//    @Test
//    public void testDeleteArticle() {
//        boolean success = ArticlesDAO.deleteArticle(1);
//        assertTrue(success);
//    }

}
