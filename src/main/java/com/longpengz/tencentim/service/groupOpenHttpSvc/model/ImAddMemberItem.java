package com.longpengz.tencentim.service.groupOpenHttpSvc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM添加的成员资料")
public class ImAddMemberItem {

    @ApiModelProperty(value = "（必填）要添加的群成员 ID")
    private String Member_Account;

    @ApiModelProperty(value = "返回参数 加人结果：0 为失败；1 为成功；2 为已经是群成员")
    private Integer Result;
}
