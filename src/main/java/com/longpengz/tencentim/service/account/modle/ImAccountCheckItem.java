package com.longpengz.tencentim.service.account.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号（请求参数） 请求检查的帐号对象")
public class ImAccountCheckItem {

    @ApiModelProperty(value = "请求检查的帐号的 UserID")
    private String UserID;
}
