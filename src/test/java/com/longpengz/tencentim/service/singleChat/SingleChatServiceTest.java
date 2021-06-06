package com.longpengz.tencentim.service.singleChat;

import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.bean.enums.MsgTypeEnum;
import com.longpengz.tencentim.bean.modle.*;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountServiceImp;
import com.longpengz.tencentim.service.account.modle.ImMultiaccountImportRequest;
import com.longpengz.tencentim.service.singleChat.modle.ImSingleChatSendMsgReq;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleChatServiceTest {


    public SingleChatService getSingleChatService(){

        return new SingleChatServiceImp();
    }

    public void create(){
        AccountServiceImp accountServiceImp = new AccountServiceImp();
        accountServiceImp.init(new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381"));
        List<String> accounts = new ArrayList<>();
        accounts.add("single_account_1");
        accounts.add("single_account_2");
        accountServiceImp.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts).build());
    }

    @Test
    void sendMsg() {
        SingleChatService singleChatService = getSingleChatService();
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
                        .ImageInfoArray(new ArrayList<ImageInfoItem>()).build()).build());
        msgBodyItems.add(MsgBodyItem.builder()
                .MsgType(MsgTypeEnum.TIMFileElem)
                .MsgContent(FileMsgContent.builder()
                        .Url("文件消息")
                        .FileSize(100L)
                        .FileName("文件名称")
                        .Download_Flag(2).build()).build());
        assertEquals(singleChatService.sendMsg(ImSingleChatSendMsgReq.builder()
                .From_Account("single_account_1")
                .To_Account("single_account_2")
                .MsgRandom(ImConfig.getRandom())
                .MsgBody(msgBodyItems).build()).getActionStatus(),ActionStatusEnum.OK);

    }

    @Test
    void batchSendMsg() {
    }

    @Test
    void importMsg() {
    }

    @Test
    void adminGetroamMsg() {
    }

    @Test
    void adminMsgWithdraw() {
    }

    @Test
    void adminSetMsgRead() {
    }

    @Test
    void getC2CUnreadMsgNum() {
    }
}