package it.quizzy.logiclayer.server;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Function;

/**
 * Classe che rappresenta un client connesso al server partita
 */
public class ConnectedClientUtente extends ConnectedClient{
    Function<String, Void> messageCallback;
    

    public ConnectedClientUtente(Socket clientSocket, Function<String, Void> messageCallback) {
        this.clientSocket = clientSocket;
        this.messageCallback=messageCallback;
        try {
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            new Thread(() -> {
				readMessages();
			}).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void readMessages(){
        String line = "";
        while(!line.equals(ServerPartita.STOP_STRING)){
            try {
                line = in.readUTF();
                if(this.messageCallback!=null)
					this.messageCallback.apply(line);
            } catch (IOException e) {
                break;
            }
            System.out.println("Client "+id+ ": "+ line);
        }
        System.out.println("Client "+id+ ": Client Disconnected");
    }
   
	public void setId(Integer id) {
		this.id=id;
        System.out.println("Client "+id+ ": Client Connected");
		
	}

	public Integer getId() {
		return id;
	}
}