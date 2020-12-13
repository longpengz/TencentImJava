package com.longpengz.tencentim.service.account.modle;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除账户返回参数")
public class ImAccountDeleteResponse extends ImResponse {

    @ApiModelProperty(value = "单个帐号的结果对象数组")
    private List<ImAccountDeleteResultItem> ResultItem;


}
