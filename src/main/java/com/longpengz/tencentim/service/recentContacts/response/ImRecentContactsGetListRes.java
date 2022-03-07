package com.longpengz.tencentim.service.recentContacts.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.recentContacts.modle.SessionObj;
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
@ApiModel(description = "IM拉取会话列表返回参数")
public class ImRecentContactsGetListRes extends ImResponse {

    @ApiModelProperty(value = "会话对象数组")
    private List<SessionObj> SessionItem;

    @ApiModelProperty(value = "结束标识：1 表示已返回全量会话，0 表示还有会话没拉完")
    private Integer CompleteFlag;

    @ApiModelProperty(value = "普通会话下一页拉取的起始时间，分页拉取时通过请求包的 TimeStamp 字段带给移动通信后台")
    private Integer TimeStamp;

    @ApiModelProperty(value = "普通会话下一页拉取的起始位置，分页拉取时通过请求包的 StartIndex 字段带给移动通信后台")
    private Integer StartIndex;

    @ApiModelProperty(value = "置顶会话下一页拉取的起始时间，分页拉取时通过请求包的 TopTimeStamp 字段带给移动通信后台")
    private Integer TopTimeStamp;

    @ApiModelProperty(value = "置顶会话下一页拉取的起始位置，分页拉取时通过请求包的 TopStartIndex 字段带给移动通信后台")
    private Integer TopStartIndex;



}
