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
    public class NFLoginServlet extends HttpServlet {  
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException { 
            
            
            try {
            
                UserBean user = new UserBean();
                user.setUser_Login(request.getParameter("username"));
                user.setUser_Password(request.getParameter("password"));
                user = UserDAO.login(user);
               
                if (user.isValid()) {
                     
                HttpSession session = request.getSession(true);
                
                UserDAO.profile(user);
                UserDAO.NetworkRequest(user);
                UserDAO.getNetworkUsers(user);             
                UserDAO.getMessages(user);
                
                session.setAttribute("currentSessionUser", user);
                List<ArticleBean> articleList = ArticlesDAO.getAllArticles();
                response.setContentType("text/html");
                request.setAttribute("articleList", articleList);
                request.getRequestDispatcher("MyNewsRoom.jsp").forward(request, response);
                response.sendRedirect("MyNewsRoom.jsp");
                return;
//logged-in page 
            } else {
                response.sendRedirect("LoginPageFail.jsp");
                return;
            }
           
           
             
            //error page
        } catch (SQLException | ServletException | IOException theException) {
             response.sendRedirect("processPages\\Error.html");
            return;
        }
 
        }  
    }  