package com.longpengz.tencentim.service.singleChat.request;
import com.longpengz.tencentim.bean.modle.MsgBodyItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM导入单聊消息请求参数")
public class ImImportMsgReq {

    @ApiModelProperty(value = "（必填）该字段只能填1或2，其他值是非法值 1表示实时消息导入，消息加入未读计数 2表示历史消息导入，消息不计入未读")
    private Integer SyncFromOldSystem;

    @ApiModelProperty(value = "（必填）消息发送方 UserID，用于指定发送消息方")
    private String From_Account;

    @ApiModelProperty(value = "（必填）消息接收方 UserID")
    private String To_Account;

    @ApiModelProperty(value = "（必填）消息随机数，由随机函数产生，后台会根据该字段去重，详细规则请看本接口的功能说明。")
    private Integer MsgRandom;

    @ApiModelProperty(value = "（必填）消息时间戳，UNIX 时间戳，单位为秒。后台会根据该字段去重，详细规则请看本接口的功能说明。")
    private Integer MsgTimeStamp;

    @ApiModelProperty(value = "（必填）消息内容")
    private List<MsgBodyItem> MsgBody;

    @ApiModelProperty(value = "（选填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）")
    private String CloudCustomData;
}
