package com.longpengz.tencentim.service.account.modle;

import com.longpengz.tencentim.bean.enums.AccountStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号（返回参数）单个帐号的结果对象")
public class ImAccountCheckResultItem {

    @ApiModelProperty(value = "请求检查的帐号的 UserID")
    private String UserID;

    @ApiModelProperty(value = "单个帐号的检查结果：0表示成功，非0表示失败")
    private Integer ResultCode;

    @ApiModelProperty(value = "单个帐号检查失败时的错误描述信息")
    private String ResultInfo;

    @ApiModelProperty(value = "单个帐号的导入状态")
    private AccountStatusEnum AccountStatus;
}
