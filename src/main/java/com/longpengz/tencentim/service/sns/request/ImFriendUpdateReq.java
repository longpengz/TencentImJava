package com.longpengz.tencentim.service.sns.request;
import com.longpengz.tencentim.service.sns.modle.ImUpdateItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM更新好友请求参数")
public class ImFriendUpdateReq {
    
    @ApiModelProperty(value = "（必填）需要更新该 UserID 的关系链数据")
    private String From_Account;

    @ApiModelProperty(value = "（必填）需要更新的好友对象数组")
    private List<ImUpdateItem> UpdateItem;
}
