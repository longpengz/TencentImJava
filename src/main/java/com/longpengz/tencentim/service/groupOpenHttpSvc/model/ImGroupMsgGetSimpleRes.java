package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
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
@ApiModel(description = "IM拉取群历史消息返回参数")
public class ImGroupMsgGetSimpleRes extends ImResponse {

    @ApiModelProperty(value = "请求中的群组 ID")
    private String GroupId;

    @ApiModelProperty(value = "是否返回了请求区间的全部消息" +
            "当成功返回了请求区间的全部消息时，值为1" +
            "当消息长度太长或者区间太大（超过20）导致无法返回全部消息时，值为0" +
            "当消息长度太长或者区间太大（超过20）且所有消息都过期时，值为2")
    private Integer IsFinished;

    @ApiModelProperty(value = "返回的消息列表")
    private List<ImGroupMsgGetSimpleRspMsgListItem> RspMsgList;

}