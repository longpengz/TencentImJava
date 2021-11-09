package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM键值对自定义字段")
public class ImMapItem {

    @ApiModelProperty(value = "自定义的 Key")
    private String Key;

    @ApiModelProperty(value = "自定义字段值")
    private String Value;
}
