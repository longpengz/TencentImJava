package com.longpengz.tencentim.service.profile;

import com.google.gson.Gson;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.profile.request.ImPortraitGetReq;
import com.longpengz.tencentim.service.profile.response.ImPortraitGetRes;
import com.longpengz.tencentim.service.profile.request.ImPortraitSetReq;
import com.longpengz.tencentim.util.HttpClient;
import com.longpengz.tencentim.util.RestTemplateHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author longpengZ
 */
@Slf4j
public class ProfileServiceImpl extends ImBaseService implements ProfileService {


    private final String url = "/v4/profile";
    private final String portraitSetUrl = "/portrait_set";
    private final String portraitGetUrl = "/portrait_get";


    @Override
    public ImResponse portraitSet(ImPortraitSetReq imPortraitSetReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + portraitSetUrl + "?"),
                gson.toJson(imPortraitSetReq));
        log.info("IM设置资料结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImPortraitGetRes portraitGet(ImPortraitGetReq imPortraitGetReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + portraitGetUrl + "?"),
                gson.toJson(imPortraitGetReq));
        log.info("IM拉取资料结果："+body);
        return gson.fromJson(body, ImPortraitGetRes.class);
    }
}
