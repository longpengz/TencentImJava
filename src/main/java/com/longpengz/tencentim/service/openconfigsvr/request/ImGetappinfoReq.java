package com.longpengz.tencentim.service.openconfigsvr.request;
import com.longpengz.tencentim.service.openconfigsvr.enums.ImOperationFieldEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取运营数据请求参数")
public class ImGetappinfoReq {

    @ApiModelProperty(value = "（选填）该字段用来指定需要拉取的运营数据，不填默认拉取所有字段。")
    private List<ImOperationFieldEnum> RequestField;
}
