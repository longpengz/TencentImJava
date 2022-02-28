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
@ApiModel(description = "IM撤回群消息请求参数")
public class ImGroupMsgRecallReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）被撤回的消息 seq 列表，一次请求最多可以撤回10条消息 seq")
    private List<String> MsgSeqList;

    @ApiModelProperty(value = "（必填）请求撤回的消息 seq")
    private Integer MsgSeq;
}
