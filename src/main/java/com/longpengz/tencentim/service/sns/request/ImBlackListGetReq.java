package com.longpengz.tencentim.service.sns.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取黑名单请求参数")
public class ImBlackListGetReq {

    @ApiModelProperty(value = "（必填）需要拉取该 UserID 的黑名单")
    private String From_Account;

    @ApiModelProperty(value = "（必填）拉取的起始位置")
    private Integer StartIndex;

    @ApiModelProperty(value = "（必填）每页最多拉取的黑名单数")
    private Integer MaxLimited;

    @ApiModelProperty(value = "（必填）上一次拉黑名单时后台返回给客户端的 Seq，初次拉取时为0")
    private Integer LastSequence;

}
