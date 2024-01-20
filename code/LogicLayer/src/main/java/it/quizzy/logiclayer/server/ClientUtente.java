package it.quizzy.logiclayer.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Function;

import it.quizzy.databaselayer.models.Utente;

public class ClientUtente {
	private Socket clientSocket;
	private DataOutputStream out;
	private DataInputStream in;
	private Function<String, Void> messageCallaback;
	private Utente utente;

	public ClientUtente(Utente utente, Function<String, Void> messageCallaback) {
		try {
			this.utente=utente;
			this.messageCallaback=messageCallaback;
			clientSocket = new Socket("127.0.0.1", ServerPartita.PORT);
			out = new DataOutputStream(clientSocket.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			writeMessage("{}");
			new Thread(() -> {
				readMessages();
			}).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void readMessages() {
		String line = "";
		while (!line.equals(ServerPartita.STOP_STRING)) {
			try {
				line = in.readUTF();
				if(this.messageCallaback!=null)
					this.messageCallaback.apply(line);
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
		out.writeUTF(utente.getRecord().getId().toString()+"$"+text);
	}
	

	public void close() throws IOException {
		clientSocket.close();
		out.close();
		in.close();
	}


}
