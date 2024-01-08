package it.quizzy.logiclayer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerPartita {
	private ServerSocket server;
	Socket clientSocket;

	DataOutputStream out;
	public static final int PORT = 3030;
	public static final String STOP_STRING = "##";

	public ServerPartita() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> {
			while (true)
				try {
					initConnections();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}).start();
		try {
			clientSocket = new Socket("127.0.0.1", ServerPartita.PORT);
			out = new DataOutputStream(clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initConnections() throws IOException {
		Socket clientSocket = server.accept();

		if (clientSocket.isConnected())
			System.out.println("new client");
	}

	private void writeMessage(String data) throws IOException {
		
		out.writeUTF(data);
		out.flush();
	}

	public static void main(String[] args) {
		ServerPartita sp = new ServerPartita();
		int n=0;
		while (true) {
			try {
				sp.writeMessage("msg: " + n);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
