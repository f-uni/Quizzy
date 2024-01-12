package it.quizzy.logiclayer.server;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectedClientDocente {
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private int id;

    public ConnectedClientDocente(Socket clientSocket, int id) {
        this.clientSocket = clientSocket;
        this.id = id;
        try {
            System.out.println("Client "+id+ ": Client Connected");
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    
    public String getMessage() {
    	try {
			return in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    public void sendMessage(String str) {
    	try {
			out.writeUTF(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void close(){
        try{
            clientSocket.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}