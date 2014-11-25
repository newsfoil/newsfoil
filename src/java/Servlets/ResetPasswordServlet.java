/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ProgramFiles.NewAccount;
import ProgramFiles.SendEmail;
import ProgramFiles.TestNewAccount;
import ProgramFiles.UpdatePassword;
import ProgramFiles.UserBean;
import ProgramFiles.login.AddUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dentm_000
 */
@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/ResetPasswordServlet"})

public class ResetPasswordServlet extends HttpServlet {

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
         
        String userCurrentPassword;
        String userPassword;
        String userEmail;
  
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            
            userCurrentPassword = request.getParameter("OldPassword");
            userPassword = request.getParameter("NewPassword");
            
            
            TestNewAccount newAccount = new TestNewAccount(); 
            NewAccount account = new NewAccount();
            
            
            HttpSession session = request.getSession();
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            
            System.out.println(user.getUser_Password()+"   " +userCurrentPassword);
            
            if (userCurrentPassword.equals(user.getUser_Password()))
            {
            user.setUser_Password(userPassword);
            UpdatePassword.login(userPassword, user.getUser_Email());
            user.setMessage("New password was set");
            }     
             
            else{
            user.setMessage("ERROR password was incorrect.");
            }    
             
            
              response.sendRedirect("AccountSettings.jsp");
            
        }catch (Throwable theException) {
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
