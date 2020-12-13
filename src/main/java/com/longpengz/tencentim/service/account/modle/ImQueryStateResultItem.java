package com.longpengz.tencentim.service.account.modle;
import com.longpengz.tencentim.bean.enums.QueryStateResultItemStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号在线状态（返回参数） 返回的用户在线状态结构化信息")
public class ImQueryStateResultItem {

    @ApiModelProperty(value = "返回的用户的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "返回的用户状态")
    private QueryStateResultItemStatusEnum Status;

    @ApiModelProperty(value = "详细的登录平台信息")
    private ImQueryStateResultItemDetail Detail;


}
