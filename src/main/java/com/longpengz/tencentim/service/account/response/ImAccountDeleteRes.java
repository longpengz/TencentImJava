package com.longpengz.tencentim.service.account.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.account.modle.ImAccountDeleteResultItem;
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
@ApiModel(description = "IM删除账户返回参数")
public class ImAccountDeleteRes extends ImResponse {

    @ApiModelProperty(value = "单个帐号的结果对象数组")
    private List<ImAccountDeleteResultItem> ResultItem;


}
