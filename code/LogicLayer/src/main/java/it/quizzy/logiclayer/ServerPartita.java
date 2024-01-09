package it.quizzy.logiclayer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ServerPartita extends Thread {
	private ServerSocket server;

	DataOutputStream out;
	public static final int PORT = 3030;
	public static final String STOP_STRING = "##";
	private boolean acceptRequest;
	private List<ConnectedClient> clients;
	
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("Avvio server partita");
			server = new ServerSocket(PORT);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clients=new ArrayList<>();
		this.acceptRequest = true;
		new Thread(() -> {
			while (acceptRequest) {
				try {
					initConnections();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		while (true) {
			System.out.println("scrivo cose");
			broadcastMessage("Scrivo cose sulla socket");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void initConnections() throws IOException {
		Socket clientSocket = server.accept();

		if (clientSocket.isConnected()) {
			System.out.println("new client");
			this.clients.add(new ConnectedClient(clientSocket, (int)(Math.random()*100)));
		}
	}

	public void broadcastMessage(String str) {
		this.clients.forEach((client)->{
			client.sendMessage(str);
		});
	}

	public void stopAcceptRequest() {
		acceptRequest = false;
	}
	
	public static void main(String[] args) {
		new ServerPartita().start();
	}
	
}
