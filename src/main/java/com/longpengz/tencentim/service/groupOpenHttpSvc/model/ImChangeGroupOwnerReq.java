package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM转让群主请求参数")
public class ImChangeGroupOwnerReq {

    @ApiModelProperty(value = "（必填）要被转移的群组 ID")
    private String GroupId;

    @ApiModelProperty(value = "（必填）新群主 ID")
    private String NewOwner_Account;
}
