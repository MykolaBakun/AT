package practice.api;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class Response {

    private String body;

    private Integer statusCode;
    private String statusMessage;
    private Map<String, List<String>> headerMap;

    private Long time;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Map<String, List<String>> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, List<String>> headerMap) {
        this.headerMap = headerMap;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Response{" +
                "body='" + body + '\'' +
                ", statusCode=" + statusCode +
                ", statusMessage='" + statusMessage + '\'' +
                ", headerMap=" + headerMap +
                ", time=" + time +
                '}';
    }

    public JSONObject getBodyAsJson() {
        JSONObject res=new JSONObject(body);

        return res;
    }
}
