package com.longpengz.tencentim.bean.response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "1.IM查询账号在线状态（返回参数） 状态查询失败的帐号，状态查询失败或目标帐号不存在。" +
        "2.发消息失败的帐号，在此列表中的目标帐号，消息发送失败或帐号不存在。若消息全部发送成功，则 ErrorList 为空")
public class ImErrorListItem {

    @ApiModelProperty(value = "失败的目标帐号")
    private String To_Account;

    @ApiModelProperty(value = "失败的错误码，若目标帐号的错误码为70107，表示该帐号不存在")
    private Integer ErrorCode;
}
