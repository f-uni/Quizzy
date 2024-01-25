package it.quizzy.logiclayer.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Function;

public abstract class Client {
	protected Socket clientSocket;
	protected DataOutputStream out;
	protected DataInputStream in;
	protected Function<String, Void> messageCallback;
	
	public void readMessages() {
		String line = "";
		while (!line.equals(ServerPartita.STOP_STRING)) {
			try {
				line = in.readUTF();
				if(this.messageCallback!=null)
					this.messageCallback.apply(line);
			} catch (IOException e) {
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
