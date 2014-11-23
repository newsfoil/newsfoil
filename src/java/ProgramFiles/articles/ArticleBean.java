package ProgramFiles.articles;

import ProgramFiles.UserBean;
import java.util.Date;

/**
 *
 * @author Larry Morales
 * Model class representing an article.
 */
public class ArticleBean {

    private Date Article_Date;
    private String Article_Description;
    private int Article_Id;
    private int Article_Rank;
    private String Article_Title;
    private String Article_Location;
    private UserBean User;

    public ArticleBean() {
        this(null, null, -1, -1, null, null, new UserBean());
    }

    public ArticleBean(
            Date Article_Date,
            String Article_Description,
            int Article_Id,
            int Article_Rank,
            String Article_Title,
            String Article_Location,
            UserBean User
    ) {
        this.Article_Date = Article_Date;
        this.Article_Description = Article_Description;
        this.Article_Id = Article_Id;
        this.Article_Rank = Article_Rank;
        this.Article_Title = Article_Title;
        this.Article_Location = Article_Location;
        this.User = User;
    }

    /**
     * Retrieves the article creation date.
     * @return <code>Date</code> article was created
     */
    public Date getArticle_Date() {
        return Article_Date;
    }

    /**
     * Sets the article creation date.
     * @param Article_Date <code>Date</code> of article creation
     */
    public void setArticle_Date(Date Article_Date) {
        this.Article_Date = Article_Date;
    }

    /**
     * Retrieves the description of the article.
     * @return <code>String</code> description
     */
    public String getArticle_Description() {
        return Article_Description;
    }

    /**
     * Sets the description of the article.
     * @param Article_Description 
     */
    public void setArticle_Description(String Article_Description) {
        this.Article_Description = Article_Description;
    }

    /**
     * Retrieves the ID of the article.
     * @return <code>int</code> ID of article
     */
    public int getArticle_Id() {
        return Article_Id;
    }

    /**
     * Set the ID of the article.
     * @param Article_Id The ID of the article
     */
    public void setArticle_Id(int Article_Id) {
        this.Article_Id = Article_Id;
    }

    /**
     * Retrieves the current rank of the article.
     * @return <code>int</code> article rank
     */
    public int getArticle_Rank() {
        return Article_Rank;
    }

    /**
     * Sets the current rank of the article.
     * @param Article_Rank <code>int</code> article rank
     */
    public void setArticle_Rank(int Article_Rank) {
        this.Article_Rank = Article_Rank;
    }

    /**
     * Retrieves the title of the article.
     * @return <code>String</code> title of article
     */
    public String getArticle_Title() {
        return Article_Title;
    }

    /**
     * Sets the title of the article.
     * @param Article_Title <code>String</code> title of article
     */
    public void setArticle_Title(String Article_Title) {
        this.Article_Title = Article_Title;
    }

    /**
     * Retrieves the location of the article.
     * @return <code>String</code> location of article
     */
    public String getArticle_Location() {
        return Article_Location;
    }

    /**
     * Sets the location of the article.
     * @param Article_Location <code>String</code> location of article
     */
    public void setArticle_Location(String Article_Location) {
        this.Article_Location = Article_Location;
    }

    /**
     * Retrieves the author/user associated with this article.
     * @return <code>UserBean</code> representing the article author
     */
    public UserBean getUser() {
        return User;
    }

    /**
     * Sets the user/author of the article.
     * @param User <code>UserBean</code> representing the article author
     */
    public void setUser(UserBean User) {
        this.User = User;
    }

}
