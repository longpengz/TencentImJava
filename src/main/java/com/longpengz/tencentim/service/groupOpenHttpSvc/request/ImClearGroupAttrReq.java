package com.longpengz.tencentim.service.groupOpenHttpSvc.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM清空群自定义属性请求参数")
public class ImClearGroupAttrReq {

    @ApiModelProperty(value = "（必填）清空自定义属性的群 id")
    private String GroupId;
}
