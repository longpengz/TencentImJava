package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM增加群成员返回参数")
public class ImAddGroupMemberRes extends ImResponse {
    
    @ApiModelProperty(value = "返回添加的群成员结果")
    private List<ImAddMemberItem> MemberList;

}
