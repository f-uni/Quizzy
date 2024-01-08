package it.quizzy.logiclayer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientUtente {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public ClientUtente(){
        try{
        	clientSocket = new Socket("127.0.0.1", ServerPartita.PORT);
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            new Thread(()->{
            	readMessages();
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void writeMessage(String data) throws IOException {
        
        out.writeUTF(data);
        
    }
    
    public void readMessages(){
        String line = "";
        while(!line.equals(ServerPartita.STOP_STRING)){
        	System.out.println("leggo");
            try {
                line = in.readUTF();
                System.out.println("new message from server: "+ line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
			close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void close() throws IOException {
    	clientSocket.close();
        out.close();
        in.close();
    }
    
    public static void main(String[] args) {
        ClientUtente c = new ClientUtente();
        try {
			c.writeMessage("cico sono ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
