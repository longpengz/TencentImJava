package com.longpengz.tencentim.service.account.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM失效帐号登录态请求参数")
public class ImKickRequest {

    @ApiModelProperty(value = "用户名")
    private String Identifier;

}
