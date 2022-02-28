package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM禁言用户信息")
public class ImShuttedUinItem {

    @ApiModelProperty(value = "群成员 ID")
    private String Member_Account;

    @ApiModelProperty(value = "禁言到的时间（使用 UTC 时间，即世界协调时间）")
    private Integer ShuttedUntil;
}
