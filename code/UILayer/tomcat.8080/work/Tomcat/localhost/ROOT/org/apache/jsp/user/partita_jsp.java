/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.97
 * Generated at: 2024-01-20 16:00:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import it.quizzy.logiclayer.manager.UtenteManager;

public final class partita_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("it.quizzy.logiclayer.manager.UtenteManager");
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write(".is-hidden {\r\n");
      out.write("	display: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");

String nickname = (String) request.getParameter("nickname");
Integer avatar = Integer.parseInt(request.getParameter("avatar"));
String pin = (String) session.getAttribute("pin");

if (nickname == null || pin == null || avatar == null) {
	response.sendRedirect("/user/pin.jsp");
} else {
	UtenteManager um = new UtenteManager(nickname, pin, avatar);
	session.setAttribute("um", um);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"domandaVF\" class=\"is-hidden\">\r\n");
      out.write("\r\n");
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/track.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/background.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/questionVF.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"timeview\"></div>\r\n");
      out.write("	<div class=\"loader\"></div>\r\n");
      out.write("	<button class=\"timer\">11</button>\r\n");
      out.write("	<div class=\"question  shadow\" id=\"domandaVeroFalso\">ì----------------\r\n");
      out.write("		questions here -----------------ì</div>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"answer one\" id=\"Vero\">\r\n");
      out.write("			<span class=\"leftCol\">\r\n");
      out.write("				<button class=\"circle one\">A</button>\r\n");
      out.write("			</span>\r\n");
      out.write("			<p class=\"content-p\">Vero</p>\r\n");
      out.write("			<img class=\"img-answ\" src=\"/images/circle.png\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"answer two\" id=\"Falso\">\r\n");
      out.write("			<span class=\"leftCol\">\r\n");
      out.write("				<button class=\"circle two\">B</button>\r\n");
      out.write("			</span>\r\n");
      out.write("			<p class=\"content-p\">Falso</p>\r\n");
      out.write("			<img class=\"img-answ\" src=\"/images/square.png\">\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("	</html>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"domandaRM\" class=\"is-hidden\">\r\n");
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/track.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/background.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/question.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"timeview\"></div>\r\n");
      out.write("	<div class=\"loader\"></div>\r\n");
      out.write("	<button class=\"timer\">11</button>\r\n");
      out.write("	<div class=\"question  shadow\" id=\"domandaRispostaMultipla\">ì----------------\r\n");
      out.write("		questions here -----------------ì</div>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"answer one\" id=\"R1\">\r\n");
      out.write("			<span class=\"leftCol\">\r\n");
      out.write("				<button class=\"circle one\">A</button>\r\n");
      out.write("			</span>\r\n");
      out.write("			<p class=\"content-p\" id=\"R1-content\">a.no.1</p>\r\n");
      out.write("			<img class=\"img-answ\" src=\"/images/circle.png\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"answer two\" id=\"R2\">\r\n");
      out.write("			<span class=\"leftCol\">\r\n");
      out.write("				<button class=\"circle two\">B</button>\r\n");
      out.write("			</span>\r\n");
      out.write("			<p class=\"content-p\" id=\"R2-content\">a no.2</p>\r\n");
      out.write("			<img class=\"img-answ\" src=\"/images/square.png\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"answer three\" id=\"R3\">\r\n");
      out.write("			<span class=\"leftCol\">\r\n");
      out.write("				<button class=\"circle three\">C</button>\r\n");
      out.write("			</span>\r\n");
      out.write("			<p class=\"content-p\" id=\"R3-content\">a no.3</p>\r\n");
      out.write("			<img class=\"img-answ\" src=\"/images/rhombus.png\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"answer four\" id=\"R4\">\r\n");
      out.write("			<span class=\"leftCol\">\r\n");
      out.write("				<button class=\"circle four\">D</button>\r\n");
      out.write("			</span>\r\n");
      out.write("			<p class=\"content-p\" id=\"R4-content\">a no.3</p>\r\n");
      out.write("			<img class=\"img-answ\" src=\"/images/triangle.png\">\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("	</html>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"wait\" class=\"\">\r\n");
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/background.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/loading.css\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<span class=\"back\"> <span>W</span> <span>a</span> <span>i</span>\r\n");
      out.write("		<span>t</span> <span>i</span> <span>n</span> <span>g</span>\r\n");
      out.write("	</span>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("	</html>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"rispostaCorretta\" class=\"is-hidden\">\r\n");
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/background.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/login.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/placing.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/answers.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"centered-div\">\r\n");
      out.write("		<p class=\"label-text position\">CORRECT ANSWER!</p>\r\n");
      out.write("		<div class=\"middle\">\r\n");
      out.write("			<div class=\"points\">\r\n");
      out.write("				<div class=\"inside-points\">\r\n");
      out.write("					<p class=\"text-points\">+100</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<img src=\"/images/rigthAnswer.png\" class=\"img-answer\">\r\n");
      out.write("			<div class=\"inner\">\r\n");
      out.write("				<div class=\"rigth\">\r\n");
      out.write("					<p class=\"label-text position\" id=\"RC-pos\">13th</p>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"left\">\r\n");
      out.write("					<p class=\"label-text\" id=\"RC-punti\">Your Points: 9999</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("	</html>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"rispostaErrata\" class=\"is-hidden\">\r\n");
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>QUIZZY</title>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/images/Logo3.png\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/background.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/login.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/placing.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/answers.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"centered-div\">\r\n");
      out.write("		<p class=\"label-text position\">WRONG ANSWER!</p>\r\n");
      out.write("		<div class=\"middle\">\r\n");
      out.write("			<div class=\"points\">\r\n");
      out.write("				<div class=\"inside-points\">\r\n");
      out.write("					<p class=\"text-points\">+0</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<img src=\"/images/wrongAnswer.png\" class=\"img-answer\">\r\n");
      out.write("			<div class=\"inner\">\r\n");
      out.write("				<div class=\"rigth\">\r\n");
      out.write("					<p class=\"label-text position\" id=\"RE-pos\">13th</p>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"left\">\r\n");
      out.write("					<p class=\"label-text \" id=\"RE-punti\">Your Points: 9999</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("	</html>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	const sessionId =\r\n");
out.print("\"" + session.getId() + "\"");
      out.write("\r\n");
      out.write("	;\r\n");
      out.write("\r\n");
      out.write("	let socket = new WebSocket(\"ws://127.0.0.1:8080/join/\" + sessionId);\r\n");
      out.write("\r\n");
      out.write("	socket.onopen = function(e) {\r\n");
      out.write("		alert(\"[open] Connessione stabilita\");\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	socket.onmessage = function(event) {\r\n");
      out.write("		console.log(event.data);\r\n");
      out.write("		var data = JSON.parse(event.data.split(\"$\")[1]);\r\n");
      out.write("		var evento = event.data.split(\"$\")[0];\r\n");
      out.write("\r\n");
      out.write("		switch (evento) {\r\n");
      out.write("		case \"new_domanda_0\":\r\n");
      out.write("			nuovaDomandaVeroFalso(data);\r\n");
      out.write("			break;\r\n");
      out.write("		case \"new_domanda_1\":\r\n");
      out.write("			nuovaDomandaRispostaMultipla(data);\r\n");
      out.write("			break;\r\n");
      out.write("		case \"risposta_corretta\":\r\n");
      out.write("			rispostaCorretta(data);\r\n");
      out.write("			break;\r\n");
      out.write("		case \"risposta_errata\":\r\n");
      out.write("			rispostaErrata(data);\r\n");
      out.write("			break;\r\n");
      out.write("		case \"wait\":\r\n");
      out.write("			wait();\r\n");
      out.write("			break;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	socket.onclose = function(event) {\r\n");
      out.write("		\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	socket.onerror = function(error) {\r\n");
      out.write("		alert(`[error] ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error.message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`);\r\n");
      out.write("	};\r\n");
      out.write("\r\n");
      out.write("	function resetView() {\r\n");
      out.write("		document.getElementById(\"domandaVF\").classList.add(\"is-hidden\");\r\n");
      out.write("		document.getElementById(\"domandaRM\").classList.add(\"is-hidden\");\r\n");
      out.write("		document.getElementById(\"wait\").classList.add(\"is-hidden\");\r\n");
      out.write("		document.getElementById(\"rispostaCorretta\").classList.add(\"is-hidden\");\r\n");
      out.write("		document.getElementById(\"rispostaErrata\").classList.add(\"is-hidden\");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function nuovaDomandaVeroFalso(data) {\r\n");
      out.write("		resetView();\r\n");
      out.write("		document.getElementById(\"domandaVeroFalso\").innerHTML = data.domanda;\r\n");
      out.write("		document.getElementById(\"Vero\").onclick = ()=>rispondiDomanda(\"vero\");\r\n");
      out.write("		document.getElementById(\"Falso\").onclick = ()=>rispondiDomanda(\"falso\");\r\n");
      out.write("		document.getElementById(\"domandaVF\").classList.remove(\"is-hidden\");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function nuovaDomandaRispostaMultipla(data) {\r\n");
      out.write("		resetView();\r\n");
      out.write("		document.getElementById(\"domandaRispostaMultipla\").innerHTML = data.domanda;\r\n");
      out.write("		data.risposte.forEach((e, index)=>{\r\n");
      out.write("			index++;\r\n");
      out.write("			console.log(\"R\"+index+\"-content\");\r\n");
      out.write("			document.getElementById(\"R\"+index+\"-content\").innerHTML=data.risposte[index-1];\r\n");
      out.write("			document.getElementById(\"R\"+index).onclick=()=>rispondiDomanda(data.risposte[index-1]);;\r\n");
      out.write("		});\r\n");
      out.write("		document.getElementById(\"domandaRM\").classList.remove(\"is-hidden\");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function wait(){\r\n");
      out.write("		resetView();\r\n");
      out.write("		document.getElementById(\"wait\").classList.remove(\"is-hidden\");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function rispostaCorretta(data){\r\n");
      out.write("		resetView();\r\n");
      out.write("		document.getElementById(\"RC-pos\").innerHTML=\"\";\r\n");
      out.write("		document.getElementById(\"RC-punti\").innerHTML=\"Your Points: \"+data.punti;\r\n");
      out.write("		document.getElementById(\"rispostaCorretta\").classList.remove(\"is-hidden\");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function rispostaErrata(data){\r\n");
      out.write("		resetView();\r\n");
      out.write("		document.getElementById(\"RE-pos\").innerHTML=\"\";\r\n");
      out.write("		document.getElementById(\"RE-punti\").innerHTML=\"Your Points: \"+data.punti;\r\n");
      out.write("		document.getElementById(\"rispostaErrata\").classList.remove(\"is-hidden\");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function rispondiDomanda(risp){\r\n");
      out.write("		console.log(risp);\r\n");
      out.write("		wait();\r\n");
      out.write("		socket.send(\"risposta$\"+JSON.stringify({risposta:risp}));\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");

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
