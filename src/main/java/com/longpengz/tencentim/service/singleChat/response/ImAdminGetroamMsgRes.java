package com.longpengz.tencentim.service.singleChat.response;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.singleChat.modle.ImMsgListItem;
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
@ApiModel(description = "IM查询单聊消息返回参数")
public class ImAdminGetroamMsgRes extends ImResponse {

    @ApiModelProperty(value = "是否全部拉取，0表示未全部拉取，需要续拉，1表示已全部拉取")
    private Integer Complete;

    @ApiModelProperty(value = "本次拉取到的消息条数")
    private Integer MsgCnt;

    @ApiModelProperty(value = "本次拉取到的消息里的最后一条消息的时间")
    private Integer LastMsgTime;

    @ApiModelProperty(value = "本次拉取到的消息里的最后一条消息的标识")
    private String LastMsgKey;

    @ApiModelProperty(value = "返回的消息列表")
    private List<ImMsgListItem> MsgList;
}
