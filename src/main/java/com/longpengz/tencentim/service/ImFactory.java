package com.longpengz.tencentim.service;

import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.AccountServiceImpIm;
import com.longpengz.tencentim.service.groupOpenHttpSvc.GroupOpenHttpSvcService;
import com.longpengz.tencentim.service.groupOpenHttpSvc.GroupOpenHttpSvcServiceImpl;
import com.longpengz.tencentim.service.openconfigsvr.OpenconfigsvrService;
import com.longpengz.tencentim.service.openconfigsvr.OpenconfigsvrServiceImpl;
import com.longpengz.tencentim.service.profile.ProfileService;
import com.longpengz.tencentim.service.profile.ProfileServiceImpIm;
import com.longpengz.tencentim.service.singleChat.SingleChatService;
import com.longpengz.tencentim.service.singleChat.SingleChatServiceImpIm;
import com.longpengz.tencentim.service.sns.SnsService;
import com.longpengz.tencentim.service.sns.SnsServiceImpIm;

public class ImFactory {

    public static AccountService getAccountService(ImConfig imConfig){
        AccountServiceImpIm accountService = new AccountServiceImpIm();
        accountService.init(imConfig);
        return accountService;
    }
    public static SingleChatService getSingleChatService(ImConfig imConfig){
        SingleChatServiceImpIm singleChatService = new SingleChatServiceImpIm();
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
        ProfileServiceImpIm profileService = new ProfileServiceImpIm();
        profileService.init(imConfig);
        return profileService;
    }

    public static SnsService getSnsService(ImConfig imConfig){
        SnsServiceImpIm snsService = new SnsServiceImpIm();
        snsService.init(imConfig);
        return snsService;
    }
}
