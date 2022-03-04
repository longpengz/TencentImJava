package com.longpengz.tencentim.service.groupOpenHttpSvc.response;
import com.longpengz.tencentim.bean.modle.ImMapItem;
import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取群自定义属性返回参数")
public class ImGetGroupAttrRes extends ImResponse {

    @ApiModelProperty(value = "自定义属性的键值对")
    private List<ImMapItem> GroupAttrAry;
}
