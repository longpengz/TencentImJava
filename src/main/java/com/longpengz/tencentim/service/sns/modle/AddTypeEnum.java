package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "加好友方式")
public enum AddTypeEnum {
    // 表示单向加好友
    Add_Type_Single,
    // 表示双向加好友
    Add_Type_Both
}
