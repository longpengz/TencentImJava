package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "申请加群处理方式")
public enum ApplyJoinOptionEnum {
    /**
     * 自由加入
     */
    FreeAccess,
    /**
     * 需要验证 不填默认
     */
    NeedPermission,
    /**
     * 禁止加群
     */
    DisableApply

}
