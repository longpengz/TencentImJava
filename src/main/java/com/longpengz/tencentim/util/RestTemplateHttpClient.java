package com.longpengz.tencentim.util;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author longpengZ
 */
public class RestTemplateHttpClient implements HttpClient{

    private RestTemplate restTemplate;

    public RestTemplateHttpClient() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(3*1000);
        factory.setConnectTimeout(3*1000);
        restTemplate = new RestTemplate(factory);
    }

    @Override
    public String doPost(String url, String body) {
        return restTemplate.postForEntity(url,body, String.class).getBody();

    }
}
