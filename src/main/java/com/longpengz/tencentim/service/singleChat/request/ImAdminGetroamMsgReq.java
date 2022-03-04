package com.longpengz.tencentim.service.singleChat.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "查询单聊消息请求参数")
public class ImAdminGetroamMsgReq {

    @ApiModelProperty(value = "（必填）会话其中一方的 UserID，若已指定发送消息方帐号，则为消息发送方")
    private String From_Account;

    @ApiModelProperty(value = "（必填）会话其中一方的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "（必填）请求的消息条数")
    private Integer MaxCnt;

    @ApiModelProperty(value = "（必填）请求的消息时间范围的最小值")
    private Integer MinTime;

    @ApiModelProperty(value = "（必填）请求的消息时间范围的最大值")
    private Integer MaxTime;

    @ApiModelProperty(value = "（必填）上一次拉取到的最后一条消息的 MsgKey，续拉时需要填该字段")
    private String LastMsgKey;

}
