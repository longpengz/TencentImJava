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
@ApiModel(description = "IM获取群成员详细资料请求参数")
public class ImGetGroupMemberInfoReq {
    
    @ApiModelProperty(value = "（必填）需要拉取成员信息的群组的 ID")
    private String GroupId;

    @ApiModelProperty(value = "（选填）基础信息字段过滤器，指定需要获取的基础信息字段")
    private List<GroupInformationFieldEnum> GroupBaseInfoFilter;

    @ApiModelProperty(value = "（选填）成员信息字段过滤器，指定需要获取的成员信息字段")
    private List<MemberInformationFieldEnum> MemberInfoFilter;

    @ApiModelProperty(value = "（选填）该字段用来群组维度的自定义字段过滤器，指定需要获取的群组维度的自定义字段，")
    private List<String> AppDefinedDataFilter_Group;

    @ApiModelProperty(value = "（选填）该字段用来群成员维度的自定义字段过滤器，指定需要获取的群成员维度的自定义字段")
    private List<String> AppDefinedDataFilter_GroupMember;

    @ApiModelProperty(value = "（选填）一次最多获取多少个成员的资料，不得超过6000。如果不填，则获取群内全部成员的信息")
    private Integer Limit;

    @ApiModelProperty(value = "（选填）从第几个成员开始获取，如果不填则默认为0，表示从第一个成员开始获取")
    private Integer Offset;
}
