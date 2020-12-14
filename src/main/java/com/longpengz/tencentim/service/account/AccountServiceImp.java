package com.longpengz.tencentim.service.account;

import com.google.gson.Gson;
import com.longpengz.tencentim.service.account.modle.*;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.util.HttpClient;
import com.longpengz.tencentim.util.RestTemplateHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author longpengZ
 */
@Slf4j
public class AccountServiceImp implements AccountService{

    private final HttpClient httpClient = new RestTemplateHttpClient();

    private final Gson gson = new Gson();

    private final String url="/v4/im_open_login_svc";

    private final String accountImportUrl = "/account_import";

    private final String multiaccountImportUrl = "/multiaccount_import";

    private final String accountDeleteUrl = "/account_delete";

    private final String accountCheckUrl = "/account_check";

    private final String kickUrl = "/kick";

    private final String queryStateUrl = "/v4/openim/querystate";

    @Override
    public ImResponse accountImport(String baseUrl, String identifier, String nick, String faceUrl) {
        if(!StringUtils.hasLength(identifier)
                || identifier.getBytes(StandardCharsets.UTF_8).length>32){
            return ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名不能为空且长度不超过32字节").build();
        }
        String body = httpClient.doPost(baseUrl.replace("?", url + accountImportUrl + "?"),
                gson.toJson(ImAccountImportRequest.builder()
                        .Identifier(identifier)
                        .Nick(nick)
                        .FaceUrl(faceUrl).build()));
        log.debug("IM导入单个账号结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImMultiaccountImportResponse multiaccountImport(String baseUrl, List<String> accounts) {
        if(ObjectUtils.isEmpty(accounts)
                || accounts.size()<1){
            return (ImMultiaccountImportResponse) ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名，单个用户名长度不超过32字节，单次最多导入100个用户名，至少添加一个").build();
        }
        String body = httpClient.doPost(baseUrl.replace("?", url + multiaccountImportUrl + "?"),
                gson.toJson(ImMultiaccountImportRequest.builder().Accounts(accounts).build()));
        log.debug("IM导入多个账号结果："+body);
        return gson.fromJson(body,ImMultiaccountImportResponse.class);
    }

    @Override
    public ImAccountDeleteResponse accountDelete(String baseUrl, List<ImAccountDeleteItem> deleteItem) {
        if(ObjectUtils.isEmpty(deleteItem)
                || deleteItem.size()<1){
            return (ImAccountDeleteResponse) ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("删除的帐号对象数组，单次请求最多支持100个帐号，至少添加一个").build();
        }
        String body = httpClient.doPost(baseUrl.replace("?", url + accountDeleteUrl + "?"),
                gson.toJson(ImAccountDeleteRequest.builder().DeleteItem(deleteItem).build()));
        log.debug("IM删除账号结果："+body);
        return gson.fromJson(body,ImAccountDeleteResponse.class);
    }

    @Override
    public ImAccountCheckResponse accountCheck(String baseUrl, List<ImAccountCheckItem> checkItem) {
        if(ObjectUtils.isEmpty(checkItem)
                || checkItem.size()<1){
            return (ImAccountCheckResponse) ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("查询的帐号对象数组，单次请求最多支持100个帐号，至少添加一个").build();
        }
        String body = httpClient.doPost(baseUrl.replace("?", url + accountCheckUrl + "?"),
                gson.toJson(ImAccountCheckRequest.builder().CheckItem(checkItem).build()));
        log.debug("IM查询账号结果："+body);
        return gson.fromJson(body,ImAccountCheckResponse.class);
    }

    @Override
    public ImResponse kick(String baseUrl, String identifier) {
        if(!StringUtils.hasLength(identifier)){
            return ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名不能为空").build();
        }
        String body = httpClient.doPost(baseUrl.replace("?", url + kickUrl + "?"),
                gson.toJson(ImKickRequest.builder().Identifier(identifier).build()));
        log.debug("IM失效帐号登录态结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImQueryStateResponse queryState(String baseUrl, List<String> toAccount, Integer isNeedDetail) {
        if(ObjectUtils.isEmpty(toAccount)
                || toAccount.size()<1){
            return (ImQueryStateResponse) ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("需要查询这些 UserID 的登录状态，一次最多查询500个 UserID 的状态，至少添加一个").build();
        }
        if(ObjectUtils.isEmpty(isNeedDetail)){
            isNeedDetail = 0;
        }
        String body = httpClient.doPost(baseUrl.replace("?", queryStateUrl + "?"),
                gson.toJson(ImQueryStateRequest.builder()
                        .To_Account(toAccount)
                        .IsNeedDetail(isNeedDetail).build()));
        log.debug("IM查询帐号在线状态结果："+body);
        return gson.fromJson(body,ImQueryStateResponse.class);
    }


}
