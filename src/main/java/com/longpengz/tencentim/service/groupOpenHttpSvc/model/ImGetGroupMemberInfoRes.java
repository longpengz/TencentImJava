package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
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
@ApiModel(description = "IM获取群成员详细资料返回参数")
public class ImGetGroupMemberInfoRes extends ImResponse {

    @ApiModelProperty(value = "本群组的群成员总数")
    private Integer MemberNum;

    @ApiModelProperty(value = "获取到的群成员列表，其中包含了全部或者指定的群成员信息")
    private List<ImMemberItem> MemberList;
}
