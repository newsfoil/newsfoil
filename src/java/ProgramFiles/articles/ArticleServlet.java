package ProgramFiles.articles;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet for displaying MyNewsRoom.jsp
 * @author Larry Morales
 */
@WebServlet("/MyNewsRoom")
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

        List<ArticleBean> articleList = ArticlesDAO.getAllArticles();
        response.setContentType("text/html");
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("MyNewsRoom.jsp").forward(request, response);
    }
}
