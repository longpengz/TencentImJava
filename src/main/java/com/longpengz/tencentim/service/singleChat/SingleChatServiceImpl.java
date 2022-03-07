package com.longpengz.tencentim.service.singleChat;

import com.google.gson.Gson;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.singleChat.request.*;
import com.longpengz.tencentim.service.singleChat.response.ImAdminGetroamMsgRes;
import com.longpengz.tencentim.service.singleChat.response.ImGetC2CUnreadMsgNumRes;
import com.longpengz.tencentim.service.singleChat.response.ImSingleChatBatchSendMsgRes;
import com.longpengz.tencentim.service.singleChat.response.ImSingleChatSendMsgRes;
import com.longpengz.tencentim.util.HttpClient;
import com.longpengz.tencentim.util.RestTemplateHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author longpengZ
 */
@Slf4j
public class SingleChatServiceImpl extends ImBaseService implements SingleChatService {

    private final String url = "/v4/openim";
    private final String sendMsgUrl = "/sendmsg";
    private final String batchSendMsgUrl = "/batchsendmsg";
    private final String importMsgUrl = "/importmsg";
    private final String adminGetroamMsgUrl = "/admin_getroammsg";
    private final String adminMsgWithdrawUrl = "/admin_msgwithdraw";
    private final String adminSetMsgReadUrl = "/admin_set_msg_read";
    private final String getC2CUnreadMsgNumUrl = "/get_c2c_unread_msg_num";

    @Override
    public ImSingleChatSendMsgRes sendMsg(ImSingleChatSendMsgReq imSingleChatSendMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + sendMsgUrl + "?"),
                gson.toJson(imSingleChatSendMsgReq));
        log.info("IM单发单聊消息结果："+body);
        return gson.fromJson(body,ImSingleChatSendMsgRes.class);
    }

    @Override
    public ImSingleChatBatchSendMsgRes batchSendMsg(ImSingleChatBatchSendMsgReq imSingleChatBatchSendMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + batchSendMsgUrl + "?"),
                gson.toJson(imSingleChatBatchSendMsgReq));
        log.info("IM批量发单聊消息结果："+body);
        return gson.fromJson(body,ImSingleChatBatchSendMsgRes.class);
    }

    @Override
    public ImResponse importMsg(ImImportMsgReq imImportMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + importMsgUrl + "?"),
                gson.toJson(imImportMsgReq));
        log.info("IM导入单聊消息结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImAdminGetroamMsgRes adminGetroamMsg(ImAdminGetroamMsgReq imAdminGetroamMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + adminGetroamMsgUrl + "?"),
                gson.toJson(imAdminGetroamMsgReq));
        log.info("IM查询单聊消息结果："+body);
        return gson.fromJson(body,ImAdminGetroamMsgRes.class);
    }

    @Override
    public ImResponse adminMsgWithdraw(ImAdminMsgWithdrawReq adminMsgWithdrawReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + adminMsgWithdrawUrl + "?"),
                gson.toJson(adminMsgWithdrawReq));
        log.info("IM撤回单聊消息结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImResponse adminSetMsgRead(ImAdminSetMsgReadReq imAdminSetMsgReadReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + adminSetMsgReadUrl + "?"),
                gson.toJson(imAdminSetMsgReadReq));
        log.info("IM设置单聊消息已读结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImGetC2CUnreadMsgNumRes getC2CUnreadMsgNum(ImGetC2CUnreadMsgNumReq imGetC2CUnreadMsgNumReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getC2CUnreadMsgNumUrl + "?"),
                gson.toJson(imGetC2CUnreadMsgNumReq));
        log.info("IM查询单聊未读消息计数结果："+body);
        return gson.fromJson(body,ImGetC2CUnreadMsgNumRes.class);
    }
}
