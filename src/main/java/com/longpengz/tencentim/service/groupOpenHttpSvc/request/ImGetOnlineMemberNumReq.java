package com.longpengz.tencentim.service.groupOpenHttpSvc.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取直播群在线人数请求参数")
public class ImGetOnlineMemberNumReq {

    @ApiModelProperty(value = "（必填）操作的群 ID")
    private String GroupId;
}
