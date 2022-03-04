package com.longpengz.tencentim.service.sns.response;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.sns.modle.ImGroupGetResultItem;
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
@ApiModel(description = "IM拉取分组返回参数")
public class ImGroupGetRes extends ImResponse {
    
    @ApiModelProperty(value = "拉取分组的结果对象数组")
    private List<ImGroupGetResultItem> ResultItem;
    
    @ApiModelProperty(value = "返回最新的分组 Sequence")
    private Integer CurrentSequence;
}
