package com.longpengz.tencentim.service.openconfigsvr.model;

import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取运营数据返回参数")
public class ImGetappinfoRes extends ImResponse {

    @ApiModelProperty(value = "请求最近30天的运营数据，字段对应ImOperationFieldEnum信息")
    private List<Map<String, String>> Result;
}
