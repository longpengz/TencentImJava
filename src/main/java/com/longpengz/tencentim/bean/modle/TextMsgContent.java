package com.longpengz.tencentim.bean.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "文本消息")
public class TextMsgContent extends MsgContent {

    @ApiModelProperty(value = "消息内容")
    private String Text;
}
