package com.longpengz.tencentim.service.sns.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "IM好友删除模式")
public enum DeleteFriendTypeEnum {
    /**
     * 单向删除好友
     * 只将 To_Account 从 From_Account 的好友表中删除，但不会将 From_Account 从 To_Account 的好友表中删除
     */
    Delete_Type_Single,
    /**
     * 双向删除好友
     * 将 To_Account 从 From_Account 的好友表中删除，同时将 From_Account 从 To_Account 的好友表中删除
     */
    Delete_Type_Both
}
