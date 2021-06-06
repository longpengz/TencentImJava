package com.longpengz.tencentim.service.singleChat.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "单聊会话查询信息")
public class ImC2CUnreadMsgNumListItem {

    @ApiModelProperty(value = "单聊会话对端 UserId")
    private String Peer_Account;

    @ApiModelProperty(value = "该单聊会话的未读数")
    private Integer C2CUnreadMsgNum;

}
