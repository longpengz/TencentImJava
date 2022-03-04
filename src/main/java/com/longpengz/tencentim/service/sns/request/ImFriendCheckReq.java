package com.longpengz.tencentim.service.sns.request;
import com.longpengz.tencentim.service.sns.enums.CheckFriendTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM校验好友请求参数")
public class ImFriendCheckReq {
    
    @ApiModelProperty(value = "（必填）需要校验该 UserID 的好友")
    private String From_Account;
    
    @ApiModelProperty(value = "（必填）请求校验的好友的 UserID 列表，单次请求的 To_Account 数不得超过1000")
    private List<String> To_Account;
    
    @ApiModelProperty(value = "（必填）校验模式")
    private CheckFriendTypeEnum CheckType;
}
