package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取群详细资料请求参数")
public class ImGetGroupInfoReq {

    @ApiModelProperty(value = "（必填）需要拉取的群组列表")
    private List<String> GroupIdList;

    @ApiModelProperty(value = "（选填）群组维度的自定义字段过滤器")
    private ImResponseFilter ResponseFilter;

}
