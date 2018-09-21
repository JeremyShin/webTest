package my.examples.was04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    InputStream in = null;
    BufferedReader br = null;
    String method;
    String path;
    Map<String, String> headers = null;

    public Request(InputStream in, BufferedReader br) {
        this.in = in;
        this.br = br;
        headers = new HashMap<>();

        try{
            String requestLine = br.readLine();
            String[] split = requestLine.split(" ");
            if(split.length > 2) {
                method = split[0];
                path = split[1];
            }

            String headerLine = null;
            while((headerLine = br.readLine()) != null) {
                if(headerLine.equals("")) break;

                int idx1 = headerLine.indexOf(":");
                String headerName = null;
                String headerValue = null;
                if(idx1 != -1) {
                  headerName = headerLine.substring(0, idx1);
                  headerValue = headerLine.substring(idx1+1);
                }
                headers.put(headerName, headerValue);
            }
        }catch (Exception ex) {
            throw new RuntimeException("잘못된 요청 : "+ex.toString());
        }
    }

    public InputStream getIn() {
        return in;
    }

    public BufferedReader getBr() {
        return br;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getUserAgent() {
        return headers.get("User-Agent");
    }

    public String getCookie() {
        return headers.get("Cookie");
    }

    public String getAccept() {
        return headers.get("User-Agent");
    }
}

