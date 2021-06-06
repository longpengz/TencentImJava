package com.longpengz.tencentim.bean.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "语音消息")
public class SoundMsgContent extends MsgContent {
    // 通过服务端集成的 Rest API 接口发送语音消息时，需要填入语音的 URL ，且需保证通过该 URL 能下载到对应语音。Download_Flag 字段必须填2。

    @ApiModelProperty(value = "语音下载地址，可通过该 URL 地址直接下载相应语音。")
    private String Url;

    @ApiModelProperty(value = "语音数据大小，单位：字节。")
    private Long Size;

    @ApiModelProperty(value = "语音时长，单位：秒。")
    private Long Second;

    @ApiModelProperty(value = "语音下载方式标记。目前 Download_Flag 取值只能为2，表示可通过Url字段值的 URL 地址直接下载语音。")
    private Integer Download_Flag;

}
