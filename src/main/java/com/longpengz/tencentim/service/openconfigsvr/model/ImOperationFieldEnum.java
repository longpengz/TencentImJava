package com.longpengz.tencentim.service.openconfigsvr.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "IM运营数据字段")
public enum ImOperationFieldEnum {
    /**
     * 应用名称
     */
    AppName,
    /**
     * 应用 SDKAppID
     */
    AppId,
    /**
     * 所属客户名称
     */
    Company,
    /**
     * 活跃用户数
     */
    ActiveUserNum,
    /**
     * 新增注册人数
     */
    RegistUserNumOneDay,
    /**
     * 累计注册人数
     */
    RegistUserNumTotal,
    /**
     * 登录次数
     */
    LoginTimes,
    /**
     * 登录人数
     */
    LoginUserNum,
    /**
     * 上行消息数
     */
    UpMsgNum,
    /**
     * 发消息人数
     */
    SendMsgUserNum,
    /**
     * APNs 推送数
     */
    APNSMsgNum,
    /**
     * 上行消息数（C2C）
     */
    C2CUpMsgNum,
    /**
     * 下行消息数（C2C）
     */
    C2CDownMsgNum,
    /**
     * 发消息人数（C2C）
     */
    C2CSendMsgUserNum,
    /**
     * APNs 推送数（C2C）
     */
    C2CAPNSMsgNum,
    /**
     * 最高在线人数
     */
    MaxOnlineNum,
    /**
     * 下行消息总数（C2C和群）
     */
    DownMsgNum,
    /**
     * 关系链对数增加量
     */
    ChainIncrease,
    /**
     * 关系链对数删除量
     */
    ChainDecrease,
    /**
     * 上行消息数（群）
     */
    GroupUpMsgNum,
    /**
     * 下行消息数（群）
     */
    GroupDownMsgNum,
    /**
     * 发消息人数（群）
     */
    GroupSendMsgUserNum,
    /**
     * APNs 推送数（群）
     */
    GroupAPNSMsgNum,
    /**
     * 发消息群组数
     */
    GroupSendMsgGroupNum,
    /**
     * 入群总数
     */
    GroupJoinGroupTimes,
    /**
     * 退群总数
     */
    GroupQuitGroupTimes,
    /**
     * 新增群组数
     */
    GroupNewGroupNum,
    /**
     * 累计群组数
     */
    GroupAllGroupNum,
    /**
     * 解散群个数
     */
    GroupDestroyGroupNum,
    /**
     * 回调请求数
     */
    CallBackReq,
    /**
     * 回调应答数
     */
    CallBackRsp,
    /**
     * 日期
     */
    Date
}
