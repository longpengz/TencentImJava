package com.longpengz.tencentim.service.singleChat;

import com.longpengz.tencentim.bean.enums.ForbidCallbackControlEnum;
import com.longpengz.tencentim.bean.modle.MsgBodyItem;
import com.longpengz.tencentim.service.singleChat.modle.ImSingleChatSendMsgReq;
import com.longpengz.tencentim.service.singleChat.modle.ImSingleChatSendMsgRes;

import java.util.List;

/**
 * @author longpengZ
 */
public interface SingleChatService {

    /**
     * 单发单聊消息
     * syncOtherMachine （选填）1：把消息同步到 From_Account 在线终端和漫游上 2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游
     * fromAccount （选填）消息发送方 UserID（用于指定发送消息方帐号）
     * toAccount （必填）消息接收方 UserID
     * msgLifeTime （选填）消息离线保存时长（单位：秒），最长为7天（604800秒）若设置该字段为0，则消息只发在线用户，不保存离线若设置该字段超过7天（604800秒），仍只保存7天若不设置该字段，则默认保存7天
     * msgRandom （必填）消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数
     * msgTimeStamp （选填）消息时间戳，UNIX 时间戳（单位：秒）
     * forbidCallbackControl （选填）消息回调禁止开关，只对本条消息有效
     * MsgBody （必填）消息内容
     * @author longpengZ
     * @return ImSingleChatSendMsgRes
     */
    ImSingleChatSendMsgRes sendMsg(ImSingleChatSendMsgReq imSingleChatSendMsgReq);





}
