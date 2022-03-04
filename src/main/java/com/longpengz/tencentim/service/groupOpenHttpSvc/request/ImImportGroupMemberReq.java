package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImImportGroupMemberMemberListItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM导入群成员请求参数")
public class ImImportGroupMemberReq {

    @ApiModelProperty(value = "（必填）要导入消息的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）待添加的群成员数组")
    private List<ImImportGroupMemberMemberListItem> MemberList;
}
