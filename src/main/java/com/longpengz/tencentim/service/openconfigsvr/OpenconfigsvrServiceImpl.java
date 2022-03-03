package com.longpengz.tencentim.service.openconfigsvr;

import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.openconfigsvr.model.ImGetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.model.ImGetnospeakingRes;
import com.longpengz.tencentim.service.openconfigsvr.model.ImSetnospeakingReq;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenconfigsvrServiceImpl extends ImBaseService implements OpenconfigsvrService {

    private final String url = "/v4/openconfigsvr";
    private final String setnospeakingUrl = "/setnospeaking";
    private final String getnospeakingUrl = "/getnospeaking";


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
}
