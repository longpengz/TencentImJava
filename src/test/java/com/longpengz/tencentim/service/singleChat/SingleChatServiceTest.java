package com.longpengz.tencentim.service.singleChat;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.request.ImAccountDeleteReq;
import com.longpengz.tencentim.service.account.request.ImMultiAccountImportReq;
import com.longpengz.tencentim.service.singleChat.request.*;
import com.longpengz.tencentim.service.singleChat.response.ImSingleChatSendMsgRes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SingleChatServiceTest {

    private static SingleChatService singleChatService = null;
    private static AccountService accountServiceImp = null;
    private static List<String> accounts = new ArrayList<>();


    @BeforeAll
    static void init(){
        log.debug("单聊模块测试开始");
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
        accountServiceImp = ImTestFactory.getAccountService(imConfig);
        accounts.add("single_account_1");
        accounts.add("single_account_2");
        accounts.add("single_account_3");
        accountServiceImp.multiaccountImport(ImMultiAccountImportReq.builder()
                .Accounts(accounts).build());
        singleChatService = ImTestFactory.getSingleChatService(imConfig);

    }

    @AfterAll
    static void end(){
        accountServiceImp.accountDelete(ImAccountDeleteReq.builder().DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts)).build());
        log.debug("单聊模块测试结束");
    }

    @Test
    void sendMsg() {
        assertEquals(singleChatService.sendMsg(ImSingleChatSendMsgReq.builder()
                .From_Account("single_account_1")
                .To_Account("single_account_2")
                .MsgRandom(ImConfig.getRandom())
                .MsgBody(ImTestFactory.getMsgBody()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void batchSendMsg() {
        List<String> toAccounts = new ArrayList<>();
        toAccounts.add("single_account_2");
        toAccounts.add("single_account_3");
        assertEquals(singleChatService.batchSendMsg(ImSingleChatBatchSendMsgReq.builder()
                .From_Account("single_account_1")
                .To_Account(toAccounts)
                .MsgRandom(ImConfig.getRandom())
                .MsgBody(ImTestFactory.getMsgBody()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void importMsg() {
        assertEquals(singleChatService.importMsg(ImImportMsgReq.builder()
                .SyncFromOldSystem(1)
                .From_Account("single_account_1")
                .To_Account("single_account_2")
                .MsgRandom(ImConfig.getRandom())
                .MsgTimeStamp((int) (System.currentTimeMillis()/1000))
                .MsgBody(ImTestFactory.getMsgBody()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void adminGetroamMsg() {
        assertEquals(singleChatService.adminGetroamMsg(ImAdminGetroamMsgReq.builder()
                .From_Account("single_account_1")
                .To_Account("single_account_2")
                .MaxCnt(10)
                .MinTime(100)
                .MaxTime(1000).build()).getActionStatus(),ActionStatusEnum.OK);

    }

    @Test
    void adminMsgWithdraw() {
        ImSingleChatSendMsgRes imSingleChatSendMsgRes = singleChatService.sendMsg(ImSingleChatSendMsgReq.builder()
                .From_Account("single_account_1")
                .To_Account("single_account_2")
                .MsgRandom(ImConfig.getRandom())
                .MsgBody(ImTestFactory.getMsgBody()).build());
        assertEquals(singleChatService.adminMsgWithdraw(ImAdminMsgWithdrawReq.builder()
                .From_Account("single_account_1")
                .To_Account("single_account_2")
                .MsgKey(imSingleChatSendMsgRes.getMsgKey()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void adminSetMsgRead() {
        assertEquals(singleChatService.adminSetMsgRead(ImAdminSetMsgReadReq.builder()
                .Peer_Account("single_account_2")
                .Report_Account("single_account_1").build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void getC2CUnreadMsgNum() {
        assertEquals(singleChatService.getC2CUnreadMsgNum(ImGetC2CUnreadMsgNumReq.builder()
                .To_Account("single_account_1").build()).getActionStatus(),ActionStatusEnum.OK);
    }
}