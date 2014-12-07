package ProgramFiles.articles;

import ProgramFiles.UserBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet for displaying MyNewsRoom.jsp
 * @author Larry Morales
 */
@WebServlet("/Article")
public class ArticleServlet extends HttpServlet {

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
        String articleId = request.getParameter("id");
        if(articleId == null) {
            response.setContentType("text/html");
            response.sendRedirect("NFServlet");
        } else {
            try {
                ArticleBean article = ArticlesDAO.getArticle(Integer.parseInt(articleId));
                response.setContentType("text/html");
                request.setAttribute("article", article);
                request.getRequestDispatcher("Articles/Article.jsp").forward(request, response);
            } catch(NumberFormatException e) {
                response.sendRedirect("NFServlet");
            }
           
        }
        
        
    }
}
