package org.apache.jsp.Articles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Article_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      ProgramFiles.UserBean currentSessionUser = null;
      synchronized (session) {
        currentSessionUser = (ProgramFiles.UserBean) _jspx_page_context.getAttribute("currentSessionUser", PageContext.SESSION_SCOPE);
        if (currentSessionUser == null){
          currentSessionUser = new ProgramFiles.UserBean();
          _jspx_page_context.setAttribute("currentSessionUser", currentSessionUser, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("currentSessionUser"), request);
      out.write("\n");
      out.write("                    ");
      ProgramFiles.articles.ArticleBean articleBean = null;
      synchronized (session) {
        articleBean = (ProgramFiles.articles.ArticleBean) _jspx_page_context.getAttribute("articleBean", PageContext.SESSION_SCOPE);
        if (articleBean == null){
          articleBean = new ProgramFiles.articles.ArticleBean();
          _jspx_page_context.setAttribute("articleBean", articleBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("articleBean"), request);
      out.write("\n");
      out.write("                    \n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.UserBean)_jspx_page_context.findAttribute("currentSessionUser")).getUser_Name())));
      out.write("\n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.UserBean)_jspx_page_context.findAttribute("currentSessionUser")).getUser_Name())));
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.articles.ArticleBean)_jspx_page_context.findAttribute("articleBean")).getArticle_Id())));
      out.write("\n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.articles.ArticleBean)_jspx_page_context.findAttribute("articleBean")).getArticle_Date())));
      out.write("\n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.articles.ArticleBean)_jspx_page_context.findAttribute("articleBean")).getArticle_Description())));
      out.write("\n");
      out.write("                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.articles.ArticleBean)_jspx_page_context.findAttribute("articleBean")).getArticle_Title())));
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
