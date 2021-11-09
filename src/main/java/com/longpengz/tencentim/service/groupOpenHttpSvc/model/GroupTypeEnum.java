package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "IM群组形态")
public enum GroupTypeEnum {
    /**
     * 公开群
     */
    Public,
    /**
     * 私密群
     */
    Private,
    /**
     * 聊天室
     */
    ChatRoom,
    /**
     * 音视频聊天室
     */
    AVChatRoom,
    /**
     * 在线成员广播大群
     */
    BChatRoom
}
