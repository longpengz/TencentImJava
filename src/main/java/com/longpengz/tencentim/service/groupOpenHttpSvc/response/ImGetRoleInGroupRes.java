package com.longpengz.tencentim.service.groupOpenHttpSvc.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImMemberItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询用户在群组中的身份返回参数")
public class ImGetRoleInGroupRes extends ImResponse {

    @ApiModelProperty(value = "拉取到的成员角色，包括：Owner(群主)，Admin(群管理员)，Member(普通群成员），NotMember(非群成员)")
    private List<ImMemberItem> UserIdList;
}
