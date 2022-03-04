package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImAddMemberItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM增加群成员请求参数")
public class ImAddGroupMemberReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（选填）是否静默加人。0：非静默加人；1：静默加人。不填该字段默认为0")
    private Integer Silence;

    @ApiModelProperty(value = "（必填）待添加的群成员数组")
    private List<ImAddMemberItem> MemberList;

}
