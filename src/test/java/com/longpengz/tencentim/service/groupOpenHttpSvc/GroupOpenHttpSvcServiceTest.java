package com.longpengz.tencentim.service.groupOpenHttpSvc;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.bean.modle.ImMapItem;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.request.ImAccountDeleteReq;
import com.longpengz.tencentim.service.account.request.ImMultiAccountImportReq;
import com.longpengz.tencentim.service.groupOpenHttpSvc.enums.GroupTypeEnum;
import com.longpengz.tencentim.service.groupOpenHttpSvc.enums.ImImportGroupMsgListItem;
import com.longpengz.tencentim.service.groupOpenHttpSvc.enums.ImMsgFlagEnum;
import com.longpengz.tencentim.service.groupOpenHttpSvc.model.*;
import com.longpengz.tencentim.service.groupOpenHttpSvc.request.*;
import com.longpengz.tencentim.service.groupOpenHttpSvc.response.ImCreateGroupRes;
import com.longpengz.tencentim.service.groupOpenHttpSvc.response.ImSendGroupMsgRes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GroupOpenHttpSvcServiceTest {


    private static GroupOpenHttpSvcService groupOpenHttpSvcService = null;
    private static AccountService accountService = null;
    private static final List<String> accounts = new ArrayList<>();
    private static String groupId = "";
    private static final List<String> groups = new ArrayList<>();


    @BeforeAll
    static void init(){
        log.debug("账号管理测试开始");
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
        accountService = ImTestFactory.getAccountService(imConfig);
        groupOpenHttpSvcService = ImTestFactory.getGroupOpenHttpSvcService(imConfig);
    }

    @AfterAll
    static void end(){
        accountService.accountDelete(ImAccountDeleteReq.builder().DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts)).build());
        if(StringUtils.hasLength(groupId)){
            groups.add(groupId);
        }
        groups.forEach(it -> groupOpenHttpSvcService.destroyGroup(ImDestroyGroupReq.builder().GroupId(it).build()));
        log.debug("账号管理测试结束");
    }

    public String getAccount(){
        if(accounts.size() < 1){
            accounts.add("group_open_http_svc_account_1");
            accountService.multiaccountImport(ImMultiAccountImportReq.builder()
                    .Accounts(accounts).build());
        }
        return accounts.get(0);
    }

    public List<String> getAccounts(){
        if(accounts.size() < 1){
            accounts.add("group_open_http_svc_account_1");
            accountService.multiaccountImport(ImMultiAccountImportReq.builder()
                    .Accounts(accounts).build());
        }
        return accounts;
    }

    public String getGroupId(){
        if(!StringUtils.hasLength(groupId)){
            groupId = "group_id_1";
            groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                    .Type(GroupTypeEnum.Public)
                    .Name("测试组")
                    .GroupId(groupId).build());
        }
        return groupId;
    }

    public void groupAddMember(){
        ArrayList<ImAddMemberItem> list = new ArrayList<ImAddMemberItem>() {{
            add(ImAddMemberItem.builder()
                    .Member_Account(getAccount()).build());
        }};
        groupOpenHttpSvcService.addGroupMember(ImAddGroupMemberReq.builder()
                .GroupId(getGroupId())
                .MemberList(list).build());
    }




    @Test
    void getAppidGroupList() {
        assertEquals(groupOpenHttpSvcService.getAppidGroupList(ImGetAppidGroupListReq.builder()
                .build()).getActionStatus(), ActionStatusEnum.OK);

    }

    @Test
    void createGroup() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.Public)
                .Name("名称")
                .GroupId("group_open_http_svc_group_2").build());
        assertEquals(imCreateGroupRes.getActionStatus(), ActionStatusEnum.OK);
        groups.add(imCreateGroupRes.getGroupId());
    }

    @Test
    void getGroupInfo() {
        ArrayList<String> list = new ArrayList<String>() {{
            add(getGroupId());
        }};
        assertEquals(groupOpenHttpSvcService.getGroupInfo(ImGetGroupInfoReq.builder()
                .GroupIdList(list).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getGroupMemberInfo() {
        assertEquals(groupOpenHttpSvcService.getGroupMemberInfo(ImGetGroupMemberInfoReq.builder()
                .GroupId(getGroupId()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void modifyGroupBaseInfo() {
        assertEquals(groupOpenHttpSvcService.modifyGroupBaseInfo(ImCreateGroupReq.builder()
                .GroupId(getGroupId())
                .Name("修改名称").build()).getActionStatus(), ActionStatusEnum.OK);

    }

    @Test
    void addGroupMember() {
        ArrayList<ImAddMemberItem> list = new ArrayList<ImAddMemberItem>() {{
            add(ImAddMemberItem.builder()
                    .Member_Account(getAccount()).build());
        }};
        assertEquals(groupOpenHttpSvcService.addGroupMember(ImAddGroupMemberReq.builder()
                .GroupId(getGroupId())
                .MemberList(list).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void deleteGroupMember() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.deleteGroupMember(ImDeleteGroupMemberReq.builder()
                .GroupId(getGroupId())
                .MemberToDel_Account(getAccounts()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void modifyGroupMemberInfo() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.modifyGroupMemberInfo(ImModifyGroupMemberInfoReq.builder()
                .GroupId(getGroupId())
                .Member_Account(getAccount())
                .MsgFlag(ImMsgFlagEnum.AcceptAndNotify).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void destroyGroup() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.Public)
                .Name("名称")
                .GroupId("group_open_http_svc_group_8").build());
        assertEquals(groupOpenHttpSvcService.destroyGroup(ImDestroyGroupReq.builder()
                .GroupId(imCreateGroupRes.getGroupId()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getJoinedGroupList() {
        assertEquals(groupOpenHttpSvcService.getJoinedGroupList(ImGetJoinedGroupListReq.builder()
                .Member_Account(getAccount())
                .WithHugeGroups(0).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getRoleInGroup() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.getRoleInGroup(ImGetRoleInGroupReq.builder()
                .GroupId(getGroupId())
                .User_Account(getAccounts()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void forbidSendMsg() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.forbidSendMsg(ImForbidSendMsgReq.builder()
                .GroupId(getGroupId())
                .Members_Account(getAccounts())
                .ShutUpTime(10).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getGroupShuttedUin() {
        assertEquals(groupOpenHttpSvcService.getGroupShuttedUin(ImGetGroupShuttedUinReq.builder()
                .GroupId(getGroupId()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void sendGroupMsg() {
        assertEquals(groupOpenHttpSvcService.sendGroupMsg(ImSendGroupMsgReq.builder()
                .GroupId(getGroupId())
                .Random(ImConfig.getRandom())
                .MsgBody(ImTestFactory.getMsgBody()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void sendGroupSystemNotification() {
        assertEquals(groupOpenHttpSvcService.sendGroupSystemNotification(ImSendGroupSystemNotificationReq.builder()
                .GroupId(getGroupId())
                .Content("测试系统通知").build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void changeGroupOwner() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.changeGroupOwner(ImChangeGroupOwnerReq.builder()
                .GroupId(getGroupId())
                .NewOwner_Account(getAccount()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void groupMsgRecall() {
        ImSendGroupMsgRes imSendGroupMsgRes = groupOpenHttpSvcService.sendGroupMsg(ImSendGroupMsgReq.builder()
                .GroupId(getGroupId())
                .Random(ImConfig.getRandom())
                .MsgBody(ImTestFactory.getMsgBody()).build());
        ArrayList<ImMsgSeqItem> msgSeqList = new ArrayList<ImMsgSeqItem>() {{
            add(ImMsgSeqItem.builder()
                    .MsgSeq(imSendGroupMsgRes.getMsgSeq()).build());
        }};
        assertEquals(groupOpenHttpSvcService.groupMsgRecall(ImGroupMsgRecallReq.builder()
                .GroupId(getGroupId())
                .MsgSeqList(msgSeqList).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void importGroup() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.importGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.Public)
                .Name("测试导入群主").build());
        assertEquals(imCreateGroupRes.getActionStatus(), ActionStatusEnum.OK);
        groupOpenHttpSvcService.destroyGroup(ImDestroyGroupReq.builder().GroupId(imCreateGroupRes.getGroupId()).build());
    }

    @Test
    void importGroupMsg() {
        groupAddMember();
        Long time = new Date().getTime() / 1000;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<ImImportGroupMsgListItem> msgList = new ArrayList<ImImportGroupMsgListItem>() {{
            add(ImImportGroupMsgListItem.builder()
                    .From_Account(getAccount())
                    .SendTime(time.intValue() + 2)
                    .MsgBody(ImTestFactory.getMsgBody()).build());
        }};
        assertEquals(groupOpenHttpSvcService.importGroupMsg(ImImportGroupMsgReq.builder()
                .GroupId(getGroupId())
                .MsgList(msgList).build()).getActionStatus(), ActionStatusEnum.OK);

    }

    @Test
    void importGroupMember() {
        ArrayList<ImImportGroupMemberMemberListItem> memberList = new ArrayList<ImImportGroupMemberMemberListItem>() {{
            add(ImImportGroupMemberMemberListItem.builder()
                    .Member_Account(getAccount()).build());
        }};
        assertEquals(groupOpenHttpSvcService.importGroupMember(ImImportGroupMemberReq.builder()
                .GroupId(getGroupId())
                .MemberList(memberList).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void setUnreadMsgNum() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.setUnreadMsgNum(ImSetUnreadMsgNumReq.builder()
                .GroupId(getGroupId())
                .Member_Account(getAccount())
                .UnreadMsgNum(0).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void deleteGroupMsgBySender() {
        groupAddMember();
        assertEquals(groupOpenHttpSvcService.deleteGroupMsgBySender(ImDeleteGroupMsgBySenderReq.builder()
                .GroupId(getGroupId())
                .Sender_Account(getAccount()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void groupMsgGetSimple() {
        assertEquals(groupOpenHttpSvcService.deleteGroupMsgBySender(ImDeleteGroupMsgBySenderReq.builder()
                .GroupId(getGroupId())
                .Sender_Account(getAccount()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getOnlineMemberNum() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.AVChatRoom)
                .Name("名称")
                .GroupId("group_open_http_svc_group_3").build());
        groups.add(imCreateGroupRes.getGroupId());
        assertEquals(groupOpenHttpSvcService.getOnlineMemberNum(ImGetOnlineMemberNumReq.builder()
                .GroupId(imCreateGroupRes.getGroupId()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void getGroupAttr() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.AVChatRoom)
                .Name("名称")
                .GroupId("group_open_http_svc_group_4").build());
        groups.add(imCreateGroupRes.getGroupId());
        assertEquals(groupOpenHttpSvcService.getGroupAttr(ImGetGroupAttrReq.builder()
                .GroupId(imCreateGroupRes.getGroupId()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void modifyGroupAttr() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.AVChatRoom)
                .Name("名称")
                .GroupId("group_open_http_svc_group_5").build());
        groups.add(imCreateGroupRes.getGroupId());
        ArrayList<ImMapItem> imMapItems = new ArrayList<ImMapItem>() {{
            add(ImMapItem.builder()
                    .key("test_key")
                    .value("test_value").build());
        }};
        assertEquals(groupOpenHttpSvcService.modifyGroupAttr(ImModifyGroupAttrReq.builder()
                .GroupId(imCreateGroupRes.getGroupId())
                .GroupAttr(imMapItems).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void clearGroupAttr() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.AVChatRoom)
                .Name("名称")
                .GroupId("group_open_http_svc_group_6").build());
        groups.add(imCreateGroupRes.getGroupId());
        assertEquals(groupOpenHttpSvcService.clearGroupAttr(ImClearGroupAttrReq.builder()
                .GroupId(imCreateGroupRes.getGroupId()).build()).getActionStatus(), ActionStatusEnum.OK);
    }

    @Test
    void setGroupAttr() {
        ImCreateGroupRes imCreateGroupRes = groupOpenHttpSvcService.createGroup(ImCreateGroupReq.builder()
                .Type(GroupTypeEnum.AVChatRoom)
                .Name("名称")
                .GroupId("group_open_http_svc_group_7").build());
        ArrayList<ImMapItem> imMapItems = new ArrayList<ImMapItem>() {{
            add(ImMapItem.builder()
                    .key("test_key")
                    .value("test_value").build());
        }};
        groups.add(imCreateGroupRes.getGroupId());
        assertEquals(groupOpenHttpSvcService.setGroupAttr(ImModifyGroupAttrReq.builder()
                .GroupId(imCreateGroupRes.getGroupId())
                .GroupAttr(imMapItems).build()).getActionStatus(), ActionStatusEnum.OK);
    }

}