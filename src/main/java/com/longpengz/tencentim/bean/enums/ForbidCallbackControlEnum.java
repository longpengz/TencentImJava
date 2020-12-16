package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "消息回调禁止开关")
public enum ForbidCallbackControlEnum {
    // 表示禁止发消息前回调
    ForbidBeforeSendMsgCallback,
    // 表示禁止发消息后回调
    ForbidAfterSendMsgCallback
}
