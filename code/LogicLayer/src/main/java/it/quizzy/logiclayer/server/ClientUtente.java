package it.quizzy.logiclayer.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.function.Function;

import it.quizzy.databaselayer.models.Utente;

/**
 * Client socket per la connessione ad un server partita
 */
public class ClientUtente extends Client{
	
	private Utente utente;

	public ClientUtente(int port, Utente utente, Function<String, Void> messageCallback) {
		try {
			this.utente = utente;
			this.messageCallback = messageCallback;
			clientSocket = new Socket(InetAddress.getByName(null), port);
			if (clientSocket.isConnected()) {
				out = new DataOutputStream(clientSocket.getOutputStream());
				in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
				writeMessage("{}");
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
	
	@Override
	public void writeMessage(String text) throws IOException {
		out.writeUTF(utente.getRecord().getId().toString() + "$" + text);
	}


}
