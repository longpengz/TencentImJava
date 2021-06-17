package com.longpengz.tencentim.service.sns.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM添加删除分组请求参数")
public class ImGroupReq {

    @ApiModelProperty(value = "（必填）需要为该 UserID 添加删除新分组")
    private String From_Account;

    @ApiModelProperty(value = "（必填）新增删除分组列表")
    private List<String> GroupName;

    @ApiModelProperty(value = "（选填）新增需要加入新增分组的好友的 UserID 列表")
    private List<String> To_Account;

}
