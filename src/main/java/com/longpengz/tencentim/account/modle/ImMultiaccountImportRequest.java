package com.longpengz.tencentim.account.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "")
public class ImMultiaccountImportRequest {

    @ApiModelProperty(value = "用户名，单个用户名长度不超过32字节，单次最多导入100个用户名")
    private List<String> Accounts;
}
