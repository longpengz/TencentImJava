package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "表情消息")
public class FaceMsgContent extends MsgContent{

    @ApiModelProperty(value = "表情索引，用户自定义")
    private Integer Index;

    @ApiModelProperty(value = "额外数据")
    private String Data;
}
