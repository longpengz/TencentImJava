package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM拉取分组请求参数")
public class ImGroupGetReq {

    @ApiModelProperty(value = "（必填）指定要拉取分组的用户的 UserID")
    private String From_Account;

    @ApiModelProperty(value = "（必填）上一次拉取分组时后台返回给客户端的 Seq，初次拉取时为0，只有 GroupName 为空时有效")
    private Integer LastSequence;

    @ApiModelProperty(value = "（选填）是否需要拉取分组下的 User 列表, Need_Friend_Type_Yes: 需要拉取, 不填时默认不拉取, 只有 GroupName 为空时有效")
    private String NeedFriend;

    @ApiModelProperty(value = "（选填）要拉取的分组名称")
    private List<String> GroupName;

}
