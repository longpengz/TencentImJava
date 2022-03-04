package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

import com.longpengz.tencentim.service.groupOpenHttpSvc.enums.GroupTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取 App 中的群组请求参数")
public class ImGetAppidGroupListReq {

    @ApiModelProperty(value = "（选填）本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000")
    private Integer Limit;

    @ApiModelProperty(value = "（选填）群太多时分页拉取标志，第一次填0，以后填上一次返回的值，返回的 Next 为0代表拉完了")
    private Integer Next;

    @ApiModelProperty(value = "（选填）如果仅需要返回特定群组形态的群组，可以通过 GroupType 进行过滤，但此时返回的 TotalCount 的含义就变成了 App 中属于该群组形态的群组总数。不填为获取所有类型的群组。")
    private GroupTypeEnum GroupType;

}
