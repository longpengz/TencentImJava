package com.longpengz.tencentim.bean.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "自定义消息")
public class CustomMsgContent extends MsgContent{

    @ApiModelProperty(value = "自定义消息数据。 不作为 APNs 的 payload 字段下发，故从 payload 中无法获取 Data 字段。")
    private String Data;

    @ApiModelProperty(value = "自定义消息描述信息")
    private String Desc;

    @ApiModelProperty(value = "扩展字段")
    private String Ext;

    @ApiModelProperty(value = "自定义 APNs 推送铃音")
    private String Sound;
}
