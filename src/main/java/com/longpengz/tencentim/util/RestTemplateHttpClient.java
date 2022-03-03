package com.longpengz.tencentim.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author longpengZ
 */
public class RestTemplateHttpClient implements HttpClient{

    private final RestTemplate restTemplate;

    public RestTemplateHttpClient() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(3*1000);
        factory.setConnectTimeout(3*1000);
        restTemplate = new RestTemplate(factory);
    }

    @Override
    public String doPost(String url, String body) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url,httpEntity, String.class).getBody();
    }
}
