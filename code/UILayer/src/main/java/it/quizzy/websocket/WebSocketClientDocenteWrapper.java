package it.quizzy.websocket;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import it.quizzy.logiclayer.manager.PartitaManager;
import it.quizzy.logiclayer.manager.UtenteManager;
import it.quizzy.logiclayer.server.ClientDocente;
import it.quizzy.logiclayer.server.ClientUtente;

@ServerEndpoint(value = "/host/{sessionId}")
public class WebSocketClientDocenteWrapper {
	ClientDocente client;
	@OnOpen
	public void onOpen(Session session, EndpointConfig config, @PathParam("sessionId") String sessionId) {

		HttpSession httpSession=null;
		try {
			httpSession = SessionManagerShim.getSession(sessionId).getSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (httpSession != null) {
				PartitaManager pm = (PartitaManager) httpSession.getAttribute("partitaCorrente");
				if (pm != null) {
					this.client=new ClientDocente((String message) -> {
						try {
							session.getBasicRemote().sendText(message);
						} catch (IOException e) {
							e.printStackTrace();
						}
						return null;
					});
					pm.aggiungiDocente(this.client);

				}else {
					session.close();
				}
				
			} else {
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OnMessage
	public void onMessage(String message, Session session) {
		try {
			this.client.writeMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session) {
		try {
			this.client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("Error on WebSocket connection: " + session.getId());
		throwable.printStackTrace();
	}

	

}