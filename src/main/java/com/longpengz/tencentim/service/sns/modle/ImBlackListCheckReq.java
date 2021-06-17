package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM校验黑名单请求参数")
public class ImBlackListCheckReq {
    
    @ApiModelProperty(value = "（必填）需要校验该 UserID 的黑名单")
    private String From_Account;

    @ApiModelProperty(value = "（必填）待校验的黑名单的 UserID 列表，单次请求的 To_Account 数不得超过1000")
    private List<String> To_Account;

    @ApiModelProperty(value = "（必填）校验模式")
    private CheckBlackTypeEnum CheckType;

}
