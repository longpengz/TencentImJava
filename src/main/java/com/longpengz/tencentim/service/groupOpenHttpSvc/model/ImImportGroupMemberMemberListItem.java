package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import com.longpengz.tencentim.service.groupOpenHttpSvc.enums.ImGroupMemberRoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM待添加的群成员")
public class ImImportGroupMemberMemberListItem {
    
    @ApiModelProperty(value = "（必填）待导入的群成员帐号")
    private String Member_Account;
    
    @ApiModelProperty(value = "（选填）待导入群成员角色；目前只支持填 Admin，不填则为普通成员 Member")
    private ImGroupMemberRoleEnum Role;

    @ApiModelProperty(value = "（选填）待导入群成员的入群时间")
    private Integer JoinTime;

    @ApiModelProperty(value = "（选填）待导入群成员的未读消息计数")
    private Integer UnreadMsgNum;
    
    @ApiModelProperty(value = "导入结果：0表示失败；1表示成功；2 表示已经是群成员")
    private Integer Result;
}
