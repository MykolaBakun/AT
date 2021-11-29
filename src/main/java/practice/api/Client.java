package practice.api;

import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Map;

public class Client {
    private final Logger LOGGER = Logger.getLogger(this.getClass());
    private Map<String,String> cookies;

    public Response send(Request request){
        LOGGER.info("send "+request);
        Response res =new Response();

        HttpRequest httpRequest;
        try {

            httpRequest = HttpRequest.newBuilder()
                    .uri(request.getURI())
                    .method(request.getMethod(), HttpRequest.BodyPublishers.noBody())
                    .build();

            long start=new Date().getTime();
            HttpResponse<String> response = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());


            res.setStatusCode(response.statusCode());
            res.setBody(response.body());
            res.setHeaderMap(response.headers().map());
            res.setTime(new Date().getTime()-start);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("res "+res.getStatusCode() + " time "+res.getTime()+" ms");
        return res;
    }
}
