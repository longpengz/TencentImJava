package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "IM好友校验模式")
public enum CheckFriendTypeEnum {
    /**
     * 单向校验好友关系
     * 只会检查 From_Account 的好友表中是否有 To_Account，不会检查 To_Account 的好友表中是否有 From_Account
     */
    CheckResult_Type_Single,
    /**
     * 双向校验好友关系
     * 既会检查 From_Account 的好友表中是否有 To_Account，也会检查 To_Account 的好友表中是否有 From_Account
     */
    CheckResult_Type_Both
}
