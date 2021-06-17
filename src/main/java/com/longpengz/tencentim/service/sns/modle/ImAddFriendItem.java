package com.longpengz.tencentim.service.sns.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "好友结构体对象")
public class ImAddFriendItem<T> {

    @ApiModelProperty(value = "（必填）好友的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "（选填）From_Account 对 To_Account 的好友备注")
    private String Remark;

    @ApiModelProperty(value = "（选填）From_Account 对 To_Account 的分组信息，添加好友时只允许设置一个分组，因此使用 String 类型即可，导入传入列表")
    private T GroupName;

    @ApiModelProperty(value = "（必填）加好友来源字段 必须AddSource_Type_ 开头")
    private String AddSource;

    @ApiModelProperty(value = "（选填）From_Account 和 To_Account 形成好友关系时的附言信息")
    private String AddWording;

    @ApiModelProperty(value = "（选填）From_Account 和 To_Account 形成好友关系的时间")
    private Integer AddTime;

    @ApiModelProperty(value = "（选填）From_Account 对 To_Account 的自定义好友数据")
    private List<ImCustomItem> CustomItem;

}
