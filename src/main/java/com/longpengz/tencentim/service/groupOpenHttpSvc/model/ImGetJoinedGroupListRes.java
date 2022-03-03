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
@ApiModel(description = "IM获取用户所加入的群组返回参数")
public class ImGetJoinedGroupListRes extends ImResponse {

    @ApiModelProperty(value = "用户所加入的群组个数")
    private Integer TotalCount;

    @ApiModelProperty(value = "需要拉取的群组列表")
    private List<ImCreateGroupReq> GroupIdList;
}
