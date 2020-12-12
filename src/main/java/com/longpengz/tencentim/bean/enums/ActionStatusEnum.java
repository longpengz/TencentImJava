package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "请求处理的结果，OK 表示处理成功，FAIL 表示失败")
public enum ActionStatusEnum {
    OK,
    FAIL
}
