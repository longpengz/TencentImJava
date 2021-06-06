package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "原图、缩略图或者大图下载信息")
public class ImageInfoItem {
    
    @ApiModelProperty(value = "图片类型： 1-原图，2-大图，3-缩略图。")
    private Integer Type;
    
    @ApiModelProperty(value = "图片数据大小，单位：字节。")
    private Long Size;

    @ApiModelProperty(value = "图片宽度")
    private Integer Width;

    @ApiModelProperty(value = "图片高度")
    private Integer Height;

    @ApiModelProperty(value = "图片下载地址")
    private String URL;
}
