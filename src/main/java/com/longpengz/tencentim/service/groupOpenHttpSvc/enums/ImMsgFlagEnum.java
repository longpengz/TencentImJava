package com.longpengz.tencentim.service.groupOpenHttpSvc.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "IM消息接收选项")
public enum ImMsgFlagEnum {
    /**
     * 表示接收并提示
     */
    AcceptAndNotify,
    /**
     * 表示接收不提示（不会触发 APNs 远程推送）
     */
    AcceptNotNotify,
    /**
     * 表示屏蔽群消息（不会向客户端推送消息）
     */
    Discard
}
