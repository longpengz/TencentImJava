package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "请求处理的结果")
public enum ActionStatusEnum {
    // 基础返回参数状态 表示处理成功
    OK,
    // 基础返回参数状态 表示失败
    FAIL
}
