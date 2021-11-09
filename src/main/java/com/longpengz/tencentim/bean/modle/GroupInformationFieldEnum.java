package com.longpengz.tencentim.bean.modle;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "群组信息字段")
public enum GroupInformationFieldEnum {
    /**
     * 群组的唯一标识
     */
    GroupId,
    /**
     * 群组类型
     */
    Type,
    /**
     * 群组名称
     */
    Name,
    /**
     * 群组简介
     */
    Introduction,
    /**
     * 群组公告
     */
    Notification,
    /**
     * 群组头像 URL
     */
    FaceUrl,
    /**
     * 群主 ID
     */
    Owner_Account,
    /**
     * 群组的创建时间
     */
    CreateTime,
    /**
     * 群资料的每次变都会增加该值
     */
    InfoSeq,
    /**
     * 群组最后一次信息变更时间
     */
    LastInfoTime,
    /**
     * 群组内最后发消息的时间
     */
    LastMsgTime,
    /**
     * 群内下一条消息的 Seq
     */
    NextMsgSeq,
    /**
     * 当前成员数量
     */
    MemberNum,
    /**
     * 最大成员数量
     */
    MaxMemberNum,
    /**
     * 申请加群选项
     */
    ApplyJoinOption

}
