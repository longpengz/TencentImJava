package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM黑名单对象")
public class ImBlackListItem {

    @ApiModelProperty(value = "黑名单的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "添加黑名单的时间")
    private Integer AddBlackTimeStamp;
}
