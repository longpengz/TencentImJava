package com.longpengz.tencentim.service.groupOpenHttpSvc.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImRecallRetItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM撤回群消息返回参数")
public class ImGroupMsgRecallRes extends ImResponse {

    @ApiModelProperty(value = "消息撤回请求的详细结果")
    private List<ImRecallRetItem> RecallRetList;
}
