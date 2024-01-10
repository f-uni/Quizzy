package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import it.quizzy.logiclayer.ClientUtente;
import it.quizzy.logiclayer.manager.UtenteManager;

@WebServlet(urlPatterns = "/sse/*", asyncSupported = true)
public class SSEPartita extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String portaParita = request.getPathInfo();
		HttpSession session = request.getSession();
		UtenteManager um = (UtenteManager) session.getAttribute("um");
		
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");

		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(0);
		
		
		
		ClientUtente clientSocket = new ClientUtente(um.getSessioneUtente(), (String message)->{
			try (PrintWriter writer = response.getWriter()) {
				
				writer.write("event: message\n");
				writer.write("data: "+message+"\n\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		});
		
		while(true) {}
		
	}
}