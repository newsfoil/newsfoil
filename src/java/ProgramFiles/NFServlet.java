package ProgramFiles;

import ProgramFiles.articles.ArticleBean;
import ProgramFiles.articles.ArticlesDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NFServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *     
* @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// processRequest(request, response);
        try {
// User may already be logged in
            HttpSession session = request.getSession();
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
// If user is not in session, assume we're coming from login page
            if (user == null) {
                user = new UserBean();
                user.setUser_Login(request.getParameter("username"));
                user.setUser_Password(request.getParameter("password"));
                user = UserDAO.login(user);
            }
            if (user.isValid()) {
                session = request.getSession(true);
                user.setNetworkRequests("Delete");
                UserDAO.NetworkRequest(user);
                user.setMembers("Delete");
                UserDAO.getNetworkUsers(user);
                session.setAttribute("currentSessionUser", user);
                List<ArticleBean> articleList = ArticlesDAO.getAllArticles();
                response.setContentType("text/html");
                request.setAttribute("articleList", articleList);
                request.getRequestDispatcher("MyNewsRoom.jsp").forward(request, response);
                response.sendRedirect("MyNewsRoom.jsp");
//logged-in page
            } else {
                response.sendRedirect("LoginPageFail.jsp");
            }
//error page
        } catch (SQLException | ServletException | IOException theException) {
            response.sendRedirect("processPages\\Error.html");
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *     
* @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try {
            UserBean user = new UserBean();
            user.setUser_Name(request.getParameter("username"));
            user.setUser_Password(request.getParameter("password"));
            user = UserDAO.login(user);
            if (user.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                response.sendRedirect("MyNewsRoom.jsp");
//logged-in page
            } else {
                response.sendRedirect("loginPageFail.jsp");
            }
//error page
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *     
* @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *     
* @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
