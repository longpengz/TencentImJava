package com.longpengz.tencentim.service.recentContacts.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "会话对象")
public class SessionObj {

    @ApiModelProperty(value = "会话类型：1 表示 C2C 会话；2 表示 G2C 会话")
    private Integer Type;

    @ApiModelProperty(value = "C2C 会话才会返回，返回会话方的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "G2C 会话才会返回，返回群 ID")
    private String GroupId;

    @ApiModelProperty(value = "会话时间")
    private Integer MsgTime;

    @ApiModelProperty(value = "置顶标记：0 标识普通会话；1 标识置顶会话")
    private Integer TopFlag;
}
