package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM设置成员未读消息计数")
public class ImSetUnreadMsgNumReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）要操作的群成员")
    private String Member_Account;

    @ApiModelProperty(value = "（必填）成员未读消息数")
    private Integer UnreadMsgNum;
}
