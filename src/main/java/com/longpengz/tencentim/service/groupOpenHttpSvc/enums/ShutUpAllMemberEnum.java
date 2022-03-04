package com.longpengz.tencentim.service.groupOpenHttpSvc.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "群内群成员是否开启禁言")
public enum ShutUpAllMemberEnum {
    /**
     * 开启
     */
    On,
    /**
     * 关闭
     */
    Off
}
