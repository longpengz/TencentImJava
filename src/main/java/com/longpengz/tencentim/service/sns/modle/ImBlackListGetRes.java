package com.longpengz.tencentim.service.sns.modle;

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
@ApiModel(description = "IM拉取黑名单返回参数")
public class ImBlackListGetRes extends ImResponse {

    @ApiModelProperty(value = "黑名单对象数组")
    private List<ImBlackListItem> BlackListItem;

    @ApiModelProperty(value = "下页拉取的起始位置，0表示已拉完")
    private Integer StartIndex;

    @ApiModelProperty(value = "黑名单最新的 Seq")
    private Integer CurruentSequence;
}
