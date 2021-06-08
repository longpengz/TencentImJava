package com.longpengz.tencentim.service.account;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.modle.*;
import com.longpengz.tencentim.util.Captcha;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountServiceTest {

    private final AccountService accountService = getAccountService();

    public AccountService getAccountService(){
        AccountServiceImp accountServiceImp = new AccountServiceImp();
        accountServiceImp.init(new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381"));
        return accountServiceImp;
    }

    @Test
    void accountImport() {
        String uuidNumber = Captcha.getUUIDNumber(32);
        assertEquals(accountService.accountImport(ImAccountImportRequest.builder()
                        .Identifier(uuidNumber).build()).getActionStatus(), ActionStatusEnum.OK);
        List<ImAccountDeleteItem> deleteItems = new ArrayList<>();
        deleteItems.add(ImAccountDeleteItem.builder().UserID(uuidNumber).build());
        accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(deleteItems).build());

        assertEquals(accountService.accountImport(ImAccountImportRequest.builder().build()).getActionStatus(), ActionStatusEnum.FAIL);
    }

    @Test
    void multiaccountImport() {
        List<String> accounts1 = getAccounts(1);
        assertEquals(accountService.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts1).build()).getActionStatus(),ActionStatusEnum.OK);
        accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts1)).build());

        assertEquals(accountService.multiaccountImport(ImMultiaccountImportRequest.builder().build()).getActionStatus(),ActionStatusEnum.FAIL);

        List<String> accounts2 = getAccounts(101);
        assertEquals(accountService.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts2).build()).getActionStatus(),ActionStatusEnum.FAIL);
        accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts2)).build());

    }

    List<String> getAccounts(int size){
        List<String> accounts = new ArrayList<>();
        for (int i = 0; i < size; i++){
            accounts.add(Captcha.getUUIDNumber(32));
        }
        return accounts;
    }


    @Test
    void accountDelete() {
        assertEquals(accountService.accountDelete(ImAccountDeleteRequest.builder().build()).getActionStatus(),ActionStatusEnum.FAIL);

        List<String> accounts1 = getAccounts(1);
        accountService.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts1).build());
        assertEquals(accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts1)).build()).getActionStatus(),ActionStatusEnum.OK);

        assertEquals(accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(ImTestFactory.getDeleteItemsByAccounts(getAccounts(101))).build()).getActionStatus(),ActionStatusEnum.FAIL);

    }

    @Test
    void accountCheck() {
        assertEquals(accountService.accountCheck(ImAccountCheckRequest.builder().build()).getActionStatus(),ActionStatusEnum.FAIL);

        List<String> accounts1 = getAccounts(1);
        accountService.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts1).build());
        assertEquals(accountService.accountCheck(ImAccountCheckRequest.builder()
                .CheckItem(getCheckItemByAccounts(accounts1)).build()).getActionStatus(),ActionStatusEnum.OK);
        accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts1)).build());

        assertEquals(accountService.accountCheck(ImAccountCheckRequest.builder()
                .CheckItem(getCheckItemByAccounts(getAccounts(101))).build()).getActionStatus(),ActionStatusEnum.FAIL);
    }

    List<ImAccountCheckItem> getCheckItemByAccounts(List<String> accounts){
        List<ImAccountCheckItem> imAccountCheckItems = new ArrayList<>();
        accounts.forEach(it -> imAccountCheckItems.add(ImAccountCheckItem.builder().UserID(it).build()));
        return imAccountCheckItems;
    }

    @Test
    void kick() {
        String uuidNumber = Captcha.getUUIDNumber(32);
        accountService.accountImport(ImAccountImportRequest.builder()
                .Identifier(uuidNumber).build());
        assertEquals(accountService.kick(ImKickRequest.builder().Identifier(uuidNumber).build()).getActionStatus(),ActionStatusEnum.OK);
        assertEquals(accountService.kick(ImKickRequest.builder().build()).getActionStatus(),ActionStatusEnum.FAIL);
        List<ImAccountDeleteItem> deleteItems = new ArrayList<>();
        deleteItems.add(ImAccountDeleteItem.builder().UserID(uuidNumber).build());
        accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(deleteItems).build());
    }

    @Test
    void queryState() {
        assertEquals(accountService.queryState(ImQueryStateRequest.builder().build()).getActionStatus(),ActionStatusEnum.FAIL);

        List<String> accounts1 = getAccounts(1);
        accountService.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts1).build());
        assertEquals(accountService.queryState(ImQueryStateRequest.builder()
                .To_Account(accounts1).build()).getActionStatus(),ActionStatusEnum.OK);
        accountService.accountDelete(ImAccountDeleteRequest.builder()
                .DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts1)).build());

        assertEquals(accountService.queryState(ImQueryStateRequest.builder().To_Account(getAccounts(501)).build()).getActionStatus(),ActionStatusEnum.FAIL);
    }
}