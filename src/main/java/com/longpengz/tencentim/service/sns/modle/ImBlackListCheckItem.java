package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "校验结果对象")
public class ImBlackListCheckItem {

    @ApiModelProperty(value = "请求校验的用户的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "校验成功时 To_Account 与 From_Account 之间的黑名单关系")
    private BlackRelationEnum Relation;

    @ApiModelProperty(value = "To_Account 的处理结果，0表示成功，非0表示失败")
    private Integer ResultCode;

    @ApiModelProperty(value = "To_Account 的错误描述信息，成功时该字段为空")
    private String ResultInfo;



}
