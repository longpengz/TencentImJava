package com.longpengz.tencentim.service.recentContacts;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.ImFactory;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.request.ImAccountDeleteReq;
import com.longpengz.tencentim.service.account.request.ImMultiAccountImportReq;
import com.longpengz.tencentim.service.groupOpenHttpSvc.GroupOpenHttpSvcService;
import com.longpengz.tencentim.service.recentContacts.request.ImRecentContactsDeleteReq;
import com.longpengz.tencentim.service.recentContacts.request.ImRecentContactsGetListReq;
import com.longpengz.tencentim.service.singleChat.SingleChatService;
import com.longpengz.tencentim.service.singleChat.request.ImSingleChatSendMsgReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class RecentContactsServiceTest {

    private static RecentContactsService recentContactsService = null;
    private static AccountService accountService = null;
    private static SingleChatService singleChatService = null;
    private static final List<String> accounts = new ArrayList<>();


    @BeforeAll
    static void init(){
        log.debug("最近联系人测试开始");
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
        recentContactsService = ImTestFactory.getRecentContactsService(imConfig);
        accountService = ImTestFactory.getAccountService(imConfig);
        singleChatService = ImFactory.getSingleChatService(imConfig);
        accounts.add("recent_contacts_account_1");
        accounts.add("recent_contacts_account_2");
        accountService.multiaccountImport(ImMultiAccountImportReq.builder()
                .Accounts(accounts).build());
        singleChatService.sendMsg(ImSingleChatSendMsgReq.builder()
                .From_Account(accounts.get(0))
                .To_Account(accounts.get(1))
                .MsgRandom(ImConfig.getRandom())
                .MsgBody(ImTestFactory.getMsgBody()).build());
    }

    @AfterAll
    static void end(){
        accountService.accountDelete(ImAccountDeleteReq.builder().DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts)).build());
        log.debug("最近联系人测试结束");
    }


    @Test
    void getList() {
        assertEquals(recentContactsService.getList(ImRecentContactsGetListReq.builder()
                .From_Account(accounts.get(0))
                .TimeStamp(0)
                .AssistFlags(0)
                .StartIndex(0)
                .TopStartIndex(0)
                .TopTimeStamp(0).build()).getActionStatus() , ActionStatusEnum.OK);
    }

    @Test
    void delete() {
        assertEquals(recentContactsService.delete(ImRecentContactsDeleteReq.builder()
                .From_Account(accounts.get(0))
                .Type(1)
                .To_Account(accounts.get(1))
                .ClearRamble(1).build()).getActionStatus() , ActionStatusEnum.OK);
    }
}