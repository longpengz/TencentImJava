package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "消息元素类别")
public enum MsgPriorityEnum {
    /**
     * 高
     */
    High,
    /**
     * 普通
     */
    Normal,
    /**
     * 低
     */
    Low
}
