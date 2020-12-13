package com.longpengz.tencentim.service.account.modle;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM查询账号在线状态返回参数")
public class ImQueryStateResponse extends ImResponse {

    @ApiModelProperty(value = "返回的用户在线状态结构化信息")
    private List<ImQueryStateResultItem> QueryResult;

    @ApiModelProperty(value = "状态查询失败的帐号列表，在此列表中的目标帐号，状态查询失败或目标帐号不存在。若状态全部查询成功，则 ErrorList 为空")
    private List<ImQueryStateErrorItem> ErrorList;


}
