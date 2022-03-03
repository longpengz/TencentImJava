package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM创建导入群组返回参数")
public class ImCreateGroupRes extends ImResponse {

    @ApiModelProperty(value = "创建成功之后的群 ID，由即时通信 IM 后台分配")
    private String GroupId;

}
