package com.longpengz.tencentim.service.profile.request;
import com.longpengz.tencentim.service.profile.modle.ProfileItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM设置资料请求参数")
public class ImPortraitSetReq {
    
    @ApiModelProperty(value = "（必填）需要设置该 UserID 的资料")
    private String From_Account;
    
    @ApiModelProperty(value = "待设置的用户的资料对象数组")
    private List<com.longpengz.tencentim.service.profile.modle.ProfileItem> ProfileItem;
}
