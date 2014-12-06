package ProgramFiles;

    import ProgramFiles.articles.ArticleBean;
    import ProgramFiles.articles.ArticlesDAO;
    import java.io.IOException;  
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
                
                 HttpSession session=request.getSession(); 
                 
                 if (session.isNew()){
                 session = request.getSession(true);
                 
                 }else {
                    session.setAttribute("currentSessionUser", null);
                    session.setAttribute("articleList", null);  }  
                    
                    
                session = request.getSession(true);
                UserDAO.NetworkRequest(user);
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
        } catch (Throwable theException) {
             response.sendRedirect("processPages\\Error.html");
            
        }
 
        }  
    }  