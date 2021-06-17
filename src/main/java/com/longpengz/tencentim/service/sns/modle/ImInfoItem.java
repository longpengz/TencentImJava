package com.longpengz.tencentim.service.sns.modle;
import com.longpengz.tencentim.service.profile.modle.ProfileItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "保存好友数据对象")
public class ImInfoItem {

    @ApiModelProperty(value = "返回的用户的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "返回的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value")
    private List<ProfileItem> SnsProfileItem;

    @ApiModelProperty(value = "To_Account 的处理结果，0表示成功，非0表示失败")
    private Integer ResultCode;

    @ApiModelProperty(value = "To_Account 的错误描述信息，成功时该字段为空")
    private String ResultInfo;
}
