package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.response.ImResponse;
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
@ApiModel(description = "IM导入群成员返回参数")
public class ImImportGroupMemberRes extends ImResponse {

    @ApiModelProperty(value = "返回添加的群成员结果")
    private List<ImImportGroupMemberMemberListItem> MemberList;
}
