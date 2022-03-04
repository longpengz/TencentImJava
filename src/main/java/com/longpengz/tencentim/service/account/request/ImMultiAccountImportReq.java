package com.longpengz.tencentim.service.account.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM导入多个账号请求参数")
public class ImMultiAccountImportReq {

    @ApiModelProperty(value = "用户名，单个用户名长度不超过32字节，单次最多导入100个用户名")
    private List<String> Accounts;

}
