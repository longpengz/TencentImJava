package com.longpengz.tencentim.service.account.modle;
import com.longpengz.tencentim.bean.enums.QueryStateResultItemStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号状态（返回参数） 详细的登录平台信息")
public class ImQueryStateResultItemDetail {

    @ApiModelProperty(value = "登录的平台类型，可能的返回值有：iPhone, Android, Web, PC, iPad, Mac")
    private String Platform;

    @ApiModelProperty(value = "该登录平台的状态")
    private QueryStateResultItemStatusEnum Status;
}
