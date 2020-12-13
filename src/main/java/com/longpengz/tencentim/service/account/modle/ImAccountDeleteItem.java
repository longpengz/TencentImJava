package com.longpengz.tencentim.service.account.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除账号（请求参数） 请求删除的帐号对象")
public class ImAccountDeleteItem {
    
    @ApiModelProperty(value = "请求删除的帐号的 UserID")
    private String UserID;
}
