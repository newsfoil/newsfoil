    package ProgramFiles;

    import java.io.IOException;  
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    import javax.servlet.http.HttpSession;  
    public class addMemberServlet extends HttpServlet {  
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException { 
      
       
        try {
            
            String requestorID = request.getParameter("requestor").trim();
            String requestorName = request.getParameter("requestorName").trim();
            String requestType = request.getParameter("requestType").trim();
                 
       
        
         
         if (requestType.equals(null)){
        requestType = "";
        }
         
         if (requestorID.equals(null)){
        requestorID = "";
        }
         
        if (requestorName.equals(null)){
        requestorName = "";
        }
        
            HttpSession session = request.getSession();
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
           
            if (requestType.contains("Accept")){
             System.out.println("***I'm in the ACCEPT");
            NetworkRequestDOA.acceptReguest(requestorID, requestorName, user);
            }
            if (requestType.contains("Decline")){
             System.out.println("***I'm in the DECLINE");
            NetworkRequestDOA.declineReguest(requestorID, user);
            }
            
        System.out.println("**** accept::" + requestType+ ":: Decline  ::"+ requestType + "::requestor : " + requestorID + "req name " + requestorName);    
            response.sendRedirect("NFServlet");
            
        }catch (NullPointerException ex) {
            System.out.println("this is the exception : " +ex);
        }
 
        }  
    }  