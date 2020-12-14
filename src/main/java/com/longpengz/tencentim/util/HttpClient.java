package com.longpengz.tencentim.util;

/**
 * @author longpengZ
 * Http客户端请求接口
 */
public interface HttpClient {
    String doPost(String url,String body);
}
