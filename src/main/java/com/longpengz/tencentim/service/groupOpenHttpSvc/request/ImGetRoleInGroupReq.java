package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询用户在群组中的身份请求参数")
public class ImGetRoleInGroupReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）表示需要查询的用户帐号，最多支持500个帐号")
    private List<String> User_Account;
}
