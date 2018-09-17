package my.examples.chatpractice3;

import java.io.PrintWriter;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread{
    private int port;
    private Set<PrintWriter> socketSet = null;

    public ChatServer(int port) {
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet();
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }

    public void removePrintWriter(PrintWriter out) {
        socketSet.remove(out);
    }

    public void broadcast(String msg) {
        try{
            for(PrintWriter out : socketSet) {
                out.println(msg);
                out.flush();
            }
        }catch  (Exception e) {}
    }

    @Override
    public void run() {
        // 개발할 것을 적자

    }
}
