package my.examples.chatpractice5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread{
    private int port;
    private Set<PrintWriter> socketSet = null;
    private String name;

    public ChatServer(int port) {
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet();
    }

    public void addPrintWriter(PrintWriter out) {
        socketSet.add(out);
    }

    public void removePrintWriter(PrintWriter out) {
        socketSet.remove(out);
    }

    public void broadcast(String msg) {
        for(PrintWriter out : socketSet) {
            try {
                out.println(msg);
                out.flush();
            }catch (Exception e) {}
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;

        try{
            while(true) {
                Socket socket  = serverSocket.accept();
                SocketHandler handler= new SocketHandler(this, socket);
                handler.start();
            }

        }catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try{serverSocket.close(); } catch (Exception e) {}
        }
    }
}
