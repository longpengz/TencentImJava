package com.longpengz.tencentim.service;

import com.longpengz.tencentim.config.ImConfig;

public class ImBaseService {

    protected ImConfig imConfig = null;

    public void init(ImConfig imConfig){
        this.imConfig = imConfig;
    }

}