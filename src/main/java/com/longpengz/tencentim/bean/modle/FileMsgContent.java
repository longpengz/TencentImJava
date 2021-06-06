package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "文件消息")
public class FileMsgContent extends MsgContent {

    @ApiModelProperty(value = "文件下载地址，可通过该 URL 地址直接下载相应文件。")
    private String Url;

    @ApiModelProperty(value = "文件数据大小，单位：字节。")
    private Long FileSize;

    @ApiModelProperty(value = "文件名称")
    private String FileName;

    @ApiModelProperty(value = "文件下载方式标记。目前 Download_Flag 取值只能为2，表示可通过Url字段值的 URL 地址直接下载文件。")
    private Integer Download_Flag;
}
