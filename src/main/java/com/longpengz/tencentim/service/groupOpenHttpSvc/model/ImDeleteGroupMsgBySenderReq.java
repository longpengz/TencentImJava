package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除指定用户发送的消息请求参数")
public class ImDeleteGroupMsgBySenderReq {

    @ApiModelProperty(value = "（必填）要撤回消息的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）被撤回消息的发送者 ID")
    private String Sender_Account;
}
