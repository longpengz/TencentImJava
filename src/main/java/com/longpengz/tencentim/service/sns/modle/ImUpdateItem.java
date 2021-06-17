package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "需要更新的好友对象")
public class ImUpdateItem {
    
    @ApiModelProperty(value = "（必填）好友的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "（必填）需要更新的关系链数据对象数组")
    private List<ImSnsItem> SnsItem;

}
