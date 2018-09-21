package my.examples.was03;

import java.io.*;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

public class Handler extends Thread {
    private Socket socket;
    private String method;
    private String path;
    private Map<String, String> headers;

    public Handler(Socket socket) {
        this.socket = socket;
        this.headers = new LinkedHashMap<>();
    }

    @Override
    public void run() {
        InputStream in = null;
        BufferedReader br = null;

        OutputStream out = null;
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

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try { in.close();} catch (Exception ex) {}
            try {out.close();} catch (Exception ex) {}
            try { br.close();} catch (Exception ex) {}
            try { pw.close(); } catch (Exception ex) {}
        }

    }
}
