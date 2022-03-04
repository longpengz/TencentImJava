package com.longpengz.tencentim.service.groupOpenHttpSvc.enums;

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
@ApiModel(description = "IM查询返回的消息")
public class ImImportGroupMsgListItem {

    @ApiModelProperty(value = "（必填）指定消息发送者")
    private String From_Account;

    @ApiModelProperty(value = "（必填）消息发送时间")
    private Integer SendTime;

    @ApiModelProperty(value = "（选填）32位随机数；如果5分钟内两条消息的随机值相同，后一条消息将被当做重复消息而丢弃")
    private Integer Random;

    @ApiModelProperty(value = "（必填）消息内容")
    private List<MsgBodyItem> MsgBody;


}
