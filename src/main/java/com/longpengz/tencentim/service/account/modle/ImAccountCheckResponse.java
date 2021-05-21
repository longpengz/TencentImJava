package com.longpengz.tencentim.service.account.modle;

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
@ApiModel(description = "IM查询账号返回参数")
public class ImAccountCheckResponse extends ImResponse {

    @ApiModelProperty(value = "单个帐号的结果对象数组")
    private List<ImAccountCheckResultItem> ResultItem;
}
