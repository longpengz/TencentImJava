package com.longpengz.tencentim.service.recentContacts.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除单个会话请求参数")
public class ImRecentContactsDeleteReq {

    @ApiModelProperty(value = "（必填）请求删除该 UserID 的会话")
    private String From_Account;

    @ApiModelProperty(value = "（必填）会话类型：1 表示 C2C 会话；2 表示 G2C 会话")
    private Integer Type;

    @ApiModelProperty(value = "（选填）C2C 会话才赋值，C2C 会话方的 UserID")
    private String To_Account;

    @ApiModelProperty(value = "（选填）G2C 会话才赋值，G2C 会话的群 ID")
    private String ToGroupid;

    @ApiModelProperty(value = "（选填）是否清理漫游消息：1 表示清理漫游消息；0 表示不清理漫游消息")
    private Integer ClearRamble;
}
