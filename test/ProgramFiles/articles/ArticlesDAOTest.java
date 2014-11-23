package ProgramFiles.articles;

import ProgramFiles.UserBean;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Larry Morales
 * 
 */
public class ArticlesDAOTest {
    
    @Test
    public void testGetAllArticles() {
        List<ArticleBean> articleList = ArticlesDAO.getAllArticles();
        assertTrue(articleList.size() > 0);
    }
    
    @Test
    public void testGetArticlesByUser() {
        List<ArticleBean> articleList = ArticlesDAO.getArticlesByUser("10");
        assertTrue(articleList.size() > 0);
    }
    
    @Test
    public void testGetArticle() {
        ArticleBean article = ArticlesDAO.getArticle(4);
        assertNotNull(article);
        assertTrue(article.getArticle_Id() == 4);
    }
    
    @Test
    public void testCreateArticle() {
        ArticleBean article = new ArticleBean();
        
        UserBean user = new UserBean();
        user.setUser_ID("10");
        article.setUser(user);
        
        article.setArticle_Date(new Date(System.currentTimeMillis()));
        article.setArticle_Title("Create Test");
        article.setArticle_Description("JUnite Create Test");
        article.setArticle_Location("http://newsfoil.com");
        article.setArticle_Rank(5);
        
        boolean success = ArticlesDAO.createArticle(article);
        assertTrue(success);
    }
    
    @Test
    public void testUpdateArticle() {
        ArticleBean article = new ArticleBean();
        
        UserBean user = new UserBean();
        user.setUser_ID("10");
        article.setUser(user);
        
        article.setArticle_Id(4);
        article.setArticle_Date(new Date(System.currentTimeMillis()));
        article.setArticle_Title("Update Test");
        article.setArticle_Description("Update Test");
        article.setArticle_Location("http://newsfoil.com");
        article.setArticle_Rank(5);
        
        boolean success = ArticlesDAO.createArticle(article);
        assertTrue(success);
    }
    
//    @Test
//    public void testDeleteArticle() {
//        boolean success = ArticlesDAO.deleteArticle(1);
//        assertTrue(success);
//    }

}
