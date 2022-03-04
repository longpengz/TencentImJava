package com.longpengz.tencentim.service.sns;

import com.google.gson.Gson;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.sns.modle.*;
import com.longpengz.tencentim.util.HttpClient;
import com.longpengz.tencentim.util.RestTemplateHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author longpengZ
 */
@Slf4j
public class SnsServiceImpIm extends ImBaseService implements SnsService {

    private final HttpClient httpClient = new RestTemplateHttpClient();

    private final Gson gson = new Gson();

    private final String url = "/v4/sns";

    private final String friendAddUrl = "/friend_add";

    private final String friendImportUrl = "/friend_import";

    private final String friendUpdateUrl = "/friend_update";

    private final String friendDeleteUrl = "/friend_delete";

    private final String friendDeleteAllUrl = "/friend_delete_all";

    private final String friendCheckUrl = "/friend_check";

    private final String friendGetUrl = "/friend_get";

    private final String friendGetListUrl = "/friend_get_list";

    private final String blackListAddUrl = "/black_list_add";

    private final String blackListDeleteUrl = "/black_list_delete";

    private final String blackListGetUrl = "/black_list_get";

    private final String blackListCheckUrl = "/black_list_check";

    private final String groupAddUrl = "/group_add";

    private final String groupDeleteUrl = "/group_delete";

    private final String groupGetUrl = "/group_get";



    @Override
    public ImFriendRes friendAdd(ImFriendAddReq imFriendAddReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendAddUrl + "?"),
                gson.toJson(imFriendAddReq));
        ImFriendRes imFriendRes = gson.fromJson(body, ImFriendRes.class);
        log.debug("IM添加好友结果："+body);
        return imFriendRes;
    }

    @Override
    public ImFriendRes friendImport(ImFriendImportReq imFriendImportReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendImportUrl + "?"),
                gson.toJson(imFriendImportReq));
        log.debug("IM导入好友结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImFriendRes friendUpdate(ImFriendUpdateReq imFriendUpdateReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendUpdateUrl + "?"),
                gson.toJson(imFriendUpdateReq));
        log.debug("IM更新好友结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImFriendRes friendDelete(ImFriendDeleteReq imFriendDeleteReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendDeleteUrl + "?"),
                gson.toJson(imFriendDeleteReq));
        log.debug("IM删除好友结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImResponse friendDeleteAll(ImFriendDeleteAllReq imFriendDeleteAllReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendDeleteAllUrl + "?"),
                gson.toJson(imFriendDeleteAllReq));
        log.debug("IM删除所有好友结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImFriendRes friendCheck(ImFriendCheckReq imFriendCheckReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendCheckUrl + "?"),
                gson.toJson(imFriendCheckReq));
        log.debug("IM校验好友结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImFriendGetRes friendGet(ImFriendGetReq imFriendGetReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendGetUrl + "?"),
                gson.toJson(imFriendGetReq));
        log.debug("IM拉取好友结果："+body);
        return gson.fromJson(body, ImFriendGetRes.class);
    }

    @Override
    public ImFriendGetListRes friendGetList(ImFriendGetListReq imFriendGetListReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + friendGetListUrl + "?"),
                gson.toJson(imFriendGetListReq));
        log.debug("IM拉取指定好友结果："+body);
        return gson.fromJson(body, ImFriendGetListRes.class);
    }

    @Override
    public ImFriendRes blackListAdd(ImBlackListReq imBlackListReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + blackListAddUrl + "?"),
                gson.toJson(imBlackListReq));
        log.debug("IM添加黑名单结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImFriendRes blackListDelete(ImBlackListReq imBlackListReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + blackListDeleteUrl + "?"),
                gson.toJson(imBlackListReq));
        log.debug("IM删除黑名单结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImBlackListGetRes blackListGet(ImBlackListGetReq imBlackListGetReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + blackListGetUrl + "?"),
                gson.toJson(imBlackListGetReq));
        log.debug("IM拉取黑名单结果："+body);
        return gson.fromJson(body, ImBlackListGetRes.class);
    }

    @Override
    public ImBlackListCheckRes blackListCheck(ImBlackListCheckReq imBlackListCheckReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + blackListCheckUrl + "?"),
                gson.toJson(imBlackListCheckReq));
        log.debug("IM校验黑名单结果："+body);
        return gson.fromJson(body, ImBlackListCheckRes.class);
    }

    @Override
    public ImFriendRes groupAdd(ImGroupReq imGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + groupAddUrl + "?"),
                gson.toJson(imGroupReq));
        log.debug("IM添加分组结果："+body);
        return gson.fromJson(body, ImFriendRes.class);
    }

    @Override
    public ImGroupDeleteRes groupDelete(ImGroupReq imGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + groupDeleteUrl + "?"),
                gson.toJson(imGroupReq));
        log.debug("IM删除分组结果："+body);
        return gson.fromJson(body, ImGroupDeleteRes.class);
    }

    @Override
    public ImGroupGetRes groupGet(ImGroupGetReq imGroupGetReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + groupGetUrl + "?"),
                gson.toJson(imGroupGetReq));
        log.debug("IM拉取分组结果："+body);
        return gson.fromJson(body, ImGroupGetRes.class);
    }
}
