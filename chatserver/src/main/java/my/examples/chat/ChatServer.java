package my.examples.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread {
    private int port;
    public ChatServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        // 채팅 서버가 해야할 작업을 코딩


        ServerSocket serverSocket = null;
        try {
          serverSocket =   new ServerSocket(port);

            while(true) {
                Socket socket = serverSocket.accept(); // 블러킹 메소드
                SocketHandler handler = new SocketHandler(this, socket);
                handler.start();
            }

        }catch(IOException ioe) {
            ioe.printStackTrace();
        }finally{
            try {
                serverSocket.close();
            }catch (Exception ex) {}

        }

    }
}
