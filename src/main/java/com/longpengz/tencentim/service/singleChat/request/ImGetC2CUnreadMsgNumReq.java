package com.longpengz.tencentim.service.singleChat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询单聊未读消息计数请求参数")
public class ImGetC2CUnreadMsgNumReq {

    @ApiModelProperty(value = "（必填）待查询的用户 UserId")
    private String To_Account;

    @ApiModelProperty(value = "（选填）待查询的单聊会话对端的用户 UserId 1.若要查询单个会话的未读数，该字段必填 2.该数组最大大小为10")
    private List<String> Peer_Account;

}
