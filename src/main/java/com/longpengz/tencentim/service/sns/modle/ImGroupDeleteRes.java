package com.longpengz.tencentim.service.sns.modle;

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
@ApiModel(description = "IM删除分组返回参数")
public class ImGroupDeleteRes extends ImResponse {

    @ApiModelProperty(value = "返回最新的分组 Sequence")
    private Integer CurrentSequence;

}
