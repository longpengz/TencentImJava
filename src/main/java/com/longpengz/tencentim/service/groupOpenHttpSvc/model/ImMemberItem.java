package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import com.longpengz.tencentim.bean.modle.ImMapItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM成员资料")
public class ImMemberItem {

    @ApiModelProperty(value = "群成员 ID")
    private String Member_Account;

    @ApiModelProperty(value = "群内身份")
    private ImGroupMemberRoleEnum Role;
    
    @ApiModelProperty(value = "入群时间")
    private Integer JoinTime;
    
    @ApiModelProperty(value = "该成员当前已读消息 Seq")
    private Integer MsgSeq;
    
    @ApiModelProperty(value = "消息接收选项")
    private ImMsgFlagEnum MsgFlag;
    
    @ApiModelProperty(value = "最后发送消息的时间")
    private Integer LastSendMsgTime;
    
    @ApiModelProperty(value = "群名片")
    private String NameCard;

    @ApiModelProperty(value = "群成员维度的自定义字段")
    private List<ImMapItem> AppMemberDefinedData;

}
