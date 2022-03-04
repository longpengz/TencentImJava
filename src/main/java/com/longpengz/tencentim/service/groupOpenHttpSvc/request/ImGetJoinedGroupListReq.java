package com.longpengz.tencentim.service.groupOpenHttpSvc.request;

import com.longpengz.tencentim.service.groupOpenHttpSvc.enums.GroupTypeEnum;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImResponseFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM获取用户所加入的群组请求参数")
public class ImGetJoinedGroupListReq {

    @ApiModelProperty(value = "（必填）要操作的群成员")
    private String Member_Account;

    @ApiModelProperty(value = "（选填）是否获取用户加入的 AVChatRoom(直播群)，0表示不获取，1表示获取。默认为0")
    private Integer WithHugeGroups;

    @ApiModelProperty(value = "（选填）是否获取用户已加入但未激活的 Private（即新版本中 Work，好友工作群) 群信息，0表示不获取，1表示获取。默认为0")
    private Integer WithNoActiveGroups;

    @ApiModelProperty(value = "（选填）单次拉取的群组数量，如果不填代表所有群组")
    private Integer Limit;

    @ApiModelProperty(value = "（选填）从第多少个群组开始拉取")
    private Integer Offset;

    @ApiModelProperty(value = "（选填）群组类型")
    private GroupTypeEnum GroupType;

    @ApiModelProperty(value = "（选填）使用GroupBaseInfoFilter 和 SelfInfoFilter 两个过滤器")
    private ImResponseFilter ResponseFilter;
}
