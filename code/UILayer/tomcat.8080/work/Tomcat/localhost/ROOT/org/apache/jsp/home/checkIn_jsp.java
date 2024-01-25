/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.97
 * Generated at: 2024-01-25 09:09:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import it.quizzy.uilayer.launch.Configuration;
import it.quizzy.logiclayer.manager.PartitaManager;
import it.quizzy.logiclayer.manager.DocenteManager;

public final class checkIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("it.quizzy.uilayer.launch.Configuration");
    _jspx_imports_classes.add("it.quizzy.logiclayer.manager.PartitaManager");
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/background.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/checkIn.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/btn.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

DocenteManager dmSession = (DocenteManager) session.getAttribute("dm");
String quiz = request.getParameter("quiz");
if (dmSession == null) {
	response.sendRedirect("/home/login.jsp");
} else {
	if (!dmSession.isLogged()) {
		response.sendRedirect("/home/login.jsp");
	} else {
		if (quiz == null) {
	response.sendRedirect("/home/myQuizzies.jsp");
		} else {
	PartitaManager pm = new PartitaManager(dmSession.getId(), Integer.parseInt(quiz));
	session.setAttribute("partitaCorrente", pm);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"text-pin\">\r\n");
      out.write("			PIN: ");

			out.print(pm.getPin());
			
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<p class=\"text-join\">Player partecipating:</p>\r\n");
      out.write("		<div class=\"middle\">\r\n");
      out.write("			<div class=\"grid-container\" id=\"players\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<button class=\"simple-btn\"><a href=\"/home/prossimaDomanda.jsp\">Avvia Partita</a></button>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	const sessionId =\r\n");
out.print("\"" + session.getId() + "\"");
      out.write("\r\n");
      out.write("	;\r\n");
      out.write("	const url =\r\n");
out.print("\"" + Configuration.publicURL + "\"");
      out.write("\r\n");
      out.write("	;\r\n");
      out.write("\r\n");
      out.write("	let socket = new WebSocket(\"ws://\" + url + \"/host/\" + sessionId);\r\n");
      out.write("\r\n");
      out.write("	socket.onopen = function(e) {\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	socket.onmessage = function(event) {\r\n");
      out.write("		console.log(event.data);\r\n");
      out.write("		var data = event.data.toString();\r\n");
      out.write("		var evento = data.split(\"$\")[0];\r\n");
      out.write("		if (evento == \"new_player\") {\r\n");
      out.write("			var d = JSON.parse(data.replace(evento + \"$\", \"\"));\r\n");
      out.write("			document.getElementById(\"players\").innerHTML += '<div class=\"grid-item\"><img class=\"img-avatar-display\" src=\"/images/avatar'+d.avatar+'.png\">'\r\n");
      out.write("					+ '<p class=\"text-avatar-display\">'\r\n");
      out.write("					+ d.nickname\r\n");
      out.write("					+ '</p></div>'\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	socket.onclose = function(event) {\r\n");
      out.write("		if (event.wasClean) {\r\n");
      out.write("			alert(`[close] Connessione chiusa con successo, code=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${event.code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" reason=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${event.reason}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`);\r\n");
      out.write("		} else {\r\n");
      out.write("			alert('[close] Connection morta.');\r\n");
      out.write("		}\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	socket.onerror = function(error) {\r\n");
      out.write("		alert(`[error] ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error.message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`);\r\n");
      out.write("	};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");

}
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
