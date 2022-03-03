package com.longpengz.tencentim.service.openconfigsvr;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.openconfigsvr.model.ImGetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.model.ImGetnospeakingRes;
import com.longpengz.tencentim.service.openconfigsvr.model.ImSetnospeakingReq;

/**
 * @author longpengZ
 * IM全局禁言管理接口相关接口
 */
public interface OpenconfigsvrService {

    /**
     * 设置全局禁言
     *  1.全局禁言包括单聊消息全局禁言和群组消息全局禁言。
     *  2.如果帐号被设置单聊消息全局禁言，在单聊消息禁言时间未到期时间内，所有的单聊消息发送失败，发送者接收到错误码20012（详见 错误码），
     *  不会触发 发单聊消息之前回调；禁言时间到期后即时通信 IM 后台自动解除单聊消息禁言，解除后所有单聊消息就能发送正常；对于永久单聊消息全局禁言，
     *  全局单聊消息禁言时间一直不过期；帐号默认未设置单聊消息全局禁言。
     *  3.如果帐号被设置群组消息全局禁言，在群组消息禁言时间内所有的群组消息发送失败，发送者接收到错误码10017（详见 错误码），
     *  不会触发 群内发言之前回调；禁言时间到期后即时通信 IM 后台自动解除群组消息禁言，解除后所有群组消息就能发送正常；对于永久群组消息全局禁言，
     *  全局群组消息禁言时间一直不过期。帐号默认未设置群组消息全局禁言。
     * Set_Account （必填）设置禁言配置的帐号
     * C2CmsgNospeakingTime （选填）单聊消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）0表示取消该帐号的单聊消息禁言4294967295表示该帐号被设置永久禁言其它值表示该帐号具体的禁言时间
     * GroupmsgNospeakingTime （选填）群组消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）0表示取消该帐号的群组消息禁言4294967295表示该帐号被设置永久禁言其它值表示该帐号的具体禁言时间
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse setnospeaking(ImSetnospeakingReq imSetnospeakingReq);

    /**
     * 查询全局禁言
     *  1.全局禁言包括单聊消息全局禁言和群组消息全局禁言。
     *  2.帐号默认未设置单聊消息全局禁言；如果帐号被设置单聊消息全局禁言，在单聊消息禁言时间未到期时间内所有的单聊消息发送失败，到期后即时通信 IM 后台自动解除单聊消息禁言，解除后所有单聊消息就能发送正常；对于永久全局单聊禁言，全局单聊消息禁言时间一直不过期。
     *  3.帐号默认未设置群组消息全局禁言。如果帐号被设置群组消息全局禁言，在群组消息禁言时间内所有的群组消息发送失败，到期后即时通信 IM 后台自动解除群组消息禁言，解除后所有群组消息就能发送正常；对于永久全局群组消息禁言，全局群组消息禁言时间一直不过期。
     * Get_Account （必填）查询禁言信息的帐号
     * @author longpengZ
     */
    ImGetnospeakingRes getnospeaking(ImGetnospeakingReq imGetnospeakingReq);
}
