package ProgramFiles.profiles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet for displaying ProfilePage.jsp
 * @author Larry Morales
 */
@WebServlet("/ProfilePage")
public class ProfileServlet extends HttpServlet {
    
    /**
     * Returns ProfilePage.jsp with the information it needs to render.
     * @param request The browser request
     * @param response The browser response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
    }
}