package my.examples.my.examples.was01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector extends Thread{
    private int port;

    public Connector(int port) {
        this.port = port;
    }



    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);

            while(true) {
                socket = serverSocket.accept();
                SocketHandler handler = new SocketHandler(this, socket);
                handler.start();
            }

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            try{socket.close();} catch(Exception ex) {}
        }
    }
}
