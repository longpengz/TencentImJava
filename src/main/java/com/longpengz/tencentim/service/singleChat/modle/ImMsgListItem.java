package com.longpengz.tencentim.service.singleChat.modle;
import com.longpengz.tencentim.bean.modle.MsgContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询返回的消息")
public class ImMsgListItem {

    @ApiModelProperty(value = "该条消息的属性，0表示正常消息，8表示被撤回的消息")
    private Integer MsgFlagBits;

    @ApiModelProperty(value = "消息内容")
    private MsgContent MsgBody;

    @ApiModelProperty(value = "消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）")
    private String CloudCustomData;

    @ApiModelProperty(value = "标识该条消息，可用于 REST API 撤回单聊消息")
    private String MsgKey;
}
