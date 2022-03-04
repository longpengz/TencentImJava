package com.longpengz.tencentim.service.groupOpenHttpSvc.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "IM群组成员角色")
public enum ImGroupMemberRoleEnum {
    /**
     * 群主
     */
    Owner,
    /**
     * 群管理员
     */
    Admin,
    /**
     * 群成员
     */
    Member
}
