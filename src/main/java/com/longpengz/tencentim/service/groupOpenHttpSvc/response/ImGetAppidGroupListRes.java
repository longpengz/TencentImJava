package com.longpengz.tencentim.service.groupOpenHttpSvc.response;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImGroupItem;
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
@ApiModel(description = "IM获取 App 中的群组返回参数")
public class ImGetAppidGroupListRes extends ImResponse {

    @ApiModelProperty(value = "App 当前的群组总数。如果仅需要返回特定群组形态的群组，可以通过 GroupType 进行过滤，但此时返回的 TotalCount 的含义就变成了 App 中该群组形态的群组总数；\n" +
            "例如：假设 App 旗下总共 50000 个群组，其中有 20000 个为公开群组，如果将请求包体中的 GroupType 设置为 Public，那么不论 Limit 和 Offset 怎样设置，应答包体中的 TotalCount 都为 20000，且 GroupIdList 中的群组全部为公开群组")
    private Integer TotalCount;
    
    @ApiModelProperty(value = "获取到的群组 ID 的集合")
    private List<ImGroupItem> GroupIdList;
    
    @ApiModelProperty(value = "分页拉取的标志")
    private Integer Next;
}
