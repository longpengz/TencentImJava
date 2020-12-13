package com.longpengz.tencentim.util;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public RestTemplateUtil() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(3*1000);
        factory.setConnectTimeout(3*1000);
        restTemplate = new RestTemplate(factory);
    }

    public String doPost(String url,String body){
        return restTemplate.postForEntity(url,body, String.class).getBody();
    }
}
