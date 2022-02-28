package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM具体的消息导入结果")
public class ImImportMsgResultItem {

    @ApiModelProperty(value = "单条消息导入结果\n" +
            "0表示单条消息成功\n" +
            "10004表示单条消息发送时间无效\n" +
            "80001表示单条消息包含脏字，拒绝存储此消息\n" +
            "80002表示为消息内容过长，目前支持8000字节的消息，请调整消息长度")
    private Integer Result;

    @ApiModelProperty(value = "消息的时间戳")
    private Integer MsgTime;

    @ApiModelProperty(value = "消息序列号，唯一标示一条消息")
    private Integer MsgSeq;


}
