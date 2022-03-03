package com.longpengz.tencentim.service;

import com.google.gson.Gson;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.util.HttpClient;
import com.longpengz.tencentim.util.RestTemplateHttpClient;

public class ImBaseService {

    protected ImConfig imConfig;

    protected HttpClient httpClient;

    protected Gson gson;

    public void init(ImConfig imConfig){
        this.imConfig = imConfig;
        gson = new Gson();
        httpClient = new RestTemplateHttpClient();
    }

}
