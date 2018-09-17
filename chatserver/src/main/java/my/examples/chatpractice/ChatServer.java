package my.examples.chatpractice;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


public class ChatServer extends Thread{
    private int port;
    private Set<PrintWriter> socketSet = null;
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
            try{
                out.println(msg);
                out.flush();
            }catch(Exception ex) {}
        }
    }

    @Override
    public void run() {
        // 개발할 것을 여기다가 만든다.
        // 읽고 쓰는 것이 필요하다.

        ServerSocket serverSocket = null;
        try{
            //server단의 소켓에서
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept();
                SocketHandler handler = new SocketHandler(this, socket);
                handler.start();
            }


        }catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            try{ serverSocket.close(); } catch (Exception ex) {}
        }
    }
}
