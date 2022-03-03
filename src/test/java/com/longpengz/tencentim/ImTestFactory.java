package com.longpengz.tencentim;

import com.longpengz.tencentim.bean.enums.MsgTypeEnum;
import com.longpengz.tencentim.bean.modle.*;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.AccountServiceImpIm;
import com.longpengz.tencentim.service.account.modle.ImAccountDeleteItem;
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

import java.util.ArrayList;
import java.util.List;

public class ImTestFactory {

    public static AccountService getAccountService(ImConfig imConfig){
        AccountServiceImpIm accountService = new AccountServiceImpIm();
        accountService.init(imConfig);
        return accountService;
    }

    public static List<ImAccountDeleteItem> getDeleteItemsByAccounts(List<String> accounts){
        List<ImAccountDeleteItem> imAccountDeleteItems = new ArrayList<>();
        accounts.forEach(it -> imAccountDeleteItems.add(ImAccountDeleteItem.builder().UserID(it).build()));
        return imAccountDeleteItems;
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


    public static List<MsgBodyItem> getMsgBody(){
        List<MsgBodyItem> msgBodyItems = new ArrayList<>();
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMTextElem)
                .MsgContent(TextMsgContent.builder().Text("文本消息").build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMLocationElem)
                .MsgContent(LocationMsgContent.builder()
                        .Desc("地理位置消息")
                        .Latitude(29.582438)
                        .Longitude(106.614103).build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMFaceElem)
                .MsgContent(FaceMsgContent.builder()
                        .Index(0)
                        .Data("表情消息").build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMCustomElem)
                .MsgContent(CustomMsgContent.builder()
                        .Data("自定义消息")
                        .Desc("自定义消息描述信息")
                        .Ext("扩展字段").build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMSoundElem)
                .MsgContent(SoundMsgContent.builder()
                        .Url("语音消息")
                        .Size(10000L)
                        .Second(100L)
                        .Download_Flag(2).build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMImageElem)
                .MsgContent(ImageMsgContent.builder()
                        .UUID("图像消息")
                        .ImageFormat(1)
                        .ImageInfoArray(new ArrayList<>()).build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMFileElem)
                .MsgContent(FileMsgContent.builder()
                        .Url("文件消息")
                        .FileSize(100L)
                        .FileName("文件名称")
                        .Download_Flag(2).build()).build());
        return msgBodyItems;
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
