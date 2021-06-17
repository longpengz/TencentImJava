package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "好友对象")
public class ImUserDataItem {

    @ApiModelProperty(value = "好友的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "保存好友数据的数组")
    private List<ImCustomItem> ValueItem;

}
