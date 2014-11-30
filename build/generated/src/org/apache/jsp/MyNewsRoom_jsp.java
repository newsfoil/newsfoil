package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ProgramFiles.articles.ArticleBean;
import ProgramFiles.NetworkRequestBean;
import java.util.List;

public final class MyNewsRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.release();
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
 List<ArticleBean> articleList = (List<ArticleBean>)session.getAttribute("articleList"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>My News Room</title>\r\n");
      out.write("<link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write(" <link href=\"css/sprycss.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write(" <script src=\"js/CollapsiblePanel.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("     <div class=\"header\">\r\n");
      out.write("        <div class=\"fltlft\">\r\n");
      out.write("            <img src=\"images/Voice.jpg\" alt=\"Logo\" width=\"192\" height=\"144\" border=\"1\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"fltcent\">\r\n");
      out.write("            <img src=\"images/logo.jpg\" alt=\"Logo\" align=\"middle\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"fltrt\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            ");
      ProgramFiles.UserBean currentSessionUser = null;
      synchronized (session) {
        currentSessionUser = (ProgramFiles.UserBean) _jspx_page_context.getAttribute("currentSessionUser", PageContext.SESSION_SCOPE);
        if (currentSessionUser == null){
          currentSessionUser = new ProgramFiles.UserBean();
          _jspx_page_context.setAttribute("currentSessionUser", currentSessionUser, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("currentSessionUser"), request);
      out.write("\r\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ProgramFiles.UserBean)_jspx_page_context.findAttribute("currentSessionUser")).getUser_Name())));
      out.write("\r\n");
      out.write("     ");

     
     try {
     List<NetworkRequestBean> all_Request = currentSessionUser.getNetworkRequests();
     
     for (int x = 0; x < all_Request.size(); x++){
     NetworkRequestBean RequestItem = all_Request.get(x);
     
     out.println(RequestItem.getSender_ID());
     }
     }catch(Exception ex){}
     out.println("Hello");
     
     
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("     </div>\r\n");
      out.write("    \r\n");
      out.write("  \t\t<div class=\"menubar\">\r\n");
      out.write("\t\t  \r\n");
      out.write("  \t\t</div>\r\n");
      out.write("    \r\n");
      out.write("    \t\t\r\n");
      out.write("    <div class=\"clearfloat\"></div>\r\n");
      out.write("  <div class=\"sidebar1\">\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("          \r\n");
      out.write("          <div class = \"influence\">\r\n");
      out.write("              Influence\r\n");
      out.write("              <br/>\r\n");
      out.write("              Current:  58%\r\n");
      out.write("              <br/>\r\n");
      out.write("              Variance: 46%\r\n");
      out.write("              <br/>\r\n");
      out.write("              Network Factor: 120%\r\n");
      out.write("              <br/><br/><br/>\r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("          </div>     \r\n");
      out.write("          <div id=\"CollapsiblePanel1\" class=\"CollapsiblePanel\">\r\n");
      out.write("              <div class=\"CollapsiblePanelTab\" tabindex=\"1\"> &gt; &nbsp; Network Group </div>\r\n");
      out.write("              <div class=\"CollapsiblePanelContent\">\r\n");
      out.write("                <h4>Network Members: </h4>\r\n");
      out.write("                This will contain a list of all members in network\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <div id=\"CollapsiblePanel2\" class=\"CollapsiblePanel\">\r\n");
      out.write("              <div class=\"CollapsiblePanelTab\" tabindex=\"2\"> &gt; &nbsp; Network Requests </div>\r\n");
      out.write("              <div class=\"CollapsiblePanelContent\">\r\n");
      out.write("                  <h3>Send a request to join Network: </h3>\r\n");
      out.write("                  <form id=\"lkup\" action=\"NewsNetworkRequestServlet\" method=\"post\" >\r\n");
      out.write("                      <input type=\"text\" id=\"accountSettingInput\" name=\"TargetEmail\">\r\n");
      out.write("                      <h4>enter email address</h4>\r\n");
      out.write("                  <input type=\"submit\" id=\"accountSettingInput\" value=\"Send a Request\"/>\r\n");
      out.write("                  </form>\r\n");
      out.write("                  <br/>\r\n");
      out.write("                  <h3>Member Lookup</h3>\r\n");
      out.write("                  <form action=\"lookupUserServlet\" id=\"lkup\">\r\n");
      out.write("                  <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\r\n");
      out.write("                   <br/><h4>enter last name </h4>\r\n");
      out.write("                  <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"LookUp\"/>\r\n");
      out.write("                  </form>\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("           <div id=\"CollapsiblePanel3\" class=\"CollapsiblePanel\">\r\n");
      out.write("              <div class=\"CollapsiblePanelTab\" tabindex=\"3\"> &gt; &nbsp; My Articles </div>\r\n");
      out.write("              <div class=\"CollapsiblePanelContent\">\r\n");
      out.write("            <form action=\"lookupArticleServlet\" id=\"lkup\">\r\n");
      out.write("                  <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\r\n");
      out.write("                  <h4>Search Your Articles</h4>\r\n");
      out.write("                  <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"Search\"/>\r\n");
      out.write("                  </form>\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <div id=\"CollapsiblePanel4\" class=\"CollapsiblePanel\">\r\n");
      out.write("              <div class=\"CollapsiblePanelTab\" tabindex=\"4\"> &gt; &nbsp; Messages </div>\r\n");
      out.write("              <div class=\"CollapsiblePanelContent\">\r\n");
      out.write("                  <form action=\"sendmessage\" id=\"lkup\">\r\n");
      out.write("                  <input type=\"text\" id=\"accountSettingInput\" name=\"lookupmember\">\r\n");
      out.write("                  <h4>Send a Message</h4>\r\n");
      out.write("                  <input type=\"button\" name=\"userRequest\" id=\"accountSettingInput\" value=\"Message\"/>\r\n");
      out.write("                  </form>\r\n");
      out.write("        \r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("  \r\n");
      out.write("  <h1>&nbsp;</h1>\r\n");
      out.write("  <h1>Newsfoil</h1>\r\n");
      out.write("  \r\n");
      out.write("  <p>&nbsp;</p>\r\n");
      out.write("  \r\n");
      out.write("  <ul class=\"article\">\r\n");
      out.write("      ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  </ul>\r\n");
      out.write("\r\n");
      out.write("  <!-- TODO: Remove if we like the above template -->\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <!--\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <ul class=\"article\">\r\n");
      out.write("      <li>\r\n");
      out.write("        <a href=\"#\"><span class=\"articletitle\">Article 1</span></a>\r\n");
      out.write("        <span class=\"articledate\">November 1, 2014</span><span class=\"articleauthor\"> by John Doe</span><br />\r\n");
      out.write("       <span class=\"articledescription\">This is the description of the article that is listed above.  It will have a max length of something, I'm just not sure yet...</span>\r\n");
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
      out.write("    -->\r\n");
      out.write("  \r\n");
      out.write("    <!-- end .content --></div>\r\n");
      out.write("  <div class=\"sidebar2\">\r\n");
      out.write("    <ul class=\"nav\">\r\n");
      out.write("     <li><a href=\"ProfilePage\">Profile</a>&nbsp;</li>\r\n");
      out.write("     <li><a href=\"AccountSettings.jsp\">Settings</a> &nbsp;</li>\r\n");
      out.write("     <li><a href=\"About.html\">About</a> &nbsp;</li>\r\n");
      out.write("    </ul>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("  <div class=\"footer\">\r\n");
      out.write("    <p></p>\r\n");
      out.write("    <!-- end .footer --></div>\r\n");
      out.write("  <!-- end .container --></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("            var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel1\", {contentIsOpen:false});\r\n");
      out.write("            var CollapsiblePanel2 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel2\", {contentIsOpen:false});\r\n");
      out.write("            var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel3\", {contentIsOpen:false});\r\n");
      out.write("            var CollapsiblePanel4 = new Spry.Widget.CollapsiblePanel(\"CollapsiblePanel4\", {contentIsOpen:false});\r\n");
      out.write("            </script>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${articleList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("article");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("          <li>\r\n");
          out.write("            <h1><a href=\"#\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${article.getArticle_Title()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h1>\r\n");
          out.write("            <h4>");
          if (_jspx_meth_fmt_formatDate_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write(" by ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${article.getUser().getUser_Name()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\r\n");
          out.write("            <h3>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${article.getArticle_Description()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h3>\r\n");
          out.write("          </li>\r\n");
          out.write("      ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_fmt_formatDate_0.setPattern("MMMM dd, yyyy");
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${article.getArticle_Date()}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }
}
