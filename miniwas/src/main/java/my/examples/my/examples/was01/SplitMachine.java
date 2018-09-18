package my.examples.my.examples.was01;


public class SplitMachine {
    private String url;
    private String httpMethod;
    private String path;
    private String headerInfo;



    public SplitMachine(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHeaderInfo() {
        return headerInfo;
    }

    public void setHeaderInfo(String headerInfo) {
        this.headerInfo = headerInfo;
    }


    public void split() {
        String firstlLine = url.substring(0, url.lastIndexOf("HTTP/1.1"));
        httpMethod = firstlLine.substring(0, firstlLine.lastIndexOf(" /")).replace("null", "");
        path = firstlLine.substring(firstlLine.indexOf("/")+1, firstlLine.lastIndexOf("?"));
        headerInfo = firstlLine.substring(firstlLine.indexOf("?")+1,firstlLine.length()-1);
    }
}
