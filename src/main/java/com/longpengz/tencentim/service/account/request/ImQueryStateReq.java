package com.longpengz.tencentim.service.account.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询帐号在线状态请求参数")
public class ImQueryStateReq {

    @ApiModelProperty(value = "需要查询这些 UserID 的登录状态，一次最多查询500个 UserID 的状态")
    private List<String> To_Account;
    
    @ApiModelProperty(value = "是否需要返回详细的登录平台信息。0表示不需要，1表示需要")
    private Integer IsNeedDetail;

}
