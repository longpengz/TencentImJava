package com.longpengz.tencentim.bean.response;

import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM请求返回基础参数")
public class ImResponse {

    @ApiModelProperty(value = "请求处理的结果")
    private ActionStatusEnum ActionStatus;
    
    @ApiModelProperty(value = "失败原因")
    private String ErrorInfo;
    
    @ApiModelProperty(value = "错误码")
    private Integer ErrorCode;

}
