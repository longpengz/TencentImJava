package com.longpengz.tencentim.service.openconfigsvr.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询全局禁言请求参数")
public class ImGetnospeakingReq {

    @ApiModelProperty(value = "（必填）查询禁言信息的帐号")
    private String Get_Account;
}
