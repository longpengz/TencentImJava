package com.longpengz.tencentim.service.recentContacts;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.recentContacts.request.ImRecentContactsDeleteReq;
import com.longpengz.tencentim.service.recentContacts.request.ImRecentContactsGetListReq;
import com.longpengz.tencentim.service.recentContacts.response.ImRecentContactsGetListRes;

/**
 * @author longpengZ
 * IM最近联系人相关接口
 */
public interface RecentContactsService {

    /**
     * 拉取会话列表
     * 支持分页拉取会话列表。
     * From_Account	（必填）填 UserID，请求拉取该用户的会话列表
     * TimeStamp （必填）普通会话的起始时间，第一页填 0
     * StartIndex （必填）普通会话的起始位置，第一页填 0
     * TopTimeStamp	（必填）置顶会话的起始时间，第一页填 0
     * TopStartIndex （必填）置顶会话的起始位置，第一页填 0
     * AssistFlags （必填）会话辅助标志位:bit 0 - 是否支持置顶会话 bit 1 - 是否返回空会话 bit 2 - 是否支持置顶会话分页
     * @author longpengZ
     * @return ImRecentContactsGetListRes
     */
    ImRecentContactsGetListRes getList(ImRecentContactsGetListReq imRecentContactsGetListReq);

    /**
     * 删除单个会话
     * 删除指定会话，支持同步清理漫游消息。
     * From_Account	（必填）请求删除该 UserID 的会话
     * Type	（必填）会话类型：1 表示 C2C 会话；2 表示 G2C 会话
     * To_Account （选填）C2C 会话才赋值，C2C 会话方的 UserID
     * ToGroupid （选填）G2C 会话才赋值，G2C 会话的群 ID
     * ClearRamble （选填）是否清理漫游消息：1 表示清理漫游消息；0 表示不清理漫游消息
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse delete(ImRecentContactsDeleteReq imRecentContactsDeleteReq);
}
