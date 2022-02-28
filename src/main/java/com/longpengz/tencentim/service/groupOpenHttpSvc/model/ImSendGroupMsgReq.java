package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.enums.ForbidCallbackControlEnum;
import com.longpengz.tencentim.bean.enums.MsgPriorityEnum;
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
@ApiModel(description = "IM在群组中发送普通消息请求参数")
public class ImSendGroupMsgReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）无符号32位整数。如果5分钟内两条消息的随机值相同，后一条消息将被当做重复消息而丢弃")
    private Integer Random;

    @ApiModelProperty(value = "（选填）消息的优先级")
    private MsgPriorityEnum MsgPriority;

    @ApiModelProperty(value = "（必填）消息内容")
    private List<MsgBodyItem> MsgBody;

    @ApiModelProperty(value = "（选填）消息来源帐号，选填。如果不填写该字段，则默认消息的发送者为调用该接口时使用的 App 管理员帐号。" +
            "除此之外，App 亦可通过该字段“伪造”消息的发送者，从而实现一些特殊的功能需求。需要注意的是，如果指定该字段，必须要确保字段中的帐号是存在的")
    private String From_Account;

    //TODO 离线推送信息未支持 参数OfflinePushInfo

    @ApiModelProperty(value = "（选填）消息回调禁止开关，只对单条消息有效")
    private List<ForbidCallbackControlEnum> ForbidCallbackControl;

    @ApiModelProperty(value = "（选填）1表示消息仅发送在线成员，默认0表示发送所有成员，AVChatRoom(直播群)不支持该参数")
    private Integer OnlineOnlyFlag;

    @ApiModelProperty(value = "（选填）消息发送控制选项，是一个 String 数组，只对本次请求有效。" +
            "NoUnread表示该条消息不计入未读数。示例：SendMsgControl: [NoUnread]")
    private List<String> SendMsgControl;

    @ApiModelProperty(value = "（选填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）")
    private String CloudCustomData;
}
