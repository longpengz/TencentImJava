package com.longpengz.tencentim.service.recentContacts.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取会话列表请求参数")
public class ImRecentContactsGetListReq {

    @ApiModelProperty(value = "（必填）填 UserID，请求拉取该用户的会话列表")
    private String From_Account;

    @ApiModelProperty(value = "（必填）普通会话的起始时间，第一页填 0")
    private Integer TimeStamp;

    @ApiModelProperty(value = "（必填）普通会话的起始位置，第一页填 0")
    private Integer StartIndex;

    @ApiModelProperty(value = "（必填）置顶会话的起始时间，第一页填 0")
    private Integer TopTimeStamp;

    @ApiModelProperty(value = "（必填）置顶会话的起始位置，第一页填 0")
    private Integer TopStartIndex;

    @ApiModelProperty(value = "（必填）会话辅助标志位:bit 0 - 是否支持置顶会话 bit 1 - 是否返回空会话 bit 2 - 是否支持置顶会话分页")
    private Integer AssistFlags;
}
