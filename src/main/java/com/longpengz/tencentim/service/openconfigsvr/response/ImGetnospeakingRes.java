package com.longpengz.tencentim.service.openconfigsvr.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询全局禁言返回参数")
public class ImGetnospeakingRes extends ImResponse {

    @ApiModelProperty(value = "单聊消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）" +
            "0表示取消该帐号的单聊消息禁言" +
            "4294967295表示该帐号被设置永久禁言其它值表示该帐号具体的禁言时间")
    private Integer C2CmsgNospeakingTime;

    @ApiModelProperty(value = "群组消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）" +
            "0表示取消该帐号的群组消息禁言" +
            "4294967295表示该帐号被设置永久禁言" +
            "其它值表示该帐号的具体禁言时间")
    private Integer GroupmsgNospeakingTime;
}
