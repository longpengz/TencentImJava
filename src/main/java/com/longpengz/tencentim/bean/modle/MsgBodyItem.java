package com.longpengz.tencentim.bean.modle;

import com.google.gson.Gson;
import com.longpengz.tencentim.bean.enums.MsgTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "消息内容")
public class MsgBodyItem {

    @ApiModelProperty(value = "消息元素类别")
    private MsgTypeEnum MsgType;

    @ApiModelProperty(value = "消息元素的内容")
    private MsgContent MsgContent;

}
