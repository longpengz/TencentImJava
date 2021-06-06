package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "视频消息")
public class VideoMsgContent extends MsgContent {

    @ApiModelProperty(value = "视频下载地址。可通过该 URL 地址直接下载相应视频。")
    private String VideoUrl;

    @ApiModelProperty(value = "视频数据大小，单位：字节。")
    private Long VideoSize;

    @ApiModelProperty(value = "视频时长，单位：秒。")
    private Long VideoSecond;

    @ApiModelProperty(value = "视频格式，例如 mp4。")
    private String VideoFormat;

    @ApiModelProperty(value = "视频下载方式标记。目前 VideoDownloadFlag 取值只能为2，表示可通过VideoUrl字段值的 URL 地址直接下载视频。")
    private Integer VideoDownloadFlag;

    @ApiModelProperty(value = "视频缩略图下载地址。可通过该 URL 地址直接下载相应视频缩略图。")
    private String ThumbUrl;

    @ApiModelProperty(value = "缩略图大小，单位：字节。")
    private Long ThumbSize;

    @ApiModelProperty(value = "缩略图宽度。")
    private Integer ThumbWidth;

    @ApiModelProperty(value = "缩略图高度。")
    private Integer ThumbHeight;

    @ApiModelProperty(value = "缩略图格式，例如 JPG、BMP 等。")
    private String ThumbFormat;

    @ApiModelProperty(value = "视频缩略图下载方式标记。目前 ThumbDownloadFlag 取值只能为2，表示可通过ThumbUrl字段值的 URL 地址直接下载视频缩略图。")
    private Integer ThumbDownloadFlag;
}
