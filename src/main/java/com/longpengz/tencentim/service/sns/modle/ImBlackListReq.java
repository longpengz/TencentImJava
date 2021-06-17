package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM添加删除黑名单请求参数")
public class ImBlackListReq {

    @ApiModelProperty(value = "（必填）请求为该 UserID 添加删除黑名单")
    private String From_Account;

    @ApiModelProperty(value = "待添加删除为黑名单的用户 UserID 列表，单次请求的 To_Account 数不得超过1000")
    private List<String> To_Account;

}
