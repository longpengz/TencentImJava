package com.longpengz.tencentim.service.account.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号在线状态（返回参数） 状态查询失败的帐号，状态查询失败或目标帐号不存在。")
public class ImQueryStateErrorItem {

    @ApiModelProperty(value = "状态查询失败的目标帐号")
    private String To_Account;

    @ApiModelProperty(value = "状态查询失败的错误码，若目标帐号的错误码为70107，表示该帐号不存在")
    private Integer ErrorCode;
}
