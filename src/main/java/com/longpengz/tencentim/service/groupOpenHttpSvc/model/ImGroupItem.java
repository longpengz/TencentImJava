package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM群组信息")
public class ImGroupItem {

    @ApiModelProperty(value = "群组 ID ")
    private String GroupId;
}
