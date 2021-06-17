package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取好友请求参数")
public class ImFriendGetReq {
    
    @ApiModelProperty(value = "（必填）指定要拉取好友数据的用户的 UserID")
    private String From_Account;
    
    @ApiModelProperty(value = "（必填）分页的起始位置")
    private Integer StartIndex;

    @ApiModelProperty(value = "（选填）上次拉好友数据时返回的 StandardSequence，如果 StandardSequence 字段的值与后台一致，后台不会返回标配好友数据")
    private Integer StandardSequence;
    
    @ApiModelProperty(value = "（选填）上次拉好友数据时返回的 CustomSequence，如果 CustomSequence 字段的值与后台一致，后台不会返回自定义好友数据")
    private Integer CustomSequence;

    
}
