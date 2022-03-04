package com.longpengz.tencentim.service.openconfigsvr.response;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取服务器IP地址返回参数")
public class ImGetIPListRes extends ImResponse {

    @ApiModelProperty(value = "服务器IP列表")
    private List<String> IPList;
}
