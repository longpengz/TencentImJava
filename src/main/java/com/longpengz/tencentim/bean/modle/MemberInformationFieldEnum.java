package com.longpengz.tencentim.bean.modle;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "群成员资料字段信息")
public enum MemberInformationFieldEnum {
    /**
     * 群成员 ID
     */
    Member_Account,
    /**
     * 群内身份 包括 Owner 群主、Admin 群管理员以及 Member 群成员
     */
    Role,
    /**
     * 入群时间
     */
    JoinTime,
    /**
     * 该成员当前已读消息 Seq
     */
    MsgSeq,
    /**
     * 消息接收选项
     */
    MsgFlag,
    /**
     * 最后发送消息的时间
     */
    LastSendMsgTime,
    /**
     * 最后发送消息的时间
     */
    NameCard


}
