package com.longpengz.tencentim.account;

import com.google.gson.Gson;
import com.longpengz.tencentim.account.modle.ImAccountImportRequest;
import com.longpengz.tencentim.account.modle.ImMultiaccountImportRequest;
import com.longpengz.tencentim.account.modle.ImMultiaccountImportResponse;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.util.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class AccountServiceImp implements AccountService{

    private RestTemplateUtil restTemplateUtil=new RestTemplateUtil();

    private final Gson gson = new Gson();

    private final String url="/v4/im_open_login_svc";

    private final String accountImportUrl = "/account_import";

    private final String multiaccountImportUrl = "/multiaccount_import";

    @Override
    public ImResponse accountImport(String baseUrl, String identifier, String nick, String faceUrl) {
        if(!StringUtils.hasLength(identifier)
                || identifier.getBytes(StandardCharsets.UTF_8).length>32){
            return ImResponse.builder()
                    .ActionStatus(ActionStatusEnum.FAIL)
                    .ErrorCode(400)
                    .ErrorInfo("用户名不能为空且长度不超过32字节").build();
        }
        String body = restTemplateUtil.doPost(baseUrl.replace("?", url + accountImportUrl + "?"),
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
        String body = restTemplateUtil.doPost(baseUrl.replace("?", url + accountImportUrl + "?"),
                gson.toJson(ImMultiaccountImportRequest.builder().Accounts(accounts).build()));
        log.debug("IM导入单个账号结果："+body);
        return gson.fromJson(body,ImMultiaccountImportResponse.class);
    }


}
