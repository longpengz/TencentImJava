package com.longpengz.tencentim.service;

import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.groupOpenHttpSvc.GroupOpenHttpSvcService;
import com.longpengz.tencentim.service.openconfigsvr.OpenconfigsvrService;
import com.longpengz.tencentim.service.profile.ProfileService;
import com.longpengz.tencentim.service.singleChat.SingleChatService;
import com.longpengz.tencentim.service.sns.SnsService;

/**
 * IM使用客户端
 * @author longpengZ
 */
public class ImClient {

    public ImConfig imConfig;
    public AccountService accountService;
    public SingleChatService singleChatService;
    public GroupOpenHttpSvcService groupOpenHttpSvcService;
    public OpenconfigsvrService openconfigsvrService;
    public ProfileService profileService;
    public SnsService snsService;

    public void init(ImConfig imConfig){
        this.imConfig = imConfig;
        accountService = ImFactory.getAccountService(imConfig);
        singleChatService = ImFactory.getSingleChatService(imConfig);
        groupOpenHttpSvcService = ImFactory.getGroupOpenHttpSvcService(imConfig);
        openconfigsvrService = ImFactory.getOpenconfigsvrService(imConfig);
        profileService = ImFactory.getProfileService(imConfig);
        snsService = ImFactory.getSnsService(imConfig);
    }

}
