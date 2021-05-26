package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "图像消息")
public class ImageMsgContent extends MsgContent {
    
    @ApiModelProperty(value = "")
    private String UUID;
    
    @ApiModelProperty(value = "")
    private Double ;
    
    @ApiModelProperty(value = "")
    private  ;
}
