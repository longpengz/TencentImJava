package com.longpengz.tencentim.service.singleChat;

import com.longpengz.tencentim.bean.enums.ForbidCallbackControlEnum;
import com.longpengz.tencentim.bean.modle.MsgBodyItem;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.singleChat.modle.*;

import java.util.List;

/**
 * @author longpengZ
 */
public interface SingleChatService {

    /**
     * 单发单聊消息：
     * 注：
     *  1.管理员向帐号发消息，接收方看到消息发送者是管理员。
     *  2.管理员指定某一帐号向其他帐号发消息，接收方看到发送者不是管理员，而是管理员指定的帐号。
     *  3.该接口不会检查发送者和接收者的好友关系（包括黑名单），同时不会检查接收者是否被禁言。
     * syncOtherMachine （选填）1：把消息同步到 From_Account 在线终端和漫游上 2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游
     * fromAccount （选填）消息发送方 UserID（用于指定发送消息方帐号）
     * toAccount （必填）消息接收方 UserID
     * msgLifeTime （选填）消息离线保存时长（单位：秒），最长为7天（604800秒）若设置该字段为0，则消息只发在线用户，不保存离线若设置该字段超过7天（604800秒），仍只保存7天若不设置该字段，则默认保存7天
     * msgRandom （必填）消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数
     * msgTimeStamp （选填）消息时间戳，UNIX 时间戳（单位：秒）
     * forbidCallbackControl （选填）消息回调禁止开关，只对本条消息有效
     * MsgBody （必填）消息内容
     * CloudCustomData （选填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）
     * OfflinePushInfo 暂未支持该参数
     * @author longpengZ
     * @return ImSingleChatSendMsgRes
     */
    ImSingleChatSendMsgRes sendMsg(ImSingleChatSendMsgReq imSingleChatSendMsgReq);


    /**
     * 批量发单聊消息
     * 注：
     *  1.支持一次对最多500个用户进行单发消息。
     *  2.与单发消息相比，该接口更适用于营销类消息、系统通知 tips 等时效性较强的消息。
     *  3.管理员指定某一帐号向目标帐号批量发消息，接收方看到发送者不是管理员，而是管理员指定的帐号。
     *  4.该接口不触发回调请求。
     *  5.该接口不会检查发送者和接收者的好友关系（包括黑名单），同时不会检查接收者是否被禁言。
     * SyncOtherMachine （选填）1：把消息同步到 From_Account 在线终端和漫游上 2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游
     * From_Account （选填）管理员指定消息发送方帐号（若需设置 From_Account 信息，则该参数取值不能为空）
     * To_Account （必填）消息接收方用户 UserID
     * MsgRandom （必填）消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数
     * msgBodyItem （必填）TIM 消息
     * CloudCustomData （必填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）
     * SendMsgControl （选填）消息发送控制选项，是一个 String 数组，只对本次请求有效。NoUnread表示该条消息不计入未读数。示例：SendMsgControl: [NoUnread]
     * @author longpengZ
     * @return ImSingleChatBatchSendMsgRes
     */
    ImSingleChatBatchSendMsgRes batchSendMsg(ImSingleChatBatchSendMsgReq imSingleChatBatchSendMsgReq);

