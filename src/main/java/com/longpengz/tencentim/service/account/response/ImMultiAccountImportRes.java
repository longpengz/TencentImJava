package com.longpengz.tencentim.service.account.response;

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
@ApiModel(description = "IM导入多个账号返回参数")
public class ImMultiAccountImportRes extends ImResponse {

    @ApiModelProperty(value = "导入失败的帐号列表")
    private List<String> FailAccounts;
}
