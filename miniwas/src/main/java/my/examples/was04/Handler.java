package my.examples.was04;


import java.io.*;
import java.net.Socket;

public class Handler extends Thread{
    Socket socket = null;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));

            out = socket.getOutputStream();
            pw = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out, pw);
            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            try{in.close();} catch (Exception e) {}
            try{out.close();} catch (Exception e) {}
            try{br.close();} catch (Exception e) {}
            try{pw.close();} catch (Exception e) {}
        }
    }
}
