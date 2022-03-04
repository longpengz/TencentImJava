package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

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
@ApiModel(description = "IM获取被禁言群成员列表请求参数")
public class ImGetGroupShuttedUinReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;

}
