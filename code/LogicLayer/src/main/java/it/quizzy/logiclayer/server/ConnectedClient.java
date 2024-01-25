package it.quizzy.logiclayer.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class ConnectedClient {
	protected int id;
	protected Socket clientSocket;
	protected DataInputStream in;
	protected DataOutputStream out;
	
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
			e.printStackTrace();
		}
		return null;
    }
    
    public void sendMessage(String str) {
    	try {
			out.writeUTF(str);
		} catch (IOException e) {
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
