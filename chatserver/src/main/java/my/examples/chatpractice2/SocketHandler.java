package my.examples.chatpractice2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("이름을 입력해주세요");
            this.name = in.readLine();
            chatServer.broadcast(this.name + "님이 입장하셨습니다.");

            chatServer.addPrintWriter(out);

            String line = null;

            while((line = in.readLine()) != null) {
                chatServer.broadcast(this.name + " : " + line);
            }

        }catch(Exception ex) {
            System.out.println("SocketHandler Close");
            ex.printStackTrace();
        }finally {
            chatServer.removePrintWriter(out);
            System.out.println(this.name + "님이 퇴장했어요.");
            System.out.println("ChatHandler Close");
            try{ in.close(); } catch (Exception e) {}
            try {out.close(); } catch (Exception e) {}
        }
    }
}
