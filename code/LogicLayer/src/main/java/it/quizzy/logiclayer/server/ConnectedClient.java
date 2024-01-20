package it.quizzy.logiclayer.server;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Function;

public class ConnectedClient {
    private Integer id;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    Function<String, Void> messageCallaback;

    public ConnectedClient(Socket clientSocket, Function<String, Void> messageCallaback) {
        this.clientSocket = clientSocket;
        this.messageCallaback=messageCallaback;
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

    public void readMessages(){
        String line = "";
        while(!line.equals(ServerPartita.STOP_STRING)){
            try {
                line = in.readUTF();
                if(this.messageCallaback!=null)
					this.messageCallaback.apply(line);
            } catch (IOException e) {
                e.printStackTrace();
                break;
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

	public void setId(Integer id) {
		this.id=id;
        System.out.println("Client "+id+ ": Client Connected");
		
	}

	public Integer getId() {
		return id;
	}
}