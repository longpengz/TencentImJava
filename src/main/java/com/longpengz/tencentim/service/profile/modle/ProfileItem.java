package com.longpengz.tencentim.service.profile.modle;
import com.longpengz.tencentim.service.profile.enums.ProfileItemTagEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "设置的用户的资料对象数组")
public class ProfileItem {

    @ApiModelProperty(value = "（必填）指定要设置的资料字段的名称")
    private ProfileItemTagEnum Tag;

    @ApiModelProperty(value = "（必填）待设置的资料字段的值")
    private Object value;


}
