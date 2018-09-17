package my.examples.chatpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient extends Thread{
    private String ip;
    private int port;
    private String name;

    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader keyboard = null;

        try{
            socket = new Socket(ip, port);
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("이름을 입력하세요");
            this.name = keyboard.readLine();
            out.print(name);
            out.flush();
            InputHandler handler = new InputHandler(in);
            handler.start();

            String line = null;
            while((line = keyboard.readLine()) != null) {
                if(line.equals("quit!!"))  break;
                out.println(line);
                out.flush();
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try{ socket.close(); } catch (Exception e) {}
            try{in.close(); } catch (Exception e) {}
            out.close();

        }
    }
}
