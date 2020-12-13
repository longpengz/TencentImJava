package com.longpengz.tencentim;

import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.AccountServiceImp;
import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.config.ImConfig;
import org.junit.jupiter.api.Test;

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
        accountImportTest(imConfig);
    }

    public static void accountImportTest(ImConfig imConfig){
        AccountService accountService = new AccountServiceImp();
        ImResponse imResponse = accountService.accountImport(getBaseUrl(imConfig),
                "00003",
                null,
                null);
    }

    static String getBaseUrl(ImConfig imConfig){
//        String usersig = imConfig.getTlsSigAPIv2().genSig(imConfig.getIdentifier(),24*60*60);
        String usersig = "eJw1jssKwjAURP8layn3lpo*wI0gqBWhNm7cBZKWS0ka0lC04r9bWl3OnDkwbyYudaSfjrxmRcYTgM1SjdqzgsURsDUPqpPOkWIFzptkm*cxXwkpbQM1tAhSGbI0BC9D7-8qtTN54STquvQg*2tblbezs0ljzQP93ZwOx2nfgVNihBGr3U8MZOZTyCFNM44xfr7dPTTG";
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
