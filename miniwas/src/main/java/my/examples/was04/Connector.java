package my.examples.was04;

import java.net.ServerSocket;
import java.net.Socket;

public class Connector {
    private int port;

    public Connector(int port) {
        this.port = port;
    }

    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                 socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{ serverSocket.close();} catch (Exception e) {}
            try{socket.close();} catch (Exception e) {}
        }
    }
}
