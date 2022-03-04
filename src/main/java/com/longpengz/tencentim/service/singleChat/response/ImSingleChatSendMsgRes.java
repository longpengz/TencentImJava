package com.longpengz.tencentim.service.singleChat.response;
import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM单发单聊消息返回参数")
public class ImSingleChatSendMsgRes extends ImResponse {

    @ApiModelProperty(value = "消息时间戳，UNIX 时间戳")
    private Integer MsgTime;

    @ApiModelProperty(value = "消息唯一标识，用于撤回。长度不超过50个字符")
    private String MsgKey;
}
