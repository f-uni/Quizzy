package it.quizzy.logiclayer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ServerPartita extends Thread {
	private ServerSocket server;

	public static final int PORT = 8702;
	public static final String STOP_STRING = "##";
	private List<ConnectedClient> clients;
	private Thread requestProcessor;
	private ConnectedClient clientDocente;
	private Function<Integer, Boolean> newClientCallback;
	
	public ServerPartita(Function<Integer, Boolean> newClientCallback) {
		this.newClientCallback=newClientCallback;
	}

	@Override
	public void run() {
		super.run();
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clients = new ArrayList<>();
		this.requestProcessor=new Thread(() -> {
			processConnections();
		});
		this.requestProcessor.start();
		
		while(true) {}
	}

	private void processConnections(){
		try {
			Socket docenteSocket = server.accept();
			if(docenteSocket.isConnected()) {
				this.clientDocente=new ConnectedClient(docenteSocket, 0);
			}
			while (true) {
				Socket clientSocket = server.accept();

				if (clientSocket.isConnected()) {
					ConnectedClient utente = new ConnectedClient(clientSocket, (int) (Math.random() * 10000));
					if(this.newClientCallback.apply(Integer.parseInt(utente.getMessage()))) {
						this.clients.add(utente);
					}else {
						utente.close();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcastMessage(String str) {
		this.clients.forEach((client) -> {
			client.sendMessage(str);
		});
	}
	
	public void messageDocente(String str) {
		this.clientDocente.sendMessage(str);
	}

	public void stopAcceptRequest() {
		this.requestProcessor.interrupt();
	}
	
	public void stopPartita() {
		this.interrupt();
	}

}
