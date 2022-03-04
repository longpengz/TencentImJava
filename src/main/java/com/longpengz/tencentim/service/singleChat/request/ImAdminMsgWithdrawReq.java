package com.longpengz.tencentim.service.singleChat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM撤回单聊消息请求参数")
public class ImAdminMsgWithdrawReq {

    @ApiModelProperty(value = "（必填）消息发送方UserID")
    private String From_Account;

    @ApiModelProperty(value = "（必填）消息接收方 UserID")
    private String To_Account;

    @ApiModelProperty(value = "（必填）待撤回消息的唯一标识。该字段由 REST API 接口 单发单聊消息 和 批量发单聊消息 返回")
    private String MsgKey;

}
