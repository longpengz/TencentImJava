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
@ApiModel(description = "IM在群组中发送系统通知请求参数")
public class ImSendGroupSystemNotificationReq {

    @ApiModelProperty(value = "（必填）向哪个群组发送系统通知")
    private String GroupId;

    @ApiModelProperty(value = "（选填）接收者群成员列表，请填写接收者 UserID，不填或为空表示全员下发")
    private List<String> ToMembers_Account;

    @ApiModelProperty(value = "（必填）系统通知的内容")
    private String Content;
}
