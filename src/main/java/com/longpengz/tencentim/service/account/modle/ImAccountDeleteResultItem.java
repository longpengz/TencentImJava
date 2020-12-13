package com.longpengz.tencentim.service.account.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "IM导入多个账号（返回参数） 单个帐号的结果对象")
public class ImAccountDeleteResultItem {

    @ApiModelProperty(value = "单个帐号的错误码，0表示成功，非0表示失败")
    private Integer ResultCode;

    @ApiModelProperty(value = "单个帐号删除失败时的错误描述信息")
    private String ResultInfo;

    @ApiModelProperty(value = "请求删除的帐号的 UserID")
    private String UserID;
}


