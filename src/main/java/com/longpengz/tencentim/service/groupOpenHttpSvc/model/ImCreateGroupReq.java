package com.longpengz.tencentim.service.groupOpenHttpSvc.model;
import com.longpengz.tencentim.bean.modle.ImMapItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM创建修改群组请求参数")
public class ImCreateGroupReq {

    @ApiModelProperty(value = "（创建选填、修改不填）群主 ID，自动添加到群成员中。如果不填，群没有群主")
    private String Owner_Account;

    @ApiModelProperty(value = "（创建必填、修改不填）群组形态")
    private GroupTypeEnum Type;
    
    @ApiModelProperty(value = "（选填）为了使得群组 ID 更加简单，便于记忆传播，腾讯云支持 App 在通过 REST API 创建群组时 自定义群组 ID")
    private String GroupId;
    
    @ApiModelProperty(value = "（必填）群名称，最长30字节，使用 UTF-8 编码，1个汉字占3个字节")
    private String Name;
    
    @ApiModelProperty(value = "（选填）群简介，最长240字节，使用 UTF-8 编码，1个汉字占3个字节")
    private String Introduction;

    @ApiModelProperty(value = "（选填）群公告，最长300字节，使用 UTF-8 编码，1个汉字占3个字节")
    private String Notification;

    @ApiModelProperty(value = "（选填）群头像 URL，最长100字节")
    private String FaceUrl;
    
    @ApiModelProperty(value = "（选填）最大群成员数量，缺省时的默认值：私有群是200，公开群是2000，聊天室是6000，音视频聊天室和在线成员广播大群无限制")
    private Integer MaxMemberCount;

    @ApiModelProperty(value = "（选填）申请加群处理方式")
    private ApplyJoinOptionEnum ApplyJoinOption;
    
    @ApiModelProperty(value = "（选填）群组维度的自定义字段，默认情况是没有的，可以通过 即时通信 IM 控制台 进行配置，详情请参阅 自定义字段")
    private List<ImMapItem> AppDefinedData;

    @ApiModelProperty(value = "（选填）初始群成员列表，最多500个；成员信息字段详情请参阅 群成员资料")
    private List<ImMemberItem> MemberList;

    @ApiModelProperty(value = "（创建不填、修改选填）群内群成员禁言，只有群管理员和群主以及系统管理员可以发言")
    private ShutUpAllMemberEnum ShutUpAllMember;

}
