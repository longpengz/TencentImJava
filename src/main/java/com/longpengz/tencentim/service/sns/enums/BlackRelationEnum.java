package com.longpengz.tencentim.service.sns.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "校验黑名单结果")
public enum BlackRelationEnum {
    /**
     * 单向校验 From_Account 的黑名单中有 To_Account，但无法确定 To_Account 的黑名单中是否有 From_Account
     * 双向校验 From_Account 的黑名单中有 To_Account，To_Account 的黑名单中也有 From_Account
     */
    BlackCheckResult_Type_AWithB,
    /**
     * 单向校验 From_Account 的黑名单中没有 To_Account，但无法确定 To_Account 的黑名单中是否有 From_Account
     * 双向校验 From_Account 的黑名单中没有 To_Account，To_Account 的黑名单中也没有 From_Account
     */
    BlackCheckResult_Type_NO,
    /**
     * 双向校验 From_Account 的黑名单中有 To_Account，To_Account 的黑名单中也有 From_Account
     */
    BlackCheckResult_Type_BothWay,
    /**
     * 双向校验 From_Account 的黑名单中没有 To_Account，但 To_Account 的黑名单中有 From_Account
     */
    BlackCheckResult_Type_BWithA
}
