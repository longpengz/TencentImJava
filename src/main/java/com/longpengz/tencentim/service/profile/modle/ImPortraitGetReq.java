package com.longpengz.tencentim.service.profile.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取资料请求参数")
public class ImPortraitGetReq {

    @ApiModelProperty(value = "需要拉取这些 UserID 的资料。注意：每次拉取的用户数不得超过100，避免因回包数据量太大以致回包失败")
    private List<String> To_Account;

    @ApiModelProperty(value = "指定要拉取的资料字段的 Tag")
    private List<ProfileItemTagEnum> TagList;

}
