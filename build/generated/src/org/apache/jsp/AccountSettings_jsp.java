package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ProgramFiles.UserBean;

public final class AccountSettings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=windows-1256");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <title>Account Settings</title>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script src=\"js/CollapsiblePanel.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link href=\"css/sprycss.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"header\"><!-- end .header -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"fltlft\">\r\n");
      out.write("                    <img src=\"images/Voice.jpg\" alt=\"Logo\" width=\"192\" height=\"144\" border=\"1\" />\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"fltcent\">\r\n");
      out.write("                    <img src=\"images/logo.jpg\" alt=\"Logo\" align=\"middle\" />\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"fltrt\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <div class=\"accountSettingText\">\r\n");
      out.write("                    ");
      ProgramFiles.UserBean currentSessionUser = null;
      synchronized (session) {
        currentSessionUser = (ProgramFiles.UserBean) _jspx_page_context.getAttribute("currentSessionUser", PageContext.SESSION_SCOPE);
        if (currentSessionUser == null){
          currentSessionUser = new ProgramFiles.UserBean();
          _jspx_page_context.setAttribute("currentSessionUser", currentSessionUser, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("currentSessionUser"), request);
      out.write("\r\n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.UserBean)_jspx_page_context.findAttribute("currentSessionUser")).getUser_Name())));
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div id=\"CollapsiblePanel1\" class=\"CollapsiblePanel\">\r\n");
      out.write("  <div class=\"CollapsiblePanelTab\" tabindex=\"1\"> &gt; Change Password</div>\r\n");
      out.write("  <div class=\"CollapsiblePanelContent\">\r\n");
      out.write("   <form id= \"Reset\" name=\"Reset\" action=\"ResetPasswordServlet\" method = \"post\">                    \r\n");
      out.write("  Old Password: <input type=\"password\" name=\"OldPassword\"/>\r\n");
      out.write("  <br/><br/>\r\n");
      out.write("  New Password: <input type=\"password\" name=\"NewPassword\"/>\r\n");
      out.write("  <br/><br/>\r\n");
      out.write("  Retype Password: <input type=\"password\" name=\"NewPassword2\"/>\r\n");
      out.write("  <br/><br/>\r\n");
      out.write("   </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("\r\n");
      out.write("                    <form id= \"account\" name=\"account\" action=\"ResetServlet\" method = \"post\"> \r\n");
      out.write("                        <input type=\"hidden\" name=\"password\"/>\r\n");
      out.write("                        <input type=\"hidden\" name=\"targetpage\" value=\"NewAccount\"/>\r\n");
      out.write("                        Photo: <input type=\"text\" name=\"userName\"/><input type=\"button\" value=\"Download\"/>\r\n");
      out.write("                        <hr/><br/>\r\n");
      out.write("                        User Name:  <input type=\"text\" name=\"userName\" value=\"");
      out.print( currentSessionUser.getUser_Name());
      out.write("\" /> \r\n");
      out.write("                        Password:   <input type=\"button\" value=\"Change Password\"/>\r\n");
      out.write("                        <hr/><br/>\r\n");
      out.write("                        First Name: <input type=\"text\" name=\"firstName\" value=\"");
      out.print( currentSessionUser.getUser_First_Name()  );
      out.write("\"/> \r\n");
      out.write("                        Middle Name: <input type=\"text\" name=\"middleName\" value=\"");
      out.print( currentSessionUser.getUser_Middle_Name()  );
      out.write("\"/> \r\n");
      out.write("                        Last Name: <input type=\"text\" name=\"lastName\" value=\"");
      out.print( currentSessionUser.getUser_Last_Name() );
      out.write("\"/> \r\n");
      out.write("                        <br/><br/>\r\n");
      out.write("                        City: <input type=\"text\" name=\"city\" value=\"");
      out.print( currentSessionUser.getUser_City() );
      out.write("\"/>\r\n");
      out.write("                        State: <input type=\"text\" name=\"state\" value=\"");
      out.print( currentSessionUser.getUser_State() );
      out.write("\"/>\r\n");
      out.write("                        Zip: <input type=\"text\" name=\"zip\" value=\"");
      out.print( currentSessionUser.getUser_Zip() );
      out.write("\"/>\r\n");
      out.write("                        <br/><br/>\r\n");
      out.write("                        Email address: <input type=\"text\" name=\"email\" value=\"\" value=\"");
      out.print( currentSessionUser.getUser_Email() );
      out.write("\" /> \r\n");
      out.write("                        <hr/><br/>\r\n");
      out.write("                        Tag line: <input type=\"text\" name=\"tag\" value=\"");
      out.print( currentSessionUser.getUser_Tag_Line() );
      out.write("\"/>\r\n");
      out.write("                        <br/><br/> \r\n");
      out.write("                        Political Party: <select name=\"Political Party\" >\r\n");
      out.write("                            <option value=\"volvo\">");
      out.print( currentSessionUser.getUser_Political_Party() );
      out.write("</option>\r\n");
      out.write("                            <option value=\"volvo\">I don't know</option>\r\n");
      out.write("                            <option value=\"saab\">I don't care</option>\r\n");
      out.write("                            <option value=\"fiat\">Republican</option>\r\n");
      out.write("                            <option value=\"audi\">Democrat</option>\r\n");
      out.write("                            <option value=\"audi\">Independent</option>\r\n");
      out.write("                            <option value=\"audi\">Progressive</option>\r\n");
      out.write("                            <option value=\"audi\">Conservative</option>\r\n");
      out.write("                            <option value=\"audi\">Green</option>\r\n");
      out.write("                            <option value=\"audi\">Not saying</option>\r\n");
      out.write("                            <option value=\"audi\">Mickey Mouse</option>\r\n");
      out.write("                            <option value=\"audi\">Miss Piggy</option>\r\n");
      out.write("                            <option value=\"audi\">Other</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <br/><br/>\r\n");
      out.write("                        Bio: <textarea rows=\"4\" cols=\"50\" name=\"bio\" placeholder=\"");
      out.print( currentSessionUser.getUser_Bio() );
      out.write("\"></textarea>\r\n");
      out.write("                        <br/><br/>\r\n");
      out.write("                        Education: <textarea rows=\"4\" cols=\"50\" name=\"education\" placeholder=\"");
      out.print( currentSessionUser.getUser_Education() );
      out.write("\"></textarea>\r\n");
      out.write("                        <br/><br/>\r\n");
      out.write("\r\n");
      out.write("                        <span class=\"emsg\" id=\"errormsg\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </span><br/><br/>\r\n");
      out.write("                        <input type=\"botton\" value=\"Update Profile\" onClick=\"populateform()\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </form> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"element\"></div>\r\n");
      out.write("                    <!-- end .content --></div>\r\n");
      out.write("\r\n");
      out.write("                <!-- end .container --></div>\r\n");
      out.write("        </div>\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("            var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel1\", {contentIsOpen:false});\r\n");
      out.write("            </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
