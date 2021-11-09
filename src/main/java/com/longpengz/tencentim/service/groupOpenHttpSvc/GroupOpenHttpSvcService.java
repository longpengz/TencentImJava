package com.longpengz.tencentim.service.groupOpenHttpSvc;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.*;

/**
 * @author longpengZ
 * IM账号管理相关接口
 */
public interface GroupOpenHttpSvcService {

    /**
     * 获取 App 中的所有群组
     * App 管理员可以通过该接口获取 App 中所有群组的 ID。
     * Limit （选填）本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000
     * Next （选填）群太多时分页拉取标志，第一次填0，以后填上一次返回的值，返回的 Next 为0代表拉完了
     * GroupType （选填）如果仅需要返回特定群组形态的群组，可以通过 GroupType 进行过滤，但此时返回的 TotalCount 的含义就变成了 App 中属于该群组形态的群组总数。不填为获取所有类型的群组。
     * @author longpengZ
     * @return ImGetAppidGroupListRes
     */
    ImGetAppidGroupListRes getAppidGroupList(ImGetAppidGroupListReq imGetAppidGroupListReq);

    /**
     * 创建群组
     * App 管理员可以通过该接口创建群组。
     * Owner_Account （选填）群主 ID，自动添加到群成员中。如果不填，群没有群主
     * Type （必填）群组形态
     * GroupId （选填）为了使得群组 ID 更加简单，便于记忆传播，腾讯云支持 App 在通过 REST API 创建群组时 自定义群组 ID
     * Name （必填）群名称，最长30字节，使用 UTF-8 编码，1个汉字占3个字节
     * Introduction （选填）群简介，最长240字节，使用 UTF-8 编码，1个汉字占3个字节
     * Notification （选填）群公告，最长300字节，使用 UTF-8 编码，1个汉字占3个字节
     * FaceUrl （选填）群头像 URL，最长100字节
     * MaxMemberCount （选填）最大群成员数量，缺省时的默认值：私有群是200，公开群是2000，聊天室是6000，音视频聊天室和在线成员广播大群无限制
     * ApplyJoinOption （选填）申请加群处理方式
     * AppDefinedData （选填）群组维度的自定义字段，默认情况是没有的，可以通过 即时通信 IM 控制台 进行配置
     * MemberList （选填）初始群成员列表，最多500个；成员信息字段详情请参阅 群成员资料
     * @author longpengZ
     * @return ImCreateGroupRes
     */
    ImCreateGroupRes createGroup(ImCreateGroupReq imCreateGroupReq);


    /**
     * 获取群详细资料
     * GroupIdList （必填）需要拉取的群组列表
     * ResponseFilter （选填）群组维度的自定义字段过滤器
     * @author longpengZ
     * @return ImGroupOpenHttpSvcRes
     */
    ImGetGroupInfoRes getGroupInfo(ImGetGroupInfoReq imGetGroupInfoReq);

    /**
     * 获取群成员详细资料
     * App 管理员可以根据群组 ID 获取群组成员的资料。
     * GroupId （必填）需要拉取成员信息的群组的 ID
     * GroupBaseInfoFilter （选填）基础信息字段过滤器，指定需要获取的基础信息字段
     * MemberInfoFilter （选填）成员信息字段过滤器，指定需要获取的成员信息字段
     * AppDefinedDataFilter_Group （选填）该字段用来群组维度的自定义字段过滤器，指定需要获取的群组维度的自定义字段，
     * AppDefinedDataFilter_GroupMember （选填）该字段用来群成员维度的自定义字段过滤器，指定需要获取的群成员维度的自定义字段
     * Limit （选填）一次最多获取多少个成员的资料，不得超过6000。如果不填，则获取群内全部成员的信息
     * Offset （选填）从第几个成员开始获取，如果不填则默认为0，表示从第一个成员开始获取
     * @author longpengZ
     * @return ImGetGroupMemberInfoRes
     */
    ImGetGroupMemberInfoRes getGroupMemberInfo(ImGetGroupMemberInfoReq imGetGroupMemberInfoReq);

    /**
     * 修改群基础资料
     * App 管理员可以通过该接口修改指定群组的基础信息。
     * GroupId （必填）为了使得群组 ID 更加简单，便于记忆传播，腾讯云支持 App 在通过 REST API 创建群组时 自定义群组 ID
     * Name （必填）群名称，最长30字节，使用 UTF-8 编码，1个汉字占3个字节
     * Introduction （选填）群简介，最长240字节，使用 UTF-8 编码，1个汉字占3个字节
     * Notification （选填）群公告，最长300字节，使用 UTF-8 编码，1个汉字占3个字节
     * FaceUrl （选填）群头像 URL，最长100字节
     * MaxMemberCount （选填）最大群成员数量，缺省时的默认值：私有群是200，公开群是2000，聊天室是6000，音视频聊天室和在线成员广播大群无限制
     * ApplyJoinOption （选填）申请加群处理方式
     * AppDefinedData （选填）群组维度的自定义字段，默认情况是没有的，可以通过 即时通信 IM 控制台 进行配置
     * MemberList （选填）初始群成员列表，最多500个；成员信息字段详情请参阅 群成员资料
     * ShutUpAllMember （选填）群内群成员禁言，只有群管理员和群主以及系统管理员可以发言
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse modifyGroupBaseInfo(ImCreateGroupReq imCreateGroupReq);

    /**
     * 增加群成员
     * App 管理员可以通过该接口向指定的群中添加新成员。
     * GroupId （必填）操作的群 ID
     * Silence （选填）是否静默加人。0：非静默加人；1：静默加人。不填该字段默认为0
     * MemberList （必填）待添加的群成员数组
     * @author longpengZ
     * @return ImAddGroupMemberRes
     */
    ImAddGroupMemberRes addGroupMember(ImAddGroupMemberReq imAddGroupMemberReq);
}
