package com.longpengz.tencentim.service.singleChat.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "设置单聊消息已读请求参数")
public class ImAdminSetMsgReadReq {

    @ApiModelProperty(value = "（必填）进行消息已读的用户 UserId")
    private String Report_Account;

    @ApiModelProperty(value = "（必填）进行消息已读的单聊会话的另一方用户 UserId")
    private String Peer_Account;

}
