package com.longpengz.tencentim.service.sns.request;
import com.longpengz.tencentim.service.sns.modle.ImAddFriendItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM导入好友请求参数")
public class ImFriendImportReq {

    @ApiModelProperty(value = "（必填）需要为该 UserID 添加好友")
    private String From_Account;

    @ApiModelProperty(value = "（必填）好友结构体对象")
    private List<ImAddFriendItem<List<String>>> AddFriendItem;

}
