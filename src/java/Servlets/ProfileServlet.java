/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ProgramFiles.UserBean;
import ProgramFiles.updateAccount;
import java.io.IOException;
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
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
            
               
            HttpSession session = request.getSession();
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            
            user.setUser_First_Name(request.getParameter("firstName")); 
            user.setUser_Middle_Name(request.getParameter("middleName"));
            user.setUser_Last_Name(request.getParameter("lastName"));
            user.setUser_City(request.getParameter("myCity"));
            user.setUser_State(request.getParameter("myState"));
            user.setUser_Zip(request.getParameter("myZip"));
            user.setUser_Tag_Line(request.getParameter("myTagline"));
            user.setUser_Political_Party(request.getParameter("myParty"));
            user.setUser_Bio (request.getParameter("myBio"));
            user.setUser_Education (request.getParameter("myEducation"));
            user.setUser_Photo (request.getParameter("myPhoto"));
            
            updateAccount.accountInsert(user);
            updateAccount.createProfilePage(user);
            
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
