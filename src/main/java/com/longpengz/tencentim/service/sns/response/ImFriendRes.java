package com.longpengz.tencentim.service.sns.response;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.sns.modle.ImFriendResultItem;
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
@ApiModel(description = "IM添加好友返回参数")
public class ImFriendRes extends ImResponse {
    
    @ApiModelProperty(value = "好友模块的结果对象数组")
    private List<ImFriendResultItem> ResultItem;

    @ApiModelProperty(value = "返回处理失败的用户列表，仅当存在失败用户时才返回该字段")
    private List<String> Fail_Account;
}
