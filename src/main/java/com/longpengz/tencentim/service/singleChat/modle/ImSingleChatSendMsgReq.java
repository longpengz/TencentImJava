package com.longpengz.tencentim.service.singleChat.modle;

import com.longpengz.tencentim.bean.modle.MsgBodyItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM单发单聊消息请求参数")
public class ImSingleChatSendMsgReq {

    @ApiModelProperty(value = "1：把消息同步到 From_Account 在线终端和漫游上；2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游")
    private Integer SyncOtherMachine;

    @ApiModelProperty(value = "消息发送方 UserID（用于指定发送消息方帐号）")
    private String From_Account;

    @ApiModelProperty(value = "消息接收方 UserID")
    private String To_Account;

    @ApiModelProperty(value = "消息离线保存时长（单位：秒），最长为7天（604800秒）。若设置该字段为0，则消息只发在线用户，不保存离线；若设置该字段超过7天（604800秒），仍只保存7天；若不设置该字段，则默认保存7天")
    private Integer MsgLifeTime;
    
    @ApiModelProperty(value = "消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数")
    private Integer MsgRandom;

    @ApiModelProperty(value = "消息时间戳，UNIX 时间戳（单位：秒）")
    private Integer MsgTimeStamp;

    @ApiModelProperty(value = "消息内容")
    private MsgBodyItem MsgBodyItem;


}
