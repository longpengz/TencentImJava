package com.longpengz.tencentim.service.recentContacts;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.recentContacts.request.ImRecentContactsDeleteReq;
import com.longpengz.tencentim.service.recentContacts.request.ImRecentContactsGetListReq;
import com.longpengz.tencentim.service.recentContacts.response.ImRecentContactsGetListRes;
import com.longpengz.tencentim.service.singleChat.response.ImSingleChatSendMsgRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author longpengZ
 */
@Slf4j
public class RecentContactsServiceImpl extends ImBaseService implements RecentContactsService {

    private final String url = "/v4/recentcontact";
    private final String getListUrl = "/get_list";
    private final String deleteUrl = "/delete";


    @Override
    public ImRecentContactsGetListRes getList(ImRecentContactsGetListReq imRecentContactsGetListReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getListUrl + "?"),
                gson.toJson(imRecentContactsGetListReq));
        log.info("IM拉取会话列表结果："+body);
        return gson.fromJson(body, ImRecentContactsGetListRes.class);
    }

    @Override
    public ImResponse delete(ImRecentContactsDeleteReq imRecentContactsDeleteReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + deleteUrl + "?"),
                gson.toJson(imRecentContactsDeleteReq));
        log.info("IM删除单个会话结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }
}
