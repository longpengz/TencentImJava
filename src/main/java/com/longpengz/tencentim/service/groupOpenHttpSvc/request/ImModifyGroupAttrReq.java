package com.longpengz.tencentim.service.groupOpenHttpSvc.request;
import com.longpengz.tencentim.bean.modle.ImMapItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM修改重置群自定义属性请求参数")
public class ImModifyGroupAttrReq {

    @ApiModelProperty(value = "（必填）修改自定义属性的群id")
    private String GroupId;
    
    @ApiModelProperty(value = "（必填）自定义属性列表，key 为自定义属性的键，value 为自定义属性的值")
    private List<ImMapItem> GroupAttr;
}
