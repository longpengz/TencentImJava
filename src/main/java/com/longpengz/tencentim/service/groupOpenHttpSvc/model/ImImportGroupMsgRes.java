package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import com.longpengz.tencentim.bean.response.ImResponse;
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
@ApiModel(description = "IM导入群消息返回参数")
public class ImImportGroupMsgRes extends ImResponse {

    @ApiModelProperty(value = "具体的消息导入结果")
    private List<ImImportMsgResultItem> ImportMsgResult;
}
