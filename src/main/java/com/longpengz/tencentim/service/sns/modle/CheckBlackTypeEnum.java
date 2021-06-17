package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "黑名单校验模式")
public enum CheckBlackTypeEnum {
    /**
     * 单向校验黑名单关系
     * 只会检查 From_Account 的黑名单中是否有 To_Account，不会检查 To_Account 的黑名单中是否有 From_Account
     */
    BlackCheckResult_Type_Single,
    /**
     * 双向校验黑名单关系
     * 既会检查 From_Account 的黑名单中是否有 To_Account，也会检查 To_Account 的黑名单中是否有 From_Account
     */
    BlackCheckResult_Type_Both
}
