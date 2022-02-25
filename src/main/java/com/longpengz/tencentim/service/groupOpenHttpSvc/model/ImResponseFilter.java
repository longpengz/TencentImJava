package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import com.longpengz.tencentim.bean.modle.GroupInformationFieldEnum;
import com.longpengz.tencentim.bean.modle.MemberInformationFieldEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取群详细资料过滤器")
public class ImResponseFilter {

    @ApiModelProperty(value = "（选填）基础信息字段过滤器，指定需要获取的基础信息字段")
    private List<GroupInformationFieldEnum> GroupBaseInfoFilter;

    @ApiModelProperty(value = "（选填）成员信息字段过滤器，指定需要获取的成员信息字段")
    private List<MemberInformationFieldEnum> MemberInfoFilter;

    @ApiModelProperty(value = "（选填）成员信息字段过滤器，指定需要获取的成员信息字段")
    private List<MemberInformationFieldEnum> SelfInfoFilter;

    @ApiModelProperty(value = "（选填）该字段用来群组维度的自定义字段过滤器，指定需要获取的群组维度的自定义字段，")
    private List<String> AppDefinedDataFilter_Group;

    @ApiModelProperty(value = "（选填）该字段用来群成员维度的自定义字段过滤器，指定需要获取的群成员维度的自定义字段")
    private List<String> AppDefinedDataFilter_GroupMember;
}
