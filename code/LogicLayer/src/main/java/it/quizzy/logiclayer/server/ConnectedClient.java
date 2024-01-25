package it.quizzy.logiclayer.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Classe astratta per la rappresentazione di un client connesso al server partita
 */
public abstract class ConnectedClient {
	protected int id;
	protected Socket clientSocket;
	protected DataInputStream in;
	protected DataOutputStream out;
	
	/**
	 * Metodo per il processamento dei messaggi
	 */
	public void readMessages(){
        String line = "";
        while(!line.equals(ServerPartita.STOP_STRING)){
            try {
                line = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client "+id+ ": "+ line);
        }
        System.out.println("Client "+id+ ": Client Disconnected");
    }
    
    /**
     * Metodo per la lettura del prossimo messaggio sulla socket
     * 
     * @return la stringa contenete il messaggio
     */
    public String getMessage() {
    	try {
			return in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * Metodo per l'invio di un messaggio sulla socket
     * 
     * @param str stringa contenete il messaggio
     */
    public void sendMessage(String str) {
    	try {
			out.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Metodo per la chiusura della connessione
     */
    public void close(){
        try{
            clientSocket.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
