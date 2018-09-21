package my.examples.was02;

import javax.print.attribute.standard.RequestingUserName;
import java.io.*;
import java.net.Socket;

public class Handler extends Thread{
    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 요청 받기
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out , pw);


            // 응답 하기
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {

        }
    }
}
