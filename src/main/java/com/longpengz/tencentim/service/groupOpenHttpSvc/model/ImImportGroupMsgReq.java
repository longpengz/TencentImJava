package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM创建修改导入群组请求参数")
public class ImImportGroupMsgReq {

    @ApiModelProperty(value = "（必填）要导入消息的群 ID")
    private String GroupId;

    @ApiModelProperty(value = "（选填）会话更新识别，为1的时候标识触发会话更新，默认不触发（avchatroom 群不支持）。")
    private Integer RecentContactFlag;

    @ApiModelProperty(value = "（必填）导入的消息列表")
    private List<ImImportGroupMsgListItem> MsgList;
}
