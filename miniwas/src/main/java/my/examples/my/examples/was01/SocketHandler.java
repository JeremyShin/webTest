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
                if(in.readLine() != null) url += line + "\n";
            }

            SplitMachine sm = new SplitMachine(url);
            sm.split();

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try{ in.close(); } catch(Exception e) {}
        }
    }
}