    /**
     * 导入单聊消息
     * 注：
     *  1.导入历史单聊消息到即时通信 IM。
     *  2.平滑过渡期间，将原有即时通信实时单聊消息导入到即时通信 IM。
     *  3.该接口不会触发回调。
     *  4.该接口会根据 From_Account ， To_Account ， MsgRandom ， MsgTimeStamp 字段的值对导入的消息进行去重。仅当这四个字段的值都对应相同时，才判定消息是重复的，消息是否重复与消息内容本身无关。
     *  5.重复导入的消息不会覆盖之前已导入的消息（即消息内容以首次导入的为准）。
     * SyncFromOldSystem （必填）该字段只能填1或2，其他值是非法值 1表示实时消息导入，消息加入未读计数 2表示历史消息导入，消息不计入未读
     * From_Account （必填）消息发送方 UserID，用于指定发送消息方
     * To_Account （必填）消息接收方 UserID
     * MsgRandom （必填）消息随机数，由随机函数产生，后台会根据该字段去重，详细规则请看本接口的功能说明。
     * MsgTimeStamp （必填）消息时间戳，UNIX 时间戳，单位为秒。后台会根据该字段去重，详细规则请看本接口的功能说明。
     * MsgBody （必填）消息内容
     * CloudCustomData （选填）消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse importMsg(ImImportMsgReq imImportMsgReq);

    /**
     * 查询单聊消息
     * 注：
     *  1.管理员按照时间范围查询某单聊会话的消息记录。
     *  2.查询的单聊会话由请求中的 From_Account 和 To_Account 指定。查询结果包含会话双方互相发送的消息，具体每条消息的发送方和接收方由每条消息里的 From_Account 和 To_Account 指定。
     *  3.一般情况下，请求中的 From_Account 和 To_Account 字段值互换，查询结果不变。但通过 单发单聊消息 或 批量发单聊消息 接口发送的消息，如果指定 SyncOtherMachine 值为2，则需要指定正确的 From_Account 和 To_Account 字段值才能查询到该消息。
     *    例如，通过 单发单聊消息 接口指定帐号 A 给帐号 B 发一条消息，同时指定 SyncOtherMachine 值为2。则调用本接口时，From_Account 必须设置为帐号 B，To_Account 必须设置为帐号 A 才能查询到该消息。
     *  4.查询结果包含被撤回的消息，由消息里的 MsgFlagBits 字段标识。
     *  5.若想通过 REST API 撤回单聊消息 接口撤回某条消息，可先用本接口查询出该消息的 MsgKey，然后再调用撤回接口进行撤回。
     *  6.可查询的消息记录的时间范围取决于漫游消息存储时长，默认是7天。支持在控制台修改消息漫游时长，延长消息漫游时长是增值服务。具体请参考 漫游消息存储。
     *  7.若请求时间段内的消息总大小超过应答包体大小限制（目前为13K）时，则需要续拉。您可以通过应答中的 Complete 字段查看是否已拉取请求的全部消息。
     * From_Account （必填）会话其中一方的 UserID，若已指定发送消息方帐号，则为消息发送方
     * To_Account （必填）会话其中一方的 UserID
     * MaxCnt （必填）请求的消息条数
     * MinTime （必填）请求的消息时间范围的最小值
     * MaxTime （必填）请求的消息时间范围的最大值
     * LastMsgKey （选填）上一次拉取到的最后一条消息的 MsgKey，续拉时需要填该字段
     * @author longpengZ
     * @return ImAdminGetroamMsgRes
     */
    ImAdminGetroamMsgRes adminGetroamMsg(ImAdminGetroamMsgReq imAdminGetroamMsgReq);

    /**
     * 撤回单聊消息
     * 注：
     *  1.管理员撤回单聊消息。
     *  2.该接口可以撤回所有单聊消息，包括客户端发出的单聊消息，由 REST API 单发 和 批量发 接口发出的单聊消息。
     *  3.若需要撤回由客户端发出的单聊消息，您可以开通 发单聊消息之前回调 或 发单聊消息之后回调 ，通过该回调接口记录每条单聊消息的 MsgKey ，然后填在本接口的 MsgKey 字段进行撤回。您也可以通过 查询单聊消息 查询出待撤回的单聊消息的 MsgKey 后，填在本接口的 MsgKey 字段进行撤回。
     *  4.若需要撤回由 REST API 单发 和 批量发 接口发出的单聊消息，需要记录这些接口回包里的 MsgKey 字段以进行撤回。
     *  5.调用该接口撤回消息后，该条消息的离线、漫游存储，以及消息发送方和接收方的客户端的本地缓存都会被撤回。
     *  6.该接口可撤回的单聊消息没有时间限制，即可以撤回任何时间的单聊消息。
     * From_Account	（必填）消息发送方 UserID
     * To_Account （必填）消息接收方 UserID
     * MsgKey （必填）待撤回消息的唯一标识。该字段由 REST API 接口 单发单聊消息 和 批量发单聊消息 返回
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse adminMsgWithdraw(ImAdminMsgWithdrawReq adminMsgWithdrawReq);

    /**
     * 设置单聊消息已读
     * 注：
     *  设置用户的某个单聊会话的消息全部已读。
     * Report_Account （必填）进行消息已读的用户 UserId
     * Peer_Account （必填）进行消息已读的单聊会话的另一方用户 UserId
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse adminSetMsgRead(ImAdminSetMsgReadReq imAdminSetMsgReadReq);

    /**
     * 查询单聊未读消息计数
     * 注：
     *  App 后台可以通过该接口查询特定账号的单聊总未读数（包含所有的单聊会话）或者单个单聊会话的未读数。
     * To_Account （必填）待查询的用户 UserId
     * Peer_Account	（选填）待查询的单聊会话对端的用户 UserId 1.若要查询单个会话的未读数，该字段必填 2.该数组最大大小为10
     * @author longpengZ
     * @return ImGetC2CUnreadMsgNumRes
     */
    ImGetC2CUnreadMsgNumRes getC2CUnreadMsgNum(ImGetC2CUnreadMsgNumReq imGetC2CUnreadMsgNumReq);
}
