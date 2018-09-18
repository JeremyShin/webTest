package my.examples.my.examples.was01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

public class SocketHandler extends Thread{
    private String url;
    private Connector connector;
    private Socket socket;

    private String httpMethod;
    private String path;
    // private Map<String, String> header;

    public SocketHandler(Connector connector, Socket socket) {
        this.connector = connector;
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        /*PrintWriter out;*/

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while((line = in.readLine()) != null) {
                url += line + "\n";
            }
            System.out.println(url);
            String firstlLine = url.substring(0, url.lastIndexOf("HTTP/1.1"));
            System.out.println(firstlLine);
            System.out.println(" ");

            httpMethod = firstlLine.substring(0, firstlLine.lastIndexOf("/"));
            path = firstlLine.substring(firstlLine.indexOf("/")+1, firstlLine.lastIndexOf("?"));
            String header = firstlLine.substring(firstlLine.indexOf("?")+1,firstlLine.length()-1);
            System.out.println("httpMethod "+httpMethod);
            System.out.println("path "+path);
            System.out.println("header "+header);


        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try{ in.close(); } catch(Exception e) {}
        }
    }
}
