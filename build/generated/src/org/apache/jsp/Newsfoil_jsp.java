package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Newsfoil_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Untitled Document</title>\r\n");
      out.write("<link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <div class=\"header\">\r\n");
      out.write("  \t\t<div class=\"logo\">\r\n");
      out.write("  \t\t<!--<a href=\"#\"><img src=\"\" alt=\"Insert Logo Here\" name=\"Insert_logo\"  height=\"40\" id=\"Insert_logo\" style=\"background: #8090AB; display:block;\" /></a> -->\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<div class=\"menubar\">\r\n");
      out.write("\t\t  \r\n");
      out.write("          <a class=\"menuitem\" href=\"#/\">Home</a> &nbsp;\r\n");
      out.write("          <a class=\"menuitem\" href=\"#/account\">Account</a>&nbsp;\r\n");
      out.write("          <a class=\"menuitem\" href=\"#/network\">Network </a> &nbsp;\r\n");
      out.write("          <a class=\"menuitem\" href=\"#/about\">About </a> &nbsp;\r\n");
      out.write("          \r\n");
      out.write("  \t\t</div>\r\n");
      out.write("    \r\n");
      out.write("   \t\t<div class=\"signin\">\r\n");
      out.write("         <form action=\"NFServlet\" method = \"post\">             \r\n");
      out.write("            <input class=\"input\" type=\"submit\" value=\"Sign In\"/>   \r\n");
      out.write("            <input type=\"hidden\" name=\"targetpage\" value=\"Login\"/>\r\n");
      out.write("            <input class=\"input\" type=\"password\" name=\"password\" placeholder=\"password\"/>\r\n");
      out.write("             <input class=\"input\" type=\"username\" name=\"username\" placeholder=\"username\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        <br/><br/> \r\n");
      out.write("        \r\n");
      out.write("        <a class=\"pwitem\" href=\"NewAccount.jsp\"> &nbsp; &nbsp;New Account &nbsp;</a>\r\n");
      out.write("          <a class=\"pwitem\" href=\"ForgottenPassword.jsp\">Forgot Password &nbsp;&nbsp;</a>\r\n");
      out.write("       \r\n");
      out.write("   \t\t</div>\r\n");
      out.write("        \r\n");
      out.write("    <!-- end .header -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"clearfloat\"></div>\r\n");
      out.write("  <div class=\"sidebar1\">\r\n");
      out.write("    \r\n");
      out.write("    <p> </p>\r\n");
      out.write("    <!-- end .sidebar1 --></div>\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("  \r\n");
      out.write("  <h1>&nbsp;</h1>\r\n");
      out.write("  <h1>Newsfoil</h1>\r\n");
      out.write("  \r\n");
      out.write("  <p>&nbsp;</p>\r\n");
      out.write("  \r\n");
      out.write("   <ul class=\"article\">\r\n");
      out.write("      <li>\r\n");
      out.write("        <a href=\"#\"><span class=\"articletitle\">Article 1</span></a>\r\n");
      out.write("        <span class=\"articledate\">November 1, 2014</span><span class=\"articleauthor\"> by John Doe</span><br />\r\n");
      out.write("       <span class=\"articledescription\">This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</span>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li>\r\n");
      out.write("        <h1><a href=\"#\">Article 2</a></h1>\r\n");
      out.write("        <h4>November 1, 2014 by John Doe</h4>\r\n");
      out.write("       <h3>This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</h3>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li>\r\n");
      out.write("        <h1><a href=\"#\">Article 3</a></h1>\r\n");
      out.write("        <h4>November 1, 2014 by John Doe</h4>\r\n");
      out.write("       <h3>This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</h3>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li>\r\n");
      out.write("        <h1><a href=\"#\">Article 4</a></h1>\r\n");
      out.write("        <h4>November 1, 2014 by John Doe</h4>\r\n");
      out.write("       <h3>This is the description of the article that is listed above.  It will have a max legth of something, I'm just not sure yet...</h3>\r\n");
      out.write("      </li>\r\n");
      out.write("      \r\n");
      out.write("    </ul>\r\n");
      out.write("    <!-- end .content --></div>\r\n");
      out.write("  <div class=\"sidebar2\">\r\n");
      out.write("    <h4>You Have a Voice.</h4>\r\n");
      out.write("    <h4>Be Heard</h4>\r\n");
      out.write("    <p></p><p></p>\r\n");
      out.write("    <!-- end .sidebar2 -->\r\n");
      out.write("    \r\n");
      out.write("    <ul class=\"nav\">\r\n");
      out.write("     <li><a href=\"#/account\">Latest Article</a>&nbsp;</li>\r\n");
      out.write("     <li><a href=\"#/network\">Create Article </a> &nbsp;</li>\r\n");
      out.write("     <li><a href=\"#/about\">Your Network </a> &nbsp;</li>\r\n");
      out.write("     <li><a href=\"#/about\">Settings </a> &nbsp;</li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  <div class=\"footer\">\r\n");
      out.write("    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>\r\n");
      out.write("    <!-- end .footer --></div>\r\n");
      out.write("  <!-- end .container --></div>\r\n");
      out.write("</body>\r\n");
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
