package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "好友模块的结果对象")
public class ImFriendResultItem {
    
    @ApiModelProperty(value = "请求添加、导入、更新、删除、校验的好友的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "To_Account 的处理结果，0表示成功，非0表示失败")
    private Integer ResultCode;

    @ApiModelProperty(value = "To_Account 的错误描述信息，成功时该字段为空")
    private String ResultInfo;
    
    @ApiModelProperty(value = "校验的好友成功时To_Account 与 From_Account 之间的好友关系")
    private FriendRelationEnum Relation;

}
