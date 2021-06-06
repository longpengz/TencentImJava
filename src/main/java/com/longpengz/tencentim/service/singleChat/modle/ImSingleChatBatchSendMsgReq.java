package com.longpengz.tencentim.service.singleChat.modle;

import com.longpengz.tencentim.bean.modle.MsgBodyItem;
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
@ApiModel(description = "IM批量发单聊消息请求参数")
public class ImSingleChatBatchSendMsgReq {

    @ApiModelProperty(value = "（选填）1：把消息同步到 From_Account 在线终端和漫游上" +
            "2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游")
    private Integer SyncOtherMachine;

    @ApiModelProperty(value = "（选填）管理员指定消息发送方帐号（若需设置 From_Account 信息，则该参数取值不能为空）")
    private String From_Account;
    
    @ApiModelProperty(value = "（必填）消息接收方用户 UserID")
    private List<Integer> To_Account;

    @ApiModelProperty(value = "（必填）消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数")
    private Integer MsgRandom;
    
    @ApiModelProperty(value = "（必填）TIM 消息")
    private MsgBodyItem msgBodyItem;

    @ApiModelProperty(value = "（必填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）")
    private String CloudCustomData;

    @ApiModelProperty(value = "（选填）消息发送控制选项，是一个 String 数组，只对本次请求有效。" +
            "NoUnread表示该条消息不计入未读数。示例：SendMsgControl: [NoUnread]")
    private List<String> SendMsgControl;

    //TODO 离线推送信息未支持 参数OfflinePushInfo

}
