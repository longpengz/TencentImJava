package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM添加好友请求参数")
public class ImFriendAddReq {

    @ApiModelProperty(value = "（必填）需要为该 UserID 添加好友")
    private String From_Account;

    @ApiModelProperty(value = "（必填）好友结构体对象")
    private List<ImAddFriendItem<String>> AddFriendItem;

    @ApiModelProperty(value = "（选填）加好友方式")
    private AddTypeEnum AddType;

    @ApiModelProperty(value = "（选填）管理员强制加好友标记 1表示强制加好友，0表示常规加好友方式")
    private Integer ForceAddFlags;
    
}
