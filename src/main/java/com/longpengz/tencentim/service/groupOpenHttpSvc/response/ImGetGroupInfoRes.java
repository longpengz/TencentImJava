package com.longpengz.tencentim.service.groupOpenHttpSvc.response;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.groupOpenHttpSvc.request.ImCreateGroupReq;
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
@ApiModel(description = "IM获取群详细资料返回参数")
public class ImGetGroupInfoRes extends ImResponse {

    @ApiModelProperty(value = "返回结果为群组信息数组")
    private List<ImCreateGroupReq> GroupInfo;

}
