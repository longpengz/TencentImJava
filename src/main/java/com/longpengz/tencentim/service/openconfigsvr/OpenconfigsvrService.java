package com.longpengz.tencentim.service.openconfigsvr;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.openconfigsvr.request.ImGetHistoryReq;
import com.longpengz.tencentim.service.openconfigsvr.request.ImGetappinfoReq;
import com.longpengz.tencentim.service.openconfigsvr.request.ImGetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.request.ImSetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetHistoryRes;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetIPListRes;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetappinfoRes;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetnospeakingRes;

/**
 * @author longpengZ
 * IM全局禁言管理接口、运营管理相关接口
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

    /**
     * 拉取运营数据
     * App 管理员可以通过该接口拉取最近30天的运营数据
     * RequestField （选填）该字段用来指定需要拉取的运营数据，不填默认拉取所有字段。
     * @author longpengZ
     * @return ImGetappinfoRes
     */
    ImGetappinfoRes getappinfo(ImGetappinfoReq imGetappinfoReq);

    /**
     * 下载最近消息记录
     * App 管理员可以通过该接口获取 App 中最近7天中某天某小时的所有单发或群组消息记录的下载地址。
     * ChatType （必填）消息类型，C2C 表示单发消息 Group 表示群组消息
     * MsgTime （必填）需要下载的消息记录的时间段，2015120121表示获取2015年12月1日21:00 - 21:59的消息的下载地址。该字段需精确到小时。每次请求只能获取某天某小时的所有单发或群组消息记录
     * @author longpengZ
     * @return ImGetHistoryRes
     */
    ImGetHistoryRes getHistory(ImGetHistoryReq imGetHistoryReq);

    /**
     * 获取服务器IP地址
     * 基于安全等考虑，您可能需要获知服务器的 IP 地址列表，以便进行相关限制。App 管理员可以通过该接口获得 SDK、第三方回调所使用到的服务器 IP 地址列表或 IP 网段信息。
     * @author longpengZ
     * @return ImGetIPListRes
     */
    ImGetIPListRes getIPList();
}
