package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "被撤回的消息")
public class ImMsgSeqItem {

    @ApiModelProperty(value = "（必填）请求撤回的消息 seq")
    private Integer MsgSeq;
}
