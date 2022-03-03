package com.longpengz.tencentim.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class Captcha {

    /**
     * 长度1-32
     * @param length 长度
     */
    public static String getUUIDNumber(int length){
        return new StringTokenizer(UUID.randomUUID().toString().replaceAll("-", ""), "-").nextToken().substring(0,length-1);
    }

}
