package com.longpengz.tencentim.service.account.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM导入单个账号请求参数")
public class ImAccountImportReq {
    
    @ApiModelProperty(value = "用户名，长度不超过32字节（必填）")
    private String Identifier;

    @ApiModelProperty(value = "用户昵称（选填）")
    private String Nick;

    @ApiModelProperty(value = "用户头像 URL（选填 http链接）")
    private String FaceUrl;
    
}
