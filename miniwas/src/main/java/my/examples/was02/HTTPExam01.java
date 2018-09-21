package my.examples.was02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPExam01 {
    public static void main(String[] args) throws Exception{
        // 1) 접속
        // 2) 요청(요청라인, 헤더, 빈줄, 바디)
        // 3) 응답(응답라인, 헤더, 빈줄, 바디)
        // 4) 연결 close

        ServerSocket serverSocket = null;
        Socket socket = null;

        serverSocket  = new ServerSocket(8888);
        socket = serverSocket.accept();

        // 요청받기
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String requestLine = br.readLine();
        System.out.println(requestLine);

        String headerLine = null;
        while((headerLine = br.readLine()) != null) {
            if(headerLine.equals("")) break;
            System.out.println("header Line : "+headerLine);
        }


        // 응답하기

        File file = new File("C://java//index.html");

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html; charset=UTF-8");
        pw.println("Content-Length: " + file.length());
        pw.println("");
        pw.flush();

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int readCnt = 0;
        while ((readCnt = fis.read(buffer))!= -1) {
            out.write(buffer, 0, readCnt);
            out.flush();
        }


        // Close
        in.close();
        fis.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}
