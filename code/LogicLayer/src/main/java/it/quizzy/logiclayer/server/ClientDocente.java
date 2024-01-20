package it.quizzy.logiclayer.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Function;

public class ClientDocente {
	private Socket clientSocket;
	private DataOutputStream out;
	private DataInputStream in;
	private Function<String, Void> messageCallaback;

	public ClientDocente(int port, Function<String, Void> messageCallaback) {
		try {
			clientSocket = new Socket("127.0.0.1", port);
			if (clientSocket.isConnected()) {
				out = new DataOutputStream(clientSocket.getOutputStream());
				in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
				this.messageCallaback=messageCallaback;
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
		out.writeUTF(text);
	}

	public void close() throws IOException {
		clientSocket.close();
		out.close();
		in.close();
	}


}
