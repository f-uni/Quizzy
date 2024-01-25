package it.quizzy.logiclayer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.json.JSONObject;

import it.quizzy.databaselayer.models.Utente;

/**
 * Servizio per la creazione di una partita
 */
public class ServerPartita extends Thread {
	private ServerSocket server;

	public static final String STOP_STRING = "##";
	private List<ConnectedClientUtente> clients;
	private Thread requestProcessor;
	private ConnectedClientDocente clientDocente;
	private Function<Integer, Boolean> newClientCallback;
	private BiFunction<Integer, String, Void> valutaRisposta;

	/** Costruttore per la creazione di un server per una partita
	 * 
	 * @param newClientCallback callback per la connessione di nuovi client
	 * @param valutaRisposta callback per valutare le risposte
	 */
	public ServerPartita(Function<Integer, Boolean> newClientCallback,
			BiFunction<Integer, String, Void> valutaRisposta) {
		this.newClientCallback = newClientCallback;
		this.valutaRisposta = valutaRisposta;
		this.clients = new ArrayList<>();
		try {
			server = new ServerSocket(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		super.run();
		this.requestProcessor = new Thread(() -> {
			processConnections();
		});
		this.requestProcessor.start();
		while (true) {
		}
	}

	/**
	 * Metodo per la processione continua di nuove connessioni da parte dei client
	 */
	private void processConnections() {
		try {
			Socket docenteSocket = server.accept();
			if (docenteSocket.isConnected()) {
				this.clientDocente = new ConnectedClientDocente(docenteSocket);
			}
			while (true) {
				Socket clientSocket = server.accept();
				if (clientSocket.isConnected()) {
					ConnectedClientUtente utente = new ConnectedClientUtente(clientSocket, (String message) -> {
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
						String message = utente.getMessage();
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
			System.out.println("Server Chiuso");
		}
	}

	/**
	 * Metodo per inviare a tutti i client un messaggio
	 * 
	 * @param str stringa contenete il messaggio
	 */
	public void broadcastMessage(String str) {
		this.clients.forEach((client) -> {
			client.sendMessage(str);
		});
	}

	/**
	 * Metodo per mandare un messaggio al docente che ha creato la partita
	 * @param str
	 */
	public void messageDocente(String str) {
		if (this.clientDocente != null)
			this.clientDocente.sendMessage(str);
	}

	/**
	 * Metodo per interrompere l'accettazione di nuovi client una volta iniziata la partita
	 */
	public void stopAcceptRequest() {
		this.requestProcessor.interrupt();
	}

	/**
	 * Metodo per terminare la partita, chiude le connessioni con tutti i client e chiude la socket del server
	 */
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

	/**
	 * Metodo per inviare ad uno specifico client un messaggio
	 * 
	 * @param idClient id del client a cui si desidera inviare il messaggio
	 * @param message stringa contenete il messaggio
	 */
	public void utenteMessage(Integer idClient, String message) {
		for (ConnectedClientUtente c : clients) {
			if (c.getId().equals(idClient)) {
				c.sendMessage(message);
				break;
			}
		}
	}

	/**
	 * @return intero con la porta della socket creata
	 */
	public int getPort() {
		return this.server.getLocalPort();
	}

}
