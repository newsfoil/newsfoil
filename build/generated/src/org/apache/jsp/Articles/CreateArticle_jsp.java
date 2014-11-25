package org.apache.jsp.Articles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ProgramFiles.articles.ArticleBean;

public final class CreateArticle_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Account Settings</title>\n");
      out.write("\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"header\"><!-- end .header -->\n");
      out.write("\n");
      out.write("                <div class=\"fltlft\">\n");
      out.write("                    <img src=\"images/Voice.jpg\" alt=\"Logo\" width=\"192\" height=\"144\" border=\"1\" />\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"fltcent\">\n");
      out.write("                    <img src=\"images/logo.jpg\" alt=\"Logo\" align=\"middle\" />\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"fltrt\">\n");
      out.write("                        ");
      ProgramFiles.UserBean currentSessionUser = null;
      synchronized (session) {
        currentSessionUser = (ProgramFiles.UserBean) _jspx_page_context.getAttribute("currentSessionUser", PageContext.SESSION_SCOPE);
        if (currentSessionUser == null){
          currentSessionUser = new ProgramFiles.UserBean();
          _jspx_page_context.setAttribute("currentSessionUser", currentSessionUser, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("currentSessionUser"), request);
      out.write("\n");
      out.write("                        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.UserBean)_jspx_page_context.findAttribute("currentSessionUser")).getUser_Name())));
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("                <div class=\"accountSettingText\">\n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("\n");
      out.write("                    <form id= \"account\" name=\"account\" action=\"ArticleServlet\" method = \"post\"> \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <hr/><br/>\n");
      out.write("                        Article Title: <input type=\"text\" name=\"articleTitle\"/> \n");
      out.write("                     \n");
      out.write("                        <br/><br/>\n");
      out.write("                        <br/><br/>\n");
      out.write("                        Article: <textarea rows=\"4\" cols=\"50\" name=\"Article\"></textarea>\n");
      out.write("                        <br/><br/>\n");
      out.write("                        <br/><br/>\n");
      out.write("                        <input type=\"button\" value=\"Create Article\"/>\n");
      out.write("\n");
      out.write("                    </form> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"element\"></div>\n");
      out.write("                    <!-- end .content --></div>\n");
      out.write("\n");
      out.write("                <!-- end .container --></div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
