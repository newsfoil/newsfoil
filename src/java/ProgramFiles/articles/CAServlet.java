package ProgramFiles.articles;

import ProgramFiles.UserBean;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet used to handle requests related to creating articles
 * @author LarryMorales
 */
@WebServlet("/CreateArticle")
public class CAServlet extends HttpServlet {
    
    /**
     * Returns MyNewsRoom.jsp with the information it needs to render.
     * @param request The browser request
     * @param response The browser response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserBean user = (UserBean)session.getAttribute("currentSessionUser");
        if(user == null) {
            response.sendRedirect("LoginPageFail.js");
            return;
        } else {
            response.setContentType("text/html");
            request.getRequestDispatcher("Articles/CreateArticle.jsp").forward(request, response);
        }
        
    }
    
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In CAServlet Post");
        HttpSession session = request.getSession();
        UserBean user = (UserBean)session.getAttribute("currentSessionUser");
        if(user == null) {
            response.sendRedirect("index.html");
            return;
        } else {
            ArticleBean newArticle = new ArticleBean();
            newArticle.setUser(user);
            newArticle.setArticle_Title(request.getParameter("articleTitle"));
            newArticle.setArticle_Description(request.getParameter("articleDescription"));
            newArticle.setArticle_Content(request.getParameter("articleContent"));
            newArticle.setArticle_Rank(5);  // TODO: use a real ranking algorithm!
            newArticle.setArticle_Location("");
            newArticle.setArticle_Date(new Date(System.currentTimeMillis()));
            ArticlesDAO.createArticle(newArticle);
            
            response.setContentType("text/html");
            response.sendRedirect("NFServlet");
            //request.getRequestDispatcher("NFServlet").forward(request, response);
        }

        
    }
}
