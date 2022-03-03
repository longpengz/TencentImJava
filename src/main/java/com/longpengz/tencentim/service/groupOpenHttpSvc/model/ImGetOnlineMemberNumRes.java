package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取直播群在线人数返回参数")
public class ImGetOnlineMemberNumRes extends ImResponse {

    @ApiModelProperty(value = "该群组的在线人数")
    private Integer OnlineMemberNum;


}
