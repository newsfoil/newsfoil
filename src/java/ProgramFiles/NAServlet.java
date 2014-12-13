
package ProgramFiles;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NAServlet extends HttpServlet {

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
         
       
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            
            NewAccount account = new NewAccount();
            
            account.setUseremail(request.getParameter("email"));
            account.setUserPassword(request.getParameter("password"));
            account.setUsername(request.getParameter("username"));
            account.setUserFristName(request.getParameter("firstName"));
            account.setUserMiddleName(request.getParameter("middleName"));
            account.setUserLastName(request.getParameter("lastName"));
            
            boolean verify = UserDAO.verifyUserAccount(account);
            
            if (verify){
            UserDAO.createUser(account);
            account.setUserID(UserDAO.getUserID(account));
            UserDAO.createProfile(account);
            CreateEmail.newAccount(account);
           
            
            response.sendRedirect("NewAccountConfirmation.jsp");
            }else{
            
                response.sendRedirect("NewAccount.html?msg="+account.getJspMessage());
            }
            
         
        }catch (SQLException | IOException theException) {
            System.out.println(theException);
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
