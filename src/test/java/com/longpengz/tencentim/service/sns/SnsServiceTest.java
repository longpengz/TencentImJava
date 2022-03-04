package com.longpengz.tencentim.service.sns;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.request.ImAccountDeleteReq;
import com.longpengz.tencentim.service.account.request.ImMultiAccountImportReq;
import com.longpengz.tencentim.service.profile.enums.ProfileItemTagEnum;
import com.longpengz.tencentim.service.sns.enums.CheckBlackTypeEnum;
import com.longpengz.tencentim.service.sns.enums.CheckFriendTypeEnum;
import com.longpengz.tencentim.service.sns.enums.CustomItemTagEunm;
import com.longpengz.tencentim.service.sns.enums.DeleteFriendTypeEnum;
import com.longpengz.tencentim.service.sns.modle.*;
import com.longpengz.tencentim.service.sns.request.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SnsServiceTest {

    private static SnsService snsService = null;
    private static AccountService accountServiceImp = null;
    private static List<String> accounts = new ArrayList<>();

    @BeforeAll
    static void init(){
        log.debug("关系链测试开始");
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
        accountServiceImp = ImTestFactory.getAccountService(imConfig);
        accounts.add("sns_account_1");
        accounts.add("sns_account_2");
        accountServiceImp.multiaccountImport(ImMultiAccountImportReq.builder()
                .Accounts(accounts).build());
        snsService = ImTestFactory.getSnsService(imConfig);

    }

    @AfterAll
    static void end(){
        accountServiceImp.accountDelete(ImAccountDeleteReq.builder().DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts)).build());
        log.debug("关系链测试结束");
    }

    @Test
    void friendAdd() {
        List<ImAddFriendItem<String>> addFriendItems = new ArrayList<>();
        addFriendItems.add(ImAddFriendItem.<String>builder()
                .To_Account("sns_account_2")
                .AddSource("AddSource_Type_11").build());
        assertEquals(snsService.friendAdd(ImFriendAddReq.builder()
                .From_Account("sns_account_1")
                .AddFriendItem(addFriendItems).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void friendImport() {
        List<ImAddFriendItem<List<String>>> addFriendItems = new ArrayList<>();
        addFriendItems.add(ImAddFriendItem.<List<String>>builder()
                .To_Account("sns_account_2")
                .AddSource("AddSource_Type_11").build());
        assertEquals(snsService.friendImport(ImFriendImportReq.builder()
                .From_Account("sns_account_1")
                .AddFriendItem(addFriendItems).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void friendUpdate() {
        List<ImUpdateItem> updateItems = new ArrayList<>();
        List<ImSnsItem> snsItems = new ArrayList<>();
        snsItems.add(ImSnsItem.builder()
                .Tag(CustomItemTagEunm.Tag_SNS_IM_Remark)
                .Value("好友更新").build());
        updateItems.add(ImUpdateItem.builder()
                .To_Account("sns_account_2")
                .SnsItem(snsItems).build());
        assertEquals(snsService.friendUpdate(ImFriendUpdateReq.builder()
                .From_Account("sns_account_1")
                .UpdateItem(updateItems).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void friendDelete() {
        List<String> deleteAccounts = new ArrayList<>();
        deleteAccounts.add("sns_account_2");
        assertEquals(snsService.friendDelete(ImFriendDeleteReq.builder()
                .From_Account("sns_account_1")
                .To_Account(deleteAccounts)
                .DeleteType(DeleteFriendTypeEnum.Delete_Type_Both).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void friendDeleteAll() {
        assertEquals(snsService.friendDeleteAll(ImFriendDeleteAllReq.builder()
                .From_Account("sns_account_1").build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void friendCheck() {
        assertEquals(snsService.friendCheck(ImFriendCheckReq.builder()
                .From_Account("sns_account_1")
                .To_Account(getStringAccounts())
                .CheckType(CheckFriendTypeEnum.CheckResult_Type_Both).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void friendGet() {
        assertEquals(snsService.friendGet(ImFriendGetReq.builder()
                .From_Account("sns_account_1")
                .StartIndex(0).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void friendGetList() {
        friendAdd();
        List<ProfileItemTagEnum> tagList = new ArrayList<>();
        tagList.add(ProfileItemTagEnum.Tag_Profile_IM_Nick);
        assertEquals(snsService.friendGetList(ImFriendGetListReq.builder()
                .From_Account("sns_account_1")
                .To_Account(getStringAccounts())
                .TagList(tagList).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void blackListAdd() {
        assertEquals(snsService.blackListAdd(ImBlackListReq.builder()
                .From_Account("sns_account_1")
                .To_Account(getStringAccounts()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void blackListDelete() {
        blackListAdd();
        assertEquals(snsService.blackListDelete(ImBlackListReq.builder()
                .From_Account("sns_account_1")
                .To_Account(getStringAccounts()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void blackListGet() {
        assertEquals(snsService.blackListGet(ImBlackListGetReq.builder()
                .From_Account("sns_account_1")
                .StartIndex(0)
                .MaxLimited(10)
                .LastSequence(0).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void blackListCheck() {
        assertEquals(snsService.blackListCheck(ImBlackListCheckReq.builder()
                .From_Account("sns_account_1")
                .To_Account(getStringAccounts())
                .CheckType(CheckBlackTypeEnum.BlackCheckResult_Type_Both).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void groupAdd() {
        assertEquals(snsService.groupAdd(ImGroupReq.builder()
                .From_Account("sns_account_1")
                .GroupName(getGroupNameList()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void groupDelete() {
        groupAdd();
        assertEquals(snsService.groupDelete(ImGroupReq.builder()
                .From_Account("sns_account_1")
                .GroupName(getGroupNameList()).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    @Test
    void groupGet() {
        assertEquals(snsService.groupGet(ImGroupGetReq.builder()
                .From_Account("sns_account_1")
                .LastSequence(0).build()).getActionStatus(),ActionStatusEnum.OK);
    }

    public List<String> getStringAccounts(){
        List<String> accounts = new ArrayList<>();
        accounts.add("sns_account_2");
        return accounts;
    }

    public List<String> getGroupNameList(){
        List<String> groupNames = new ArrayList<>();
        groupNames.add("group_A");
        return groupNames;
    }
}