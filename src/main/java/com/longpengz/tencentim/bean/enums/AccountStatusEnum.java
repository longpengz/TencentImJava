package com.longpengz.tencentim.bean.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "单个帐号的导入状态")
public enum AccountStatusEnum {
    // 表示已导入
    Imported,
    // 表示未导入
    NotImported
}
