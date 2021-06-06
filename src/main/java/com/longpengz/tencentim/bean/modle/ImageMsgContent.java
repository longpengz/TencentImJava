package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "图像消息")
public class ImageMsgContent extends MsgContent {
    
    @ApiModelProperty(value = "图片序列号。后台用于索引图片的键值。")
    private String UUID;
    
    @ApiModelProperty(value = "图片格式。JPG = 1，GIF = 2，PNG = 3，BMP = 4，其他 = 255。")
    private Integer ImageFormat;
    
    @ApiModelProperty(value = "原图、缩略图或者大图下载信息")
    private List<ImageInfoItem> ImageInfoArray;
}
