package com.longpengz.tencentim.service.openconfigsvr;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.modle.ImAccountDeleteRequest;
import com.longpengz.tencentim.service.account.modle.ImMultiaccountImportRequest;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.ImDestroyGroupReq;
import com.longpengz.tencentim.service.openconfigsvr.model.ImGetnospeakingReq;
import com.longpengz.tencentim.service.openconfigsvr.model.ImSetnospeakingReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OpenconfigsvrServiceTest {

    private static OpenconfigsvrService openconfigsvrService = null;
    private static AccountService accountService = null;
    private static final List<String> accounts = new ArrayList<>();


    @BeforeAll
    static void init(){
        log.debug("全局禁言管理测试开始");
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
        accountService = ImTestFactory.getAccountService(imConfig);
        openconfigsvrService = ImTestFactory.getOpenconfigsvrService(imConfig);
    }

    public String getAccount(){
        if(accounts.size() < 1){
            accounts.add("group_open_http_svc_account_1");
            accountService.multiaccountImport(ImMultiaccountImportRequest.builder()
                    .Accounts(accounts).build());
        }
        return accounts.get(0);
    }

    @AfterAll
    static void end(){
        accountService.accountDelete(ImAccountDeleteRequest.builder().DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts)).build());
        log.debug("全局禁言管理测试结束");
    }


    @Test
    void setnospeaking() {
        assertEquals(openconfigsvrService.setnospeaking(ImSetnospeakingReq.builder()
                .Set_Account(getAccount())
                .C2CmsgNospeakingTime(0)
                .GroupmsgNospeakingTime(0).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getnospeaking() {
        assertEquals(openconfigsvrService.getnospeaking(ImGetnospeakingReq.builder()
                .Get_Account(getAccount()).build()).getActionStatus(), ActionStatusEnum.OK);
    }
}