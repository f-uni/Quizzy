package it.quizzy.logiclayer.server;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Classe che rappresenta un client docente connesso al server partita
 */
public class ConnectedClientDocente extends ConnectedClient {
	
	/**
     * Costruttore per la rappresentazione di un client docente connesso al server partita
     * @param clientSocket socket che ha ricevuto la richiesta
     */
    public ConnectedClientDocente(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.id = 0;
        try {
            System.out.println("Client "+id+ ": Client Connected");
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}