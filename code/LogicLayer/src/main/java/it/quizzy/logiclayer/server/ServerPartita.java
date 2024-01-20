package it.quizzy.logiclayer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.json.JSONObject;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Utente;

public class ServerPartita extends Thread {
	private ServerSocket server;

	public static final int PORT = 8702;
	public static final String STOP_STRING = "##";
	private List<ConnectedClient> clients;
	private Thread requestProcessor;
	private ConnectedClientDocente clientDocente;
	private Function<Integer, Boolean> newClientCallback;
	private BiFunction<Integer, String, Void> valutaRisposta;

	public ServerPartita(Function<Integer, Boolean> newClientCallback,
			BiFunction<Integer, String, Void> valutaRisposta) {
		this.newClientCallback = newClientCallback;
		this.valutaRisposta = valutaRisposta;
	}

	@Override
	public void run() {
		super.run();
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clients = new ArrayList<>();
		this.requestProcessor = new Thread(() -> {
			processConnections();
		});
		this.requestProcessor.start();

		while (true) {
		}
	}

	private void processConnections() {
		try {
			Socket docenteSocket = server.accept();
			if (docenteSocket.isConnected()) {
				this.clientDocente = new ConnectedClientDocente(docenteSocket, 0);
			}
			while (true) {
				Socket clientSocket = server.accept();

				if (clientSocket.isConnected()) {
					ConnectedClient utente = new ConnectedClient(clientSocket, (String message) -> {
						String[] msgs = message.split("\\$");
						Integer idUtente = Integer.parseInt(msgs[0]);
						String event = msgs[1];
						if (event.equals("risposta") && idUtente != null) {
							JSONObject jo = new JSONObject(msgs[2]);
							String risposta = (String) jo.get("risposta");
							this.valutaRisposta.apply(idUtente, risposta);
						}
						return null;
					});

					try {
						String message=utente.getMessage();
						String[] msgs = message.split("\\$");
						Integer idUtente = Integer.parseInt(msgs[0]);
						Utente u = new Utente(idUtente);
						if (this.newClientCallback.apply(u.getRecord().getId())) {
							utente.setId(u.getRecord().getId());
							this.clients.add(utente);
						} else {
							utente.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcastMessage(String str) {
		this.clients.forEach((client) -> {
			client.sendMessage(str);
		});
	}

	public void messageDocente(String str) {
		if (this.clientDocente != null)
			this.clientDocente.sendMessage(str);
	}

	public void stopAcceptRequest() {
		this.requestProcessor.interrupt();
	}

	public void stopPartita() {
		this.clients.forEach((client) -> {
			client.close();
		});
		try {
			this.server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.interrupt();
	}

	public void utenteMessage(Integer idClient, String message) {
		for(ConnectedClient c : clients) {
			if(c.getId().equals(idClient)) {
				c.sendMessage(message);
				break;
			}
		}
	}

}
