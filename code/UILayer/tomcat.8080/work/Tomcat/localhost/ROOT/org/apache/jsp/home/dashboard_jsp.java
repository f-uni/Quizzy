/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.97
 * Generated at: 2024-01-09 15:35:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import it.quizzy.logiclayer.manager.DocenteManager;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("it.quizzy.logiclayer.manager.DocenteManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/bulma.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/dashboard.css\">\r\n");
      out.write("    <title>QUIZZY</title>\r\n");
      out.write("</head>\r\n");


DocenteManager dmSession = (DocenteManager)session.getAttribute("dm");  
if(dmSession==null){
	response.sendRedirect("/home/login.jsp");
}else{
	if(!dmSession.isLogged()){
		response.sendRedirect("/home/login.jsp");
	}else{
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"navbar is-high shadow has-border-yellow\" role=\"navigation\" aria-label=\"main navigation\" >\r\n");
      out.write("        <div class=\"navbar-brand\">\r\n");
      out.write("          <a class=\"navbar-item \" href=\"https://bulma.io\">\r\n");
      out.write("            <img src=\"/images/logo4.png\" width=\"100\" height=\"100\">\r\n");
      out.write("          </a>\r\n");
      out.write("      \r\n");
      out.write("          <a role=\"button\" class=\"navbar-burger\" aria-label=\"menu\" aria-expanded=\"false\" data-target=\"navbarBasicExample\">\r\n");
      out.write("            <span aria-hidden=\"true\"></span>\r\n");
      out.write("            <span aria-hidden=\"true\"></span>\r\n");
      out.write("            <span aria-hidden=\"true\"></span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </div>\r\n");
      out.write("      \r\n");
      out.write("        <div id=\"navbarBasicExample\" class=\"navbar-menu\">\r\n");
      out.write("          <div class=\"navbar-start\">\r\n");
      out.write("            <a class=\"navbar-item hover-underline-animation is-active\">\r\n");
      out.write("              HOME\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("            <a class=\"navbar-item hover-underline-animation\">\r\n");
      out.write("              My Quiz\r\n");
      out.write("            </a>\r\n");
      out.write("      \r\n");
      out.write("            <a class=\"navbar-item hover-underline-animation\">\r\n");
      out.write("              All Quiz\r\n");
      out.write("            </a>\r\n");
      out.write("      \r\n");
      out.write("          </div>\r\n");
      out.write("      \r\n");
      out.write("          <div class=\"navbar-end\">\r\n");
      out.write("            <div class=\"navbar-item\">\r\n");
      out.write("                \r\n");
      out.write("              <div class=\"buttons\">\r\n");
      out.write("                <input class=\"searchBar\" type=\"text\" placeholder=\"Search...\">\r\n");
      out.write("                <a class=\"button is-warning shadow\">\r\n");
      out.write("                  <i class=\"fa-solid fa-plus\" aria-hidden=\"true\" ></i><strong>New Quiz</strong>\r\n");
      out.write("                </a>\r\n");
      out.write("                <a class=\"button is-profile\">\r\n");
      out.write("                    <img class=\"profile-image\" src=\"/images/profileDoc.png\" height=\"100\" width=\"100\">\r\n");
      out.write("                </a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <div class=\"container-fluid text-box\">\r\n");
      out.write("        <div class=\"container center\">\r\n");
      out.write("            <img src=\"/images/Logo3-removebg-preview.png\" height=\"500\" width=\"500\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"container-fluid dashedBorder\">\r\n");
      out.write("        <div class=\"container informative\">\r\n");
      out.write("            <div class=\"container informative-div\">\r\n");
      out.write("              <h1  class=\"informative-header\"> About Us</h1>\r\n");
      out.write("              <p class=\"informative-content\">\r\n");
      out.write("                Una scuola bergamasca commissiona la realizzazione di una piattaforma\r\n");
      out.write("                che permetta una diversa interazione professore-studente per migliorare la didattica e l'apprendimento.\r\n");
      out.write("                 Secondo un sondaggio svolto dai professori della scuola, il risultato con piÃ¹ votazioni Ã¨\r\n");
      out.write("                  lâutilizzo di uno strumento di quiz alternativo che possa essere svolto in classe, ma anche \r\n");
      out.write("                  a distanza che risvegli la curiositÃ  degli studenti e gli permetta di imparare e di divertirsi\r\n");
      out.write("                 allo stesso momento.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <img src=\"/images/aboutus.png\" class=\"informative-img\" style=\"display: flex;\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("		benvenuto ");
 out.print(dmSession.getNome()); 
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"/js/dashboard.js\"></script>\r\n");
      out.write("</html>\r\n");
      out.write("		");
 
	}
}


    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
