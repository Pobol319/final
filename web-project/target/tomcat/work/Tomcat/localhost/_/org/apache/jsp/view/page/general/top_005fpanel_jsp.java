/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-02-09 10:02:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.page.general;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_005fpanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmx_005fsetBundle_0026_005fvar_005fbasename_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmx_005fsetBundle_0026_005fvar_005fbasename_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmx_005fsetBundle_0026_005fvar_005fbasename_005fnobody.release();
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_fmx_005fsetBundle_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>");
      if (_jspx_meth_fmx_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<ul class=\"horizontal-menu\">\r\n");
      out.write("    <li>\r\n");
      out.write("        <form action=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"logout\">\r\n");
      out.write("            <button type=\"submit\">\r\n");
      out.write("                ");
      if (_jspx_meth_fmx_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <button type=\"submit\">\r\n");
      out.write("            ");
      if (_jspx_meth_fmx_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </button>\r\n");
      out.write("        <ul class=\"sub-menu\">\r\n");
      out.write("            <li>\r\n");
      out.write("                <form action=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"choose_language\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"language\" value=\"english\">\r\n");
      out.write("                    <button type=\"submit\">English</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <form action=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"choose_language\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"language\" value=\"russian\">\r\n");
      out.write("                    <button type=\"submit\">Русский</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <form action=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"choose_language\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"language\" value=\"belorussian\">\r\n");
      out.write("                    <button type=\"submit\">Беларуский</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("</ul>\r\n");
      out.write("<div class=\"inner-content\">\r\n");
      out.write("    <div id=\"current-user\">\r\n");
      out.write("        ");
      if (_jspx_meth_fmx_005fmessage_005f3(_jspx_page_context))
        return;
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.login}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("        ");
      if (_jspx_meth_fmx_005fmessage_005f4(_jspx_page_context))
        return;
      out.write(" -\r\n");
      out.write("        ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmx_005fsetBundle_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:setBundle
    org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag _jspx_th_fmx_005fsetBundle_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag) _005fjspx_005ftagPool_005ffmx_005fsetBundle_0026_005fvar_005fbasename_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag.class);
    _jspx_th_fmx_005fsetBundle_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fsetBundle_005f0.setParent(null);
    // /view/page/general/top_panel.jsp(3,0) name = basename type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fsetBundle_005f0.setBasename("locale.general.top_panel");
    // /view/page/general/top_panel.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fsetBundle_005f0.setVar("topPanelB");
    int _jspx_eval_fmx_005fsetBundle_005f0 = _jspx_th_fmx_005fsetBundle_005f0.doStartTag();
    if (_jspx_th_fmx_005fsetBundle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fsetBundle_0026_005fvar_005fbasename_005fnobody.reuse(_jspx_th_fmx_005fsetBundle_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fsetBundle_0026_005fvar_005fbasename_005fnobody.reuse(_jspx_th_fmx_005fsetBundle_005f0);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f0.setParent(null);
    // /view/page/general/top_panel.jsp(7,11) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f0.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(7,11) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f0.setKey("title");
    int _jspx_eval_fmx_005fmessage_005f0 = _jspx_th_fmx_005fmessage_005f0.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /view/page/general/top_panel.jsp(12,22) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/command");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f1.setParent(null);
    // /view/page/general/top_panel.jsp(15,16) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f1.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(15,16) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f1.setKey("form.sign.out.button.sign.out");
    int _jspx_eval_fmx_005fmessage_005f1 = _jspx_th_fmx_005fmessage_005f1.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f1);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f2.setParent(null);
    // /view/page/general/top_panel.jsp(21,12) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f2.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(21,12) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f2.setKey("button.change.language");
    int _jspx_eval_fmx_005fmessage_005f2 = _jspx_th_fmx_005fmessage_005f2.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /view/page/general/top_panel.jsp(25,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/command");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /view/page/general/top_panel.jsp(32,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/command");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /view/page/general/top_panel.jsp(39,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/command");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f3 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f3.setParent(null);
    // /view/page/general/top_panel.jsp(50,8) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f3.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(50,8) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f3.setKey("current.user.login");
    int _jspx_eval_fmx_005fmessage_005f3 = _jspx_th_fmx_005fmessage_005f3.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f3);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f4 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f4.setParent(null);
    // /view/page/general/top_panel.jsp(51,8) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f4.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(51,8) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f4.setKey("current.user.role");
    int _jspx_eval_fmx_005fmessage_005f4 = _jspx_th_fmx_005fmessage_005f4.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /view/page/general/top_panel.jsp(53,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role == 'ADMIN'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_fmx_005fmessage_005f5(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f5 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    // /view/page/general/top_panel.jsp(54,16) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f5.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(54,16) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f5.setKey("user.role.administrator");
    int _jspx_eval_fmx_005fmessage_005f5 = _jspx_th_fmx_005fmessage_005f5.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /view/page/general/top_panel.jsp(56,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role == 'USER'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_fmx_005fmessage_005f6(_jspx_th_c_005fwhen_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }

  private boolean _jspx_meth_fmx_005fmessage_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmx:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmx_005fmessage_005f6 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmx_005fmessage_005f6.setPageContext(_jspx_page_context);
    _jspx_th_fmx_005fmessage_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f1);
    // /view/page/general/top_panel.jsp(57,16) name = bundle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f6.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${topPanelB}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /view/page/general/top_panel.jsp(57,16) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmx_005fmessage_005f6.setKey("user.role.user");
    int _jspx_eval_fmx_005fmessage_005f6 = _jspx_th_fmx_005fmessage_005f6.doStartTag();
    if (_jspx_th_fmx_005fmessage_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005ffmx_005fmessage_0026_005fkey_005fbundle_005fnobody.reuse(_jspx_th_fmx_005fmessage_005f6);
    return false;
  }
}