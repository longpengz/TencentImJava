package com.longpengz.tencentim.service.profile.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "返回的用户资料结构化信息")
public class UserProfileItem {

    @ApiModelProperty(value = "返回的用户的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "返回的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value")
    private List<ProfileItem> ProfileItem;

    @ApiModelProperty(value = "To_Account 的处理结果，0表示成功，非0表示失败")
    private Integer ResultCode;

    @ApiModelProperty(value = "To_Account 的错误描述信息，成功时该字段为空")
    private String ResultInfo;
}
