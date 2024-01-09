package it.quizzy.logiclayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ServerPartita extends Thread {
	private ServerSocket server;

	public static final int PORT = 3030;
	public static final String STOP_STRING = "##";
	private List<ConnectedClient> clients;
	private Thread requestProcessor;
	public ServerPartita() {}

	@Override
	public void run() {
		super.run();
		try {
			System.out.println("Avvio server partita");
			server = new ServerSocket(PORT);

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clients = new ArrayList<>();
		this.requestProcessor=new Thread(() -> {
			try {
				/*Socket clientSocket = server.accept();
				if(clientSocket.isConnected())
					this.clientDocente=new ConnectedClient(clientSocket, PORT);*/
				while (true) {
					initConnections();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		this.requestProcessor.start();
		
		while(true) {}
	}

	private void initConnections() throws IOException {
		Socket clientSocket = server.accept();

		if (clientSocket.isConnected()) {
			System.out.println("new client");
			this.clients.add(new ConnectedClient(clientSocket, (int) (Math.random() * 10000)));
			
			//this.pm.aggiungiGiocatore(null);
		}
	}

	public void broadcastMessage(String str) {
		this.clients.forEach((client) -> {
			client.sendMessage(str);
		});
	}

	public void stopAcceptRequest() {
		this.requestProcessor.interrupt();
	}
	
	public void stopPartita() {
		this.interrupt();
	}

}
