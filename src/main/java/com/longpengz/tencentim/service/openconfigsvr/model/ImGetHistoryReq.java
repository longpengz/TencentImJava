package com.longpengz.tencentim.service.openconfigsvr.model;
import com.longpengz.tencentim.bean.enums.ChatTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM下载最近消息记录请求参数")
public class ImGetHistoryReq {
    
    @ApiModelProperty(value = "（必填）消息类型，C2C 表示单发消息 Group 表示群组消息")
    private ChatTypeEnum ChatType;

    @ApiModelProperty(value = "（必填）需要下载的消息记录的时间段，2015120121表示获取2015年12月1日21:00 - 21:59的消息的下载地址。" +
            "该字段需精确到小时。每次请求只能获取某天某小时的所有单发或群组消息记录")
    private String MsgTime;
}
