package com.longpengz.tencentim.service.account;

import com.google.gson.Gson;
import com.longpengz.tencentim.service.BaseService;
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
public class AccountServiceImp extends BaseService implements AccountService {

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
    public ImResponse accountImport(ImAccountImportRequest imAccountImportRequest) {
        if(!StringUtils.hasLength(imAccountImportRequest.getIdentifier())
                || imAccountImportRequest.getIdentifier().getBytes(StandardCharsets.UTF_8).length>32){
            return ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名不能为空且长度不超过32字节").build();
        }
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + accountImportUrl + "?"),
                gson.toJson(imAccountImportRequest));
        log.debug("IM导入单个账号结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImMultiaccountImportResponse multiaccountImport(ImMultiaccountImportRequest imMultiaccountImportRequest) {
        if(ObjectUtils.isEmpty(imMultiaccountImportRequest.getAccounts())
                || imMultiaccountImportRequest.getAccounts().size() < 1
                || imMultiaccountImportRequest.getAccounts().size() > 100){
            return ImMultiaccountImportResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名，单个用户名长度不超过32字节，单次最多导入100个用户名，至少添加一个").build();
        }
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + multiaccountImportUrl + "?"),
                gson.toJson(imMultiaccountImportRequest));
        log.debug("IM导入多个账号结果："+body);
        return gson.fromJson(body,ImMultiaccountImportResponse.class);
    }

    @Override
    public ImAccountDeleteResponse accountDelete(ImAccountDeleteRequest imAccountDeleteRequest) {
        if(ObjectUtils.isEmpty(imAccountDeleteRequest.getDeleteItem())
                || imAccountDeleteRequest.getDeleteItem().size() < 1
                || imAccountDeleteRequest.getDeleteItem().size() > 100){
            return ImAccountDeleteResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("删除的帐号对象数组，单次请求最多支持100个帐号，至少添加一个").build();
        }
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + accountDeleteUrl + "?"),
                gson.toJson(imAccountDeleteRequest));
        log.debug("IM删除账号结果："+body);
        return gson.fromJson(body,ImAccountDeleteResponse.class);
    }

    @Override
    public ImAccountCheckResponse accountCheck(ImAccountCheckRequest imAccountCheckRequest) {
        if(ObjectUtils.isEmpty(imAccountCheckRequest.getCheckItem())
                || imAccountCheckRequest.getCheckItem().size() < 1
                || imAccountCheckRequest.getCheckItem().size() > 100){
            return ImAccountCheckResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("查询的帐号对象数组，单次请求最多支持100个帐号，至少添加一个").build();
        }
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + accountCheckUrl + "?"),
                gson.toJson(imAccountCheckRequest));
        log.debug("IM查询账号结果："+body);
        return gson.fromJson(body,ImAccountCheckResponse.class);
    }

    @Override
    public ImResponse kick(ImKickRequest imKickRequest) {
        if(!StringUtils.hasLength(imKickRequest.getIdentifier())){
            return ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名不能为空").build();
        }
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + kickUrl + "?"),
                gson.toJson(imKickRequest));
        log.debug("IM失效帐号登录态结果："+body);
        return gson.fromJson(body,ImResponse.class);
    }

    @Override
    public ImQueryStateResponse queryState(ImQueryStateRequest imQueryStateRequest) {
        if(ObjectUtils.isEmpty(imQueryStateRequest.getTo_Account())
                || imQueryStateRequest.getTo_Account().size() < 1
                || imQueryStateRequest.getTo_Account().size() > 500){
            return ImQueryStateResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("需要查询这些 UserID 的登录状态，一次最多查询500个 UserID 的状态，至少添加一个").build();
        }
        if(ObjectUtils.isEmpty(imQueryStateRequest.getIsNeedDetail())){
            imQueryStateRequest.setIsNeedDetail(0);
        }
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", queryStateUrl + "?"),
                gson.toJson(imQueryStateRequest));
        log.debug("IM查询帐号在线状态结果："+body);
        return gson.fromJson(body,ImQueryStateResponse.class);
    }


}
