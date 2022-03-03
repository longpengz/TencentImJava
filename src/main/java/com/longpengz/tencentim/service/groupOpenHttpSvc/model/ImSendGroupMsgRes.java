package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM在群组中发送普通消息返回参数")
public class ImSendGroupMsgRes extends ImResponse {

    @ApiModelProperty(value = "消息发送的时间戳，对应后台 server 时间")
    private Integer MsgTime;

    @ApiModelProperty(value = "消息序列号，唯一标示一条消息")
    private Integer MsgSeq;
}
