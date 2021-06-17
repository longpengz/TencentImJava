package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除所有好友请求参数")
public class ImFriendDeleteAllReq {

    @ApiModelProperty(value = "（必填）指定要清除好友数据的用户的 UserID")
    private String From_Account;

    @ApiModelProperty(value = "（选填）删除模式")
    private DeleteFriendTypeEnum DeleteType;
}
