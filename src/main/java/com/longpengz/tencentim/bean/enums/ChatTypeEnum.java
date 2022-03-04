package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "消息类型")
public enum ChatTypeEnum {
    /**
     * 单发消息
     */
    C2C,
    /**
     * 群组消息
     */
    Group
}
