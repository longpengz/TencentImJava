package com.longpengz.tencentim.service.groupOpenHttpSvc.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取群历史消息请求参数")
public class ImGroupMsgGetSimpleReq {

    @ApiModelProperty(value = "（必填）要拉取历史消息的群组 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）拉取的历史消息的条数，目前一次请求最多返回20条历史消息，所以这里最好小于等于20")
    private Integer ReqMsgNumber;

    @ApiModelProperty(value = "（选填）拉取消息的最大 seq")
    private Integer ReqMsgSeq;

    @ApiModelProperty(value = "（选填）是否带撤回的消息，填1表明需要拉取撤回后的消息；默认不拉取撤回后的消息")
    private Integer WithRecalledMsg;
}
