package my.examples.was03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in = null;
    private BufferedReader br = null;
    private Map<String, String> headers = null;
    private String method;
    private String path;


    public Request(InputStream in, BufferedReader br) {
        this.in = in;
        this.br = br;

        try{
            headers = new HashMap<>();

            String requestLine = br.readLine();
            String [] split = requestLine.split(" ");
            if(split.length>2){
                method = split[0];
                path = split[1];
            }

            String headerLine = null;

            while((headerLine = br.readLine()) != null) {
                if (headerLine.equals(""))
                    break;
                int index1 = headerLine.indexOf(':');
                String headerName = null;
                String headerValue = null;
                if(index1 != -1) {
                    headerName = headerLine.substring(0, index1);
                    headerValue = headerLine.substring(index1 + 1).trim();
                }
                headers.put(headerName, headerValue);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }
}
