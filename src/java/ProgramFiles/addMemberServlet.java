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
                 
         
         if (requestType == null){
        requestType = "";
        }
         
         if (requestorID == null){
        requestorID = "";
        }
         
        if (requestorName == null){
        requestorName = "";
        }
        
            HttpSession session = request.getSession();
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
           
            if (requestType.contains("Accept")){
            NetworkRequestDOA.acceptReguest(requestorID, requestorName, user);
            }
            if (requestType.contains("Decline")){
            NetworkRequestDOA.declineReguest(requestorID, user);
            }
            if (requestType.contains("Send Message")){
            response.sendRedirect("CreateMessage.jsp");
            }
            else {
            response.sendRedirect("NFServlet");}
            
        }catch (NullPointerException ex) {
            System.out.println(ex);
        }
 
        }  
    }  