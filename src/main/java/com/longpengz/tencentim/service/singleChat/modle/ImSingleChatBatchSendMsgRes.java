package com.longpengz.tencentim.service.singleChat.modle;
import com.longpengz.tencentim.bean.response.ImErrorListItem;
import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM批量发单聊消息返回参数")
public class ImSingleChatBatchSendMsgRes extends ImResponse {
    
    @ApiModelProperty(value = "消息唯一标识，用于撤回。长度不超过50个字符")
    private String MsgKey;

    @ApiModelProperty(value = "发消息失败的帐号列表，在此列表中的目标帐号，消息发送失败或帐号不存在。若消息全部发送成功，则 ErrorList 为空")
    private List<ImErrorListItem> ErrorList;
}
