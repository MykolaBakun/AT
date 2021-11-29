package practice.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class Request {

    private String method; //GET, PUT, POST, DELETE
    //http://localhost:8080/logan_park/new_report_general
    //private String baseURL; // https://host.com:8080/asdf/asd?qrg1&arg2=2

    //URL
    private String protocol;//https, http, ftp ...
    private int port;
    private String host;//host.com , 127.0.0.1
    private String path;// /asdf/asd
    private Map<String,String> argMap;// /asdf/asd

    private String body;

    private Map<String,String> headerMap;

    public URI getURI() {
        //.uri(new URI("https://postman-echo.com/get"))
        try {
            return new URI(protocol+"://"+host+"/"+path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //TODO
        return null;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getArgMap() {
        return argMap;
    }

    public void setArgMap(Map<String, String> argMap) {
        this.argMap = argMap;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", protocol='" + protocol + '\'' +
                ", port=" + port +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", argMap=" + argMap +
                ", body='" + body + '\'' +
                ", headerMap=" + headerMap +
                '}';
    }
}
