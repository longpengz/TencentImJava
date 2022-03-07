package com.longpengz.tencentim.service;

import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.AccountServiceImpl;
import com.longpengz.tencentim.service.groupOpenHttpSvc.GroupOpenHttpSvcService;
import com.longpengz.tencentim.service.groupOpenHttpSvc.GroupOpenHttpSvcServiceImpl;
import com.longpengz.tencentim.service.openconfigsvr.OpenconfigsvrService;
import com.longpengz.tencentim.service.openconfigsvr.OpenconfigsvrServiceImpl;
import com.longpengz.tencentim.service.profile.ProfileService;
import com.longpengz.tencentim.service.profile.ProfileServiceImpl;
import com.longpengz.tencentim.service.singleChat.SingleChatService;
import com.longpengz.tencentim.service.singleChat.SingleChatServiceImpl;
import com.longpengz.tencentim.service.sns.SnsService;
import com.longpengz.tencentim.service.sns.SnsServiceImpl;

public class ImFactory {

    public static AccountService getAccountService(ImConfig imConfig){
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.init(imConfig);
        return accountService;
    }
    public static SingleChatService getSingleChatService(ImConfig imConfig){
        SingleChatServiceImpl singleChatService = new SingleChatServiceImpl();
        singleChatService.init(imConfig);
        return singleChatService;
    }

    public static GroupOpenHttpSvcService getGroupOpenHttpSvcService(ImConfig imConfig){
        GroupOpenHttpSvcServiceImpl groupOpenHttpSvcService = new GroupOpenHttpSvcServiceImpl();
        groupOpenHttpSvcService.init(imConfig);
        return groupOpenHttpSvcService;
    }

    public static OpenconfigsvrService getOpenconfigsvrService(ImConfig imConfig){
        OpenconfigsvrServiceImpl openconfigsvrService = new OpenconfigsvrServiceImpl();
        openconfigsvrService.init(imConfig);
        return openconfigsvrService;
    }

    public static ProfileService getProfileService(ImConfig imConfig){
        ProfileServiceImpl profileService = new ProfileServiceImpl();
        profileService.init(imConfig);
        return profileService;
    }

    public static SnsService getSnsService(ImConfig imConfig){
        SnsServiceImpl snsService = new SnsServiceImpl();
        snsService.init(imConfig);
        return snsService;
    }
}
