package com.longpengz.tencentim.service.sns.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "校验成功时 To_Account 与 From_Account 之间的好友关系")
public enum FriendRelationEnum {
    /**
     * 单向校验好友关系 From_Account 的好友表中没有 To_Account，但无法确定 To_Account 的好友表中是否有 From_Account
     * 双向校验好友关系 From_Account 的好友表中没有 To_Account，To_Account 的好友表中也没有 From_Account
     */
    CheckResult_Type_NoRelation,
    /**
     * 单向校验好友关系 From_Account 的好友表中有 To_Account，但无法确定 To_Account 的好友表中是否有 From_Account
     * 双向校验好友关系 From_Account 的好友表中有 To_Account，但 To_Account 的好友表中没有 From_Account
     */
    CheckResult_Type_AWithB,
    /**
     * 双向校验好友关系 From_Account 的好友表中有 To_Account，To_Account 的好友表中也有 From_Account
     */
    CheckResult_Type_BothWay,
    /**
     * 双向校验好友关系 From_Account 的好友表中没有 To_Account，但 To_Account 的好友表中有 From_Account
     */
    CheckResult_Type_BWithA
}
