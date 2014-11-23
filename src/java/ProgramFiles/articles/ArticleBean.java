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

    public Date getArticle_Date() {
        return Article_Date;
    }

    public void setArticle_Date(Date Article_Date) {
        this.Article_Date = Article_Date;
    }

    public String getArticle_Description() {
        return Article_Description;
    }

    public void setArticle_Description(String Article_Description) {
        this.Article_Description = Article_Description;
    }

    public int getArticle_Id() {
        return Article_Id;
    }

    public void setArticle_Id(int Article_Id) {
        this.Article_Id = Article_Id;
    }

    public int getArticle_Rank() {
        return Article_Rank;
    }

    public void setArticle_Rank(int Article_Rank) {
        this.Article_Rank = Article_Rank;
    }

    public String getArticle_Title() {
        return Article_Title;
    }

    public void setArticle_Title(String Article_Title) {
        this.Article_Title = Article_Title;
    }

    public String getArticle_Location() {
        return Article_Location;
    }

    public void setArticle_Location(String Article_Location) {
        this.Article_Location = Article_Location;
    }

    public UserBean getUser() {
        return User;
    }

    public void setUser(UserBean User) {
        this.User = User;
    }

}
