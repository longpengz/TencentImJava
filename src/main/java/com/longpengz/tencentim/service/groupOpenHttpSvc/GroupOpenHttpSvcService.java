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

    /**
     * 删除群成员
     * App 管理员可以通过该接口删除群成员。
     * GroupId （必填）操作的群 ID
     * Silence （选填）是否静默删人。0表示非静默删人，1表示静默删人。静默即删除成员时不通知群里所有成员，只通知被删除群成员。不填写该字段时默认为0
     * Reason （选填）踢出用户原因
     * MemberToDel_Account（必填）待删除的群成员
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse deleteGroupMember(ImDeleteGroupMemberReq imDeleteGroupMemberReq);

    /**
     * 修改群成员资料
     * App 管理员可以通过该接口修改群成员资料。
     * GroupId （必填）操作的群 ID
     * Member_Account （必填）要操作的群成员
     * Role （选填）成员身份，Admin/Member 分别为设置/取消管理员
     * MsgFlag （选填）消息屏蔽类型
     * NameCard （选填）群名片（最大不超过50个字节）
     * AppMemberDefinedData （选填）群成员维度的自定义字段，默认情况是没有的，可以通过 即时通信 IM 控制台 进行配置，详情请参阅 群组系统
     * ShutUpTime （选填）需禁言时间，单位为秒，0表示取消禁言
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse modifyGroupMemberInfo(ImModifyGroupMemberInfoReq imModifyGroupMemberInfoReq);

    /**
     * 解散群组
     * App 管理员通过该接口解散群。
     * GroupId （必填）操作的群 ID
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse destroyGroup(ImDestroyGroupReq imDestroyGroupReq);

    /**
     * 获取用户所加入的群组
     * App 管理员可以通过本接口获取某一用户加入的群信息。默认不获取用户已加入但未激活好友工作群（Work）以及直播群（AVChatRoom）群信息。
     * Member_Account （必填）需要查询的用户帐号
     * WithHugeGroups （必填）是否获取用户加入的 AVChatRoom(直播群)，0表示不获取，1表示获取。默认为0
     * WithNoActiveGroups （选填）是否获取用户已加入但未激活的 Private（即新版本中 Work，好友工作群) 群信息，0表示不获取，1表示获取。默认为0
     * Limit （选填）单次拉取的群组数量，如果不填代表所有群组
     * Offset （选填）从第多少个群组开始拉取
     * GroupType （选填）拉取哪种群组类型，例如 Public(陌生人社交群)，Private（即新版本Work，好友工作群)，ChatRoom （即新版本Meeting，会议群），AVChatRoom(直播群)，Community（社群），不填为拉取所有
     * ResponseFilter （选填）分别包含 GroupBaseInfoFilter 和 SelfInfoFilter 两个过滤器； GroupBaseInfoFilter 表示需要拉取哪些基础信息字段，详情请参阅 群组系统；SelfInfoFilter 表示需要拉取用户在每个群组中的哪些个人资料 。
     * @author longpengZ
     * @return ImGetJoinedGroupListRes
     */
    ImGetJoinedGroupListRes getJoinedGroupList(ImGetJoinedGroupListReq imGetJoinedGroupListReq);

    /**
     * 查询用户在群组中的身份
     * App 管理员可以通过该接口获取一批用户在群内的身份，即“成员角色”。
     * GroupId （必填）需要查询的群组 ID
     * User_Account （必填）表示需要查询的用户帐号，最多支持500个帐号
     * @author longpengZ
     * @return ImGetRoleInGroupRes
     */
    ImGetRoleInGroupRes getRoleInGroup(ImGetRoleInGroupReq imGetRoleInGroupReq);

    /**
     * 批量禁言和取消禁言
     *  1.App 管理员禁止指定群组中某些用户在一段时间内发言。
     *  2.App 管理员取消对某些用户的禁言。
     *  3.被禁言用户退出群组之后再进入同一群组，禁言仍然有效。
     * GroupId （必填）需要查询的群组 ID
     * Members_Account （必填）需要禁言的用户帐号，最多支持500个帐号
     * ShutUpTime （必填）需禁言时间，单位为秒，为0时表示取消禁言，4294967295为永久禁言。
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse forbidSendMsg(ImForbidSendMsgReq imForbidSendMsgReq);

    /**
     * 获取被禁言群成员列表
     * App 管理员可以根据群组 ID 获取群组中被禁言的用户列表。
     * GroupId （必填）需要查询的群组 ID
     * @author longpengZ
     * @return ImGetGroupShuttedUinRes
     */
    ImGetGroupShuttedUinRes getGroupShuttedUin(ImGetGroupShuttedUinReq imGetGroupShuttedUinReq);

    /**
     * 在群组中发送普通消息
     * App 管理员可以通过该接口在群组中发送普通消息。
     * GroupId （必填）向哪个群组发送消息
     * Random （必填）无符号32位整数。如果5分钟内两条消息的随机值相同，后一条消息将被当做重复消息而丢弃
     * MsgPriority （选填）消息的优先级
     * MsgBody （必填）消息体，详细可参阅 消息格式描述
     * From_Account （选填）消息来源帐号，选填。如果不填写该字段，则默认消息的发送者为调用该接口时使用的 App 管理员帐号。除此之外，App 亦可通过该字段“伪造”消息的发送者，从而实现一些特殊的功能需求。需要注意的是，如果指定该字段，必须要确保字段中的帐号是存在的
     * OfflinePushInfo （选填）离线推送信息配置，详细可参阅 消息格式描述
     * ForbidCallbackControl （选填）消息回调禁止开关，只对单条消息有效，ForbidBeforeSendMsgCallback 表示禁止发消息前回调，ForbidAfterSendMsgCallback 表示禁止发消息后回调
     * OnlineOnlyFlag （选填）1表示消息仅发送在线成员，默认0表示发送所有成员，AVChatRoom(直播群)不支持该参数
     * SendMsgControl （选填）消息发送权限，NoLastMsg 只对单条消息有效，表示不更新最近联系人会话；NoUnread 不计未读，只对单条消息有效。（如果该消息 OnlineOnlyFlag 设置为1，则不允许使用该字段。）
     * CloudCustomData （选填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）
     * @author longpengZ
     * @return ImSendGroupMsgRes
     */
    ImSendGroupMsgRes sendGroupMsg(ImSendGroupMsgReq imSendGroupMsgReq);

    /**
     * 在群组中发送系统通知
     * App 管理员可以通过该接口在群组中发送系统通知。
     * GroupId （必填）向哪个群组发送系统通知
     * ToMembers_Account （选填）接收者群成员列表，请填写接收者 UserID，不填或为空表示全员下发
     * Content （必填）系统通知的内容
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse sendGroupSystemNotification(ImSendGroupSystemNotificationReq imSendGroupSystemNotificationReq);

    /**
     * 转让群主
     *  1.App 管理员可以通过该接口将群主身份转移给他人。
     *  2.没有群主的群，App 管理员可以通过此接口指定他人作为群主。
     *  3.新群主必须为群内成员。
     * GroupId （必填）要被转移的群组 ID
     * NewOwner_Account （必填）新群主 ID
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse changeGroupOwner(ImChangeGroupOwnerReq imChangeGroupOwnerReq);

    /**
     * 撤回群消息
     * App 管理员通过该接口撤回指定群组的消息，消息需要在漫游有效期以内。
     * GroupId （必填）操作的群 ID
     * MsgSeqList （必填）被撤回的消息 seq 列表，一次请求最多可以撤回10条消息 seq
     * @author longpengZ
     * @return ImGroupMsgRecallRes
     */
    ImGroupMsgRecallRes groupMsgRecall(ImGroupMsgRecallReq imGroupMsgRecallReq);

    /**
     * 导入群基础资料
     * App 管理员可以通过该接口导入群组，不会触发回调、不会下发通知；当 App 需要从其他即时通信系统迁移到即时通信 IM 时，使用该协议导入存量群组数据。
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
     * createTime （选填）群组的创建时间
     * @author longpengZ
     * @return ImCreateGroupRes
     */
    ImCreateGroupRes importGroup(ImCreateGroupReq imCreateGroupReq);

    /**
     * 导入群消息
     *  1.该 API 接口的作用是导入群组的消息，不会触发回调、不会下发通知。
     *  2.当 App 需要从其他即时通信系统迁移到即时通信 IM 时，使用该协议导入存量群消息数据。
     * GroupId （必填）要导入消息的群 ID
     * RecentContactFlag （选填）会话更新识别，为1的时候标识触发会话更新，默认不触发（avchatroom 群不支持）。
     * MsgList （必填）导入的消息列表
     * @author longpengZ
     * @return ImImportGroupMsgRes
     */
    ImImportGroupMsgRes importGroupMsg(ImImportGroupMsgReq imImportGroupMsgReq);

    /**
     * 导入群成员
     *  1.该 API 接口的作用是导入群组成员，不会触发回调、不会下发通知。
     *  2.当 App 需要从其他即时通信系统迁移到即时通信 IM 时，使用该协议导入存量群成员数据。
     * GroupId （必填）操作的群 ID
     * MemberList （必填）待添加的群成员数组
     * @author longpengZ
     * @return ImImportGroupMemberRes
     */
    ImImportGroupMemberRes importGroupMember(ImImportGroupMemberReq imImportGroupMemberReq);

    /**
     * 设置成员未读消息计数
     *  1.App 管理员使用该接口设置群组成员未读消息数，不会触发回调、不会下发通知。
     *  2.当 App 需要从其他即时通信系统迁移到即时通信 IM 时，使用该协议设置群成员的未读消息计数。
     * GroupId （必填）操作的群 ID
     * Member_Account （必填）要操作的群成员
     * UnreadMsgNum （必填）成员未读消息数
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse setUnreadMsgNum(ImSetUnreadMsgNumReq imSetUnreadMsgNumReq);

    /**
     * 删除指定用户发送的消息
     * 该 API 接口的作用是撤回最近1000条消息中指定用户发送的消息。
     * GroupId （必填）要撤回消息的群 ID
     * Sender_Account （必填）被撤回消息的发送者 ID
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse deleteGroupMsgBySender(ImDeleteGroupMsgBySenderReq imDeleteGroupMsgBySenderReq);

    /**
     * 拉取群历史消息
     * App 管理员可以通过该接口拉取群组的历史消息。
     * GroupId （必填）要拉取历史消息的群组 ID
     * ReqMsgNumber （必填）拉取的历史消息的条数，目前一次请求最多返回20条历史消息，所以这里最好小于等于20
     * ReqMsgSeq （选填）拉取消息的最大 seq
     * WithRecalledMsg （选填）是否带撤回的消息，填1表明需要拉取撤回后的消息；默认不拉取撤回后的消息
     * @author longpengZ
     * @return ImGroupMsgGetSimpleRes
     */
    ImGroupMsgGetSimpleRes groupMsgGetSimple(ImGroupMsgGetSimpleReq imGroupMsgGetSimpleReq);

    /**
     * 获取直播群在线人数
     * App 管理员可以根据群组 ID 获取直播群在线人数。
     * GroupId （必填）操作的群 ID
     * @author longpengZ
     * @return ImGetOnlineMemberNumRes
     */
    ImGetOnlineMemberNumRes getOnlineMemberNum(ImGetOnlineMemberNumReq imGetOnlineMemberNumReq);

    /**
     * 获取群自定义属性
     * App 管理员可以通过该接口获取群自定义属性。
     * GroupId （必填）获取自定义属性的群id
     * @author longpengZ
     * @return ImGetGroupAttrRes
     */
    ImGetGroupAttrRes getGroupAttr(ImGetGroupAttrReq imGetGroupAttrReq);

    /**
     * 修改群自定义属性
     * App 管理员可以通过该接口修改群自定义属性
     * GroupId （必填）修改自定义属性的群id
     * GroupAttr （必填）自定义属性列表，key 为自定义属性的键，value 为自定义属性的值
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse modifyGroupAttr(ImModifyGroupAttrReq imModifyGroupAttrReq);

    /**
     * 清空群自定义属性
     * App 管理员可以通过该接口清空群自定义属性
     * GroupId （必填）清空自定义属性的群 id
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse clearGroupAttr(ImClearGroupAttrReq imClearGroupAttrReq);

    /**
     * 重置群自定义属性
     * App 管理员可以通过该接口重置群自定义属性
     * GroupId （必填）修改自定义属性的群id
     * GroupAttr （必填）自定义属性列表，key 为自定义属性的键，value 为自定义属性的值
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse setGroupAttr(ImModifyGroupAttrReq imModifyGroupAttrReq);
}
