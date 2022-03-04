package com.longpengz.tencentim.service.profile.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.profile.modle.UserProfileItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取资料返回参数")
public class ImPortraitGetRes extends ImResponse {

    @ApiModelProperty(value = "返回的用户资料结构化信息")
    private List<com.longpengz.tencentim.service.profile.modle.UserProfileItem> UserProfileItem;

    @ApiModelProperty(value = "返回处理失败的用户列表，仅当存在失败用户时才返回该字段")
    private List<String> Fail_Account;

}
