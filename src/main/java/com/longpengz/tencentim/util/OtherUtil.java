package com.longpengz.tencentim.util;

import java.util.Random;

public class OtherUtil {

    public static Integer getRandom() {
        Random random = new Random();
        return random.nextInt(2147483647);
    }
}
