package it.quizzy.logiclayer.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.function.Function;

/**
 * Client socket docente per la connessione ad un server partita
 */
public class ClientDocente extends Client {

	/**
	 * Costruttore per la creazione di un client per la connessione di un docente ad un server partita
	 * @param port porta di connessione
	 * @param messageCallback callback per il processamento dei messaggi
	 */
	public ClientDocente(int port, Function<String, Void> messageCallback) {
		try {
			clientSocket = new Socket(InetAddress.getByName(null), port);
			if (clientSocket.isConnected()) {
				out = new DataOutputStream(clientSocket.getOutputStream());
				in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
				this.messageCallback=messageCallback;
				new Thread(() -> {
					readMessages();
				}).start();
			} else {
				clientSocket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	


}
