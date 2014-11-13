/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramFiles;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dentm_000
 */
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
     //   response.setContentType("text/html;charset=UTF-8");
        
        String targetPage;
        String userName;
        String userPassword;
        String userEmail;
    //   processRequest(request, response);

        try {

            UserBean user = new UserBean();
            targetPage = request.getParameter("targetpage");

            if (targetPage.contains("Login")) {
                user.setUser_Name(request.getParameter("username"));
                user.setUser_Password(request.getParameter("password"));
                user = UserDAO.login(user);

                if (user.isValid()) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", user);
                    response.sendRedirect("MyNewsRoom.jsp");
//logged-in page 
                } else {
                    response.sendRedirect("LoginPageFail.jsp");
                }
            } else if (targetPage.contains("NewAccount")) {
                userName = request.getParameter("username");
                userPassword = request.getParameter("password");
                userEmail = request.getParameter("email");
                SendEmail email = new SendEmail();
                
                AddUser.login(userName, userPassword, userEmail);
                
                email.setUserName(userName);
                email.setUserEmail(userEmail);
                email.setUserSubject("Password");
                email.setUserMessage("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">\n" +
"<HTML>\n" +
"   <HEAD>\n" +
"      <TITLE>\n" +
"         Hello " + userName +"\n" +
"      </TITLE>\n" +
"   </HEAD>\n" +
"<BODY>\n" +
"   <H1>Hi</H1>\n" +
"   <P> your Password is "+ userPassword +"</P>\n" +
"</BODY>\n" +
"</HTML>");
                email.Send();
             
              response.sendRedirect("loginPage.jsp");
                
            }
            //error page
        } catch (Throwable theException) {
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
