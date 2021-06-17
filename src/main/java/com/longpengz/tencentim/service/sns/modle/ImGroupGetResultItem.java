package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取分组的结果对象")
public class ImGroupGetResultItem {

    @ApiModelProperty(value = "分组名")
    private String GroupName;

    @ApiModelProperty(value = "该分组下的好友数量")
    private Integer FriendNumber;
}
