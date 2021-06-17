package com.longpengz.tencentim.service.sns.modle;
import com.longpengz.tencentim.service.profile.modle.ProfileItemTagEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取指定好友请求参数")
public class ImFriendGetListReq {
    
    @ApiModelProperty(value = "（必填）指定要拉取好友数据的用户的 UserID")
    private String From_Account;
    
    @ApiModelProperty(value = "（必填）好友的 UserID 列表建议每次请求的好友数不超过100，避免因数据量太大导致回包失败")
    private List<String> To_Account;

    @ApiModelProperty(value = "（必填）指定要拉取的资料字段及好友字段")
    private List<ProfileItemTagEnum> TagList;
}
