package my.examples.chatpractice;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread{
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in  = null;
        PrintWriter out = null;
        try{
            System.out.println("SocketHandler Start");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("이름을 입력하세요.");
            this.name = in.readLine();
            chatServer.broadcast(this.name + "님이 입장하셨습니다.");

            chatServer.addPrintWriter(out);

            String line = null;

            while((line = in.readLine()) != null){
                chatServer.broadcast(this.name + " : " + line);
            }

        }catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("ChatHandler Close");
        }finally {
            chatServer.removePrintWriter(out);
            chatServer.broadcast(this.name + "님이 퇴장했어요");
            System.out.println("ChatHandler Closes");
            try{ in.close(); } catch(Exception ex) {}
            try { out.close(); } catch (Exception ex) {}
        }

    }
}
