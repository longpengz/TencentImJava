package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除群成员请求参数")
public class ImDeleteGroupMemberReq  {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（选填）是否静默删人。0表示非静默删人，1表示静默删人。静默即删除成员时不通知群里所有成员，只通知被删除群成员。不填写该字段时默认为0")
    private Integer Silence;

    @ApiModelProperty(value = "（选填）踢出用户原因")
    private String Reason;

    @ApiModelProperty(value = "（必填）待删除的群成员")
    private List<String> MemberToDel_Account;
}
