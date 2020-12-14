package com.longpengz.tencentim;

import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.AccountServiceImp;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.modle.ImMultiaccountImportResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@SpringBootTest
class TencentimApplicationTests {

    private

    @Test
    void contextLoads() {

    }


    public static void main(String[] args) {
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
//        accountImportTest(imConfig);
        multiaccountImportTest(imConfig);
    }

    public static void accountImportTest(ImConfig imConfig){
        AccountService accountService = new AccountServiceImp();
        ImResponse imResponse = accountService.accountImport(getBaseUrl(imConfig),
                "00003",
                null,
                null);
    }

    public static void multiaccountImportTest(ImConfig imConfig){
        AccountService accountService = new AccountServiceImp();
        List<String> accounts = new ArrayList<>();
        accounts.add("00004");
        accounts.add("00005");
        ImMultiaccountImportResponse imMultiaccountImportResponse = accountService.multiaccountImport(getBaseUrl(imConfig),
                accounts);
    }

    static String getBaseUrl(ImConfig imConfig){
//        String usersig = imConfig.getTlsSigAPIv2().genSig(imConfig.getIdentifier(),20*24*60*60);
        String usersig = "eJyrVgrxCdZLrSjILEpVsjI0N7IwMDDQAQuWpRYpWSkZ6RkoQfjFKdmJBQWZKUBlJgYGJqaWlkZmEJnMlNS8ksy0TLCGxJTczLzM4pKixJL8IpjWzHSgTGGmT3ZaXlBUsndyqUGGd4y*j1tEanF4SFiGV6C5uZNTaLmHn49hmYGpRX6gLVRnSWYuyF1mBuaWRqZG5qa1AEZuNM0_";
//        System.out.println(usersig);
        return imConfig.getDomain()
                + "?sdkappid=" + imConfig.getSdkAppId()
                + "&identifier=" + imConfig.getIdentifier()
                + "&usersig=" + usersig
                + "&random=" + getRandom()
                + "&contenttype=json";
    }

    static Integer getRandom() {
        Random random = new Random();
        return random.nextInt(2147483647);
    }



}
