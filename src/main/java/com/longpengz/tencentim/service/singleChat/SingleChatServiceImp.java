package com.longpengz.tencentim.service.singleChat;

import com.google.gson.Gson;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.BaseService;
import com.longpengz.tencentim.service.singleChat.modle.*;
import com.longpengz.tencentim.util.HttpClient;
import com.longpengz.tencentim.util.RestTemplateHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author longpengZ
 */
@Slf4j
public class SingleChatServiceImp extends BaseService implements SingleChatService {

    private final HttpClient httpClient = new RestTemplateHttpClient();

    private final Gson gson = new Gson();

    private final String url="/v4/openim";

    private final String sendMsgUrl="/sendmsg";

    @Override
    public ImSingleChatSendMsgRes sendMsg(ImSingleChatSendMsgReq imSingleChatSendMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + sendMsgUrl + "?"),
                gson.toJson(imSingleChatSendMsgReq));
        log.debug("IM导入单个账号结果："+body);
        return gson.fromJson(body,ImSingleChatSendMsgRes.class);
    }

    @Override
    public ImSingleChatBatchSendMsgRes batchSendMsg(ImSingleChatBatchSendMsgReq imSingleChatBatchSendMsgReq) {
        return null;
    }

    @Override
    public ImResponse importMsg(ImImportMsgReq imImportMsgReq) {
        return null;
    }

    @Override
    public ImAdminGetroamMsgRes adminGetroamMsg(ImAdminGetroamMsgReq imAdminGetroamMsgReq) {
        return null;
    }

    @Override
    public ImResponse adminMsgWithdraw(ImAdminMsgWithdrawReq adminMsgWithdrawReq) {
        return null;
    }

    @Override
    public ImResponse adminSetMsgRead(ImAdminSetMsgReadReq imAdminSetMsgReadReq) {
        return null;
    }

    @Override
    public ImGetC2CUnreadMsgNumRes getC2CUnreadMsgNum(ImGetC2CUnreadMsgNumReq imGetC2CUnreadMsgNumReq) {
        return null;
    }
}
