package it.quizzy.logiclayer.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.function.Function;

import it.quizzy.databaselayer.models.Utente;

public class ClientUtente {
	private Socket clientSocket;
	private DataOutputStream out;
	private DataInputStream in;
	private Function<String, Void> messageCallback;
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

	public void readMessages() {
		String line = "";
		while (!line.equals(ServerPartita.STOP_STRING)) {
			try {
				if (in.available() > 0) {
					line = in.readUTF();
					if (this.messageCallback != null)
						this.messageCallback.apply(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		try {
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeMessage(String text) throws IOException {
		out.writeUTF(utente.getRecord().getId().toString() + "$" + text);
	}

	public void close() throws IOException {
		clientSocket.close();
		out.close();
		in.close();
	}

}
