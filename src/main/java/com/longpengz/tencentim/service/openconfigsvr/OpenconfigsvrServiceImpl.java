package com.longpengz.tencentim.service.openconfigsvr;

import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.openconfigsvr.request.ImGetHistoryReq;
import com.longpengz.tencentim.service.openconfigsvr.request.ImGetappinfoReq;
import com.longpengz.tencentim.service.openconfigsvr.request.ImGetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.request.ImSetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetHistoryRes;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetIPListRes;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetappinfoRes;
import com.longpengz.tencentim.service.openconfigsvr.response.ImGetnospeakingRes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenconfigsvrServiceImpl extends ImBaseService implements OpenconfigsvrService {

    private final String url = "/v4/openconfigsvr";
    private final String setnospeakingUrl = "/setnospeaking";
    private final String getnospeakingUrl = "/getnospeaking";
    private final String getappinfoUrl = "/getappinfo";
    private final String getHistoryUrl = "/v4/open_msg_svc/get_history";
    private final String getIPListUrl = "/v4/ConfigSvc/GetIPList";



    @Override
    public ImResponse setnospeaking(ImSetnospeakingReq imSetnospeakingReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + setnospeakingUrl + "?"),
                gson.toJson(imSetnospeakingReq));
        log.debug("IM设置全局禁言结果："+body);
        ImResponse imResponse = gson.fromJson(body, ImResponse.class);
        imResponse.setActionStatus(imResponse.getErrorCode().equals(0) ? ActionStatusEnum.OK:ActionStatusEnum.FAIL);
        return imResponse;
    }

    @Override
    public ImGetnospeakingRes getnospeaking(ImGetnospeakingReq imGetnospeakingReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getnospeakingUrl + "?"),
                gson.toJson(imGetnospeakingReq));
        log.debug("IM查询全局禁言结果："+body);
        ImGetnospeakingRes imGetnospeakingRes = gson.fromJson(body, ImGetnospeakingRes.class);
        imGetnospeakingRes.setActionStatus(imGetnospeakingRes.getErrorCode().equals(0) ? ActionStatusEnum.OK:ActionStatusEnum.FAIL);
        return imGetnospeakingRes;
    }

    @Override
    public ImGetappinfoRes getappinfo(ImGetappinfoReq imGetappinfoReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getappinfoUrl + "?"),
                gson.toJson(imGetappinfoReq));
        log.debug("IM拉取运营数据结果："+body);
        ImGetappinfoRes imGetappinfoRes = gson.fromJson(body, ImGetappinfoRes.class);
        imGetappinfoRes.setActionStatus(imGetappinfoRes.getErrorCode().equals(0) ? ActionStatusEnum.OK:ActionStatusEnum.FAIL);
        return imGetappinfoRes;
    }

    @Override
    public ImGetHistoryRes getHistory(ImGetHistoryReq imGetHistoryReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", getHistoryUrl + "?"),
                gson.toJson(imGetHistoryReq));
        log.debug("IM下载最近消息记录结果："+body);
        return gson.fromJson(body, ImGetHistoryRes.class);
    }

    @Override
    public ImGetIPListRes getIPList() {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", getIPListUrl + "?"),
                "");
        log.debug("IM获取服务器IP地址结果："+body);
        ImGetIPListRes imGetIPListRes = gson.fromJson(body, ImGetIPListRes.class);
        imGetIPListRes.setActionStatus(imGetIPListRes.getErrorCode().equals(0) ? ActionStatusEnum.OK:ActionStatusEnum.FAIL);
        return imGetIPListRes;
    }
}
