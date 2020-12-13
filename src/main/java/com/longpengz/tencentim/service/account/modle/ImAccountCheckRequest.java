package com.longpengz.tencentim.service.account.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号请求参数")
public class ImAccountCheckRequest {

    @ApiModelProperty(value = "请求检查的帐号对象数组，单次请求最多支持100个帐号")
    private List<ImAccountCheckItem> CheckItem;
}
