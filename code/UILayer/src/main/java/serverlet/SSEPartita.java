package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/sse", asyncSupported = true)
public class SSEPartita extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");

		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(0); // never time out

		// Start a new thread to send events to the client
		new Thread(() -> {
			try (PrintWriter writer = response.getWriter()) {
				for (int i = 0; i < 10; i++) {
					writer.write("event: message\n");
					writer.write("data: This is event " + i + "\n\n");
					writer.flush();
					Thread.sleep(1000);
				}
				asyncContext.complete();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}