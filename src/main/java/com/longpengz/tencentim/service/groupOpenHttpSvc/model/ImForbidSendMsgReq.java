package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

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
@ApiModel(description = "IM批量禁言和取消禁言请求参数")
public class ImForbidSendMsgReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）需要禁言的用户帐号，最多支持500个帐号")
    private List<String> User_Account;

    @ApiModelProperty(value = "（必填）需禁言时间，单位为秒，为0时表示取消禁言，4294967295为永久禁言。")
    private Integer ShutUpTime;
}
