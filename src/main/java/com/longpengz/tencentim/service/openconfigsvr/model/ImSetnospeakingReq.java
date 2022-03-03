package com.longpengz.tencentim.service.openconfigsvr.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM设置全局禁言请求参数")
public class ImSetnospeakingReq {
    
    @ApiModelProperty(value = "（必填）设置禁言配置的帐号")
    private String Set_Account;
    
    @ApiModelProperty(value = "（选填）单聊消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）" +
            "0表示取消该帐号的单聊消息禁言" +
            "4294967295表示该帐号被设置永久禁言其它值表示该帐号具体的禁言时间")
    private Integer C2CmsgNospeakingTime;

    @ApiModelProperty(value = "（选填）群组消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）" +
            "0表示取消该帐号的群组消息禁言" +
            "4294967295表示该帐号被设置永久禁言" +
            "其它值表示该帐号的具体禁言时间")
    private Integer GroupmsgNospeakingTime;
}
