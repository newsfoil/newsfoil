package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <title>Newsfoil Login</title>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
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
      out.write("                    <form action=\"NFServlet\" method = \"post\">             \r\n");
      out.write("                        <input ID=\"tb1\" type=\"username\" name=\"username\" placeholder=\"username\"/>\r\n");
      out.write("                        <input  ID=\"tb1\" type=\"password\" name=\"password\" placeholder=\"password\"/>\r\n");
      out.write("                        <input ID=\"tb1\" type=\"submit\" value=\"Sign In\">   \r\n");
      out.write("                        <input type=\"hidden\" name=\"targetpage\" value=\"Login\"/>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                    <a class=\"pwitem\" href=\"NewAccount.html\">&nbsp;New Account &nbsp;</a>\r\n");
      out.write("                    <a class=\"pwitem\" href=\"ResetPassword.jsp\">&nbsp; Forgot Password &nbsp;</a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"content\">\r\n");
      out.write("\r\n");
      out.write("                    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("                    <script src=\"Typed.js\" type=\"text/javascript\"></script>\r\n");
      out.write("                    <script>\r\n");
      out.write("                  $(function(){\r\n");
      out.write("                      $(\".element\").typed({\r\n");
      out.write("                        strings: [\"You have the words to change a nation, but you're biting your tongue.\", \"Stop biting your tongue.\", \"It hurts...\", \"NEWSFOIL.COM\"],\r\n");
      out.write("                                typeSpeed: 0\r\n");
      out.write("                            });\r\n");
      out.write("                        });\r\n");
      out.write("                    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"element\"></div>\r\n");
      out.write("                    <!-- end .content --></div>\r\n");
      out.write("\r\n");
      out.write("                <!-- end .container --></div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
