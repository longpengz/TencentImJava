package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.modle.ImMapItem;
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
@ApiModel(description = "IM修改群成员资料请求参数")
public class ImModifyGroupMemberInfoReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）要操作的群成员")
    private String Member_Account;

    @ApiModelProperty(value = "（选填）成员身份，Admin/Member 分别为设置/取消管理员")
    private ImGroupMemberRoleEnum Role;

    @ApiModelProperty(value = "（必填）消息屏蔽类型")
    private ImMsgFlagEnum MsgFlag;

    @ApiModelProperty(value = "（选填）群名片（最大不超过50个字节）")
    private String NameCard;

    @ApiModelProperty(value = "（选填）群成员维度的自定义字段")
    private List<ImMapItem> AppMemberDefinedData;

    @ApiModelProperty(value = "（选填）需禁言时间，单位为秒，0表示取消禁言")
    private Integer ShutUpTime;
}
