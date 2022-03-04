package com.longpengz.tencentim.service.singleChat.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.singleChat.modle.ImC2CUnreadMsgNumListItem;
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
@ApiModel(description = "IM查询单聊未读消息计数返回参数")
public class ImGetC2CUnreadMsgNumRes extends ImResponse {

    @ApiModelProperty(value = "单聊消息总未读数")
    private Integer AllC2CUnreadMsgNum;

    @ApiModelProperty(value = "单聊会话查询信息列表")
    private List<ImC2CUnreadMsgNumListItem> C2CUnreadMsgNumList;

}
