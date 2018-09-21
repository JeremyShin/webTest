package my.examples.was03;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {

    private OutputStream out;
    private PrintWriter pw;

    private String method;
    private String path;
    private long contentLength;
    private int statusCode;

    public Response(OutputStream out, PrintWriter pw) {
        this.out = out;
        this.pw = pw;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
}
