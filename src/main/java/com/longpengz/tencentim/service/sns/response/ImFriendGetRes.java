package com.longpengz.tencentim.service.sns.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.sns.modle.ImUserDataItem;
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
@ApiModel(description = "IM拉取好友返回参数")
public class ImFriendGetRes extends ImResponse {

    @ApiModelProperty(value = "好友对象数组")
    private List<ImUserDataItem> UserDataItem;

    @ApiModelProperty(value = "标配好友数据的 Sequence，客户端可以保存该 Sequence，下次请求时通过请求的 StandardSequence 字段返回给后台")
    private Integer StandardSequence;

    @ApiModelProperty(value = "自定义好友数据的 Sequence，客户端可以保存该 Sequence，下次请求时通过请求的 CustomSequence 字段返回给后台")
    private Integer CustomSequence;

    @ApiModelProperty(value = "好友总数")
    private Integer FriendNum;

    @ApiModelProperty(value = "分页的结束标识，非0值表示已完成全量拉取")
    private Integer CompleteFlag;

    @ApiModelProperty(value = "分页接口下一页的起始位置")
    private Integer NextStartIndex;
}
