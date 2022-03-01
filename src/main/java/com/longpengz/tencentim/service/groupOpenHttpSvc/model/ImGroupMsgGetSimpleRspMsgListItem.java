package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.modle.MsgBodyItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取群历史消息返回的消息")
public class ImGroupMsgGetSimpleRspMsgListItem {
    
    @ApiModelProperty(value = "消息的发送者")
    private String From_Account;

    @ApiModelProperty(value = "是否是空洞消息，当消息被删除或者消息过期后，MsgBody 为空，该字段为1，撤回的消息，该字段为2")
    private Integer IsPlaceMsg;

    @ApiModelProperty(value = "消息的优先级，用于消息去重，有客户端发消息时填写，如果没有填，服务端会自动生成，" +
            "1表示 High 优先级消息，2表示 Normal 优先级消息，3表示 Low 优先级消息，4表示 Lowest 优先级消息")
    private Integer MsgPriority;

    @ApiModelProperty(value = "消息随机值，用于对消息去重，有客户端发消息时填写，如果没有填，服务端会自动生成")
    private Integer MsgRandom;

    @ApiModelProperty(value = "消息 seq，用于标识唯一消息，值越小发送的越早")
    private Integer MsgSeq;

    @ApiModelProperty(value = "消息被发送的时间戳，server 的时间")
    private Integer MsgTimeStamp;

    @ApiModelProperty(value = "消息内容")
    private List<MsgBodyItem> MsgBody;

    @ApiModelProperty(value = "字段为1时表示系统消息")
    private Integer IsSystemMsg;

}
