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
@ApiModel(description = "IM获取被禁言群成员列表返回参数")
public class ImGetGroupShuttedUinRes extends ImResponse {

    @ApiModelProperty(value = "禁言用户信息数组")
    private List<ImShuttedUinItem> ShuttedUinList;
}
