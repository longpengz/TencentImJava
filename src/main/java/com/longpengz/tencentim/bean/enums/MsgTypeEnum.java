package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "消息元素类别")
public enum MsgTypeEnum {
    // 文本消息
    TIMTextElem,
    // 地理位置消息
    TIMLocationElem,
    // 表情消息
    TIMFaceElem,
    // 自定义消息
    TIMCustomElem,
    // 语音消息
    TIMSoundElem,
    // 图像消息
    TIMImageElem

}
