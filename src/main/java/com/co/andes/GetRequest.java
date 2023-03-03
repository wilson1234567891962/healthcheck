package com.co.andes;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {

    CloseableHttpClient httpClient;

    public String doRequest() throws IOException {
        httpClient = HttpClients.createDefault();
        StringBuilder dto = new StringBuilder();
        HttpGet request = new HttpGet("http://localhost:9022/ANDES/message");

        // add request headers
        request.addHeader(HttpHeaders.USER_AGENT, "UTF-8");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                dto.append(result);
            }
        } catch (Exception e) {
            return null;
        }
        return dto.toString();
    }

    public void closeClient() throws IOException {
        this.httpClient.close();
    }
}
