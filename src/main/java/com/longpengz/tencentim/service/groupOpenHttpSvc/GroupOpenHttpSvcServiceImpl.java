package com.longpengz.tencentim.service.groupOpenHttpSvc;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.ImBaseService;
import com.longpengz.tencentim.service.groupOpenHttpSvc.request.*;
import com.longpengz.tencentim.service.groupOpenHttpSvc.response.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author longpengZ
 */
@Slf4j
public class GroupOpenHttpSvcServiceImpl extends ImBaseService implements GroupOpenHttpSvcService {

    private final String url = "/v4/group_open_http_svc";
    private final String getAppidGroupListUrl = "/get_appid_group_list";
    private final String createGroupUrl = "/create_group";
    private final String getGroupInfoUrl = "/get_group_info";
    private final String getGroupMemberInfoUrl = "/get_group_member_info";
    private final String modifyGroupBaseInfoUrl = "/modify_group_base_info";
    private final String addGroupMemberUrl = "/add_group_member";
    private final String deleteGroupMemberUrl = "/delete_group_member";
    private final String modifyGroupMemberInfoUrl = "/modify_group_member_info";
    private final String destroyGroupUrl = "/destroy_group";
    private final String getJoinedGroupListUrl = "/get_joined_group_list";
    private final String getRoleInGroupUrl = "/get_role_in_group";
    private final String forbidSendMsgUrl = "/forbid_send_msg";
    private final String getGroupShuttedUinUrl = "/get_group_shutted_uin";
    private final String sendGroupMsgUrl = "/send_group_msg";
    private final String sendGroupSystemNotificationUrl = "/send_group_system_notification";
    private final String changeGroupOwnerUrl = "/change_group_owner";
    private final String groupMsgRecallUrl = "/group_msg_recall";
    private final String importGroupUrl = "/import_group";
    private final String importGroupMsgUrl = "/import_group_msg";
    private final String importGroupMemberUrl = "/import_group_member";
    private final String setUnreadMsgNumUrl = "/set_unread_msg_num";
    private final String deleteGroupMsgBySenderUrl = "/delete_group_msg_by_sender";
    private final String groupMsgGetSimpleUrl = "/group_msg_get_simple";
    private final String getOnlineMemberNumUrl = "/get_online_member_num";
    private final String getGroupAttrUrl = "/v4/group_open_attr_http_svc" + "/get_group_attr";
    private final String modifyGroupAttrUrl = "/modify_group_attr";
    private final String clearGroupAttrUrl = "/clear_group_attr";
    private final String setGroupAttrUrl = "/set_group_attr";



    @Override
    public ImGetAppidGroupListRes getAppidGroupList(ImGetAppidGroupListReq imGetAppidGroupListReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getAppidGroupListUrl + "?"),
                gson.toJson(imGetAppidGroupListReq));
        log.debug("IM获取App中的所有群组结果："+body);
        return gson.fromJson(body, ImGetAppidGroupListRes.class);
    }

    @Override
    public ImCreateGroupRes createGroup(ImCreateGroupReq imCreateGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + createGroupUrl + "?"),
                gson.toJson(imCreateGroupReq));
        log.debug("IM创建群组结果："+body);
        return gson.fromJson(body, ImCreateGroupRes.class);
    }

    @Override
    public ImGetGroupInfoRes getGroupInfo(ImGetGroupInfoReq imGetGroupInfoReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getGroupInfoUrl + "?"),
                gson.toJson(imGetGroupInfoReq));
        log.debug("IM获取群详细资料结果："+body);
        return gson.fromJson(body, ImGetGroupInfoRes.class);
    }

    @Override
    public ImGetGroupMemberInfoRes getGroupMemberInfo(ImGetGroupMemberInfoReq imGetGroupMemberInfoReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getGroupMemberInfoUrl + "?"),
                gson.toJson(imGetGroupMemberInfoReq));
        log.debug("IM获取群成员详细资料结果："+body);
        return gson.fromJson(body, ImGetGroupMemberInfoRes.class);
    }

    @Override
    public ImResponse modifyGroupBaseInfo(ImCreateGroupReq imCreateGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + modifyGroupBaseInfoUrl + "?"),
                gson.toJson(imCreateGroupReq));
        log.debug("IM修改群基础资料结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImAddGroupMemberRes addGroupMember(ImAddGroupMemberReq imAddGroupMemberReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + addGroupMemberUrl + "?"),
                gson.toJson(imAddGroupMemberReq));
        log.debug("IM增加群成员结果："+body);
        return gson.fromJson(body, ImAddGroupMemberRes.class);
    }

    @Override
    public ImResponse deleteGroupMember(ImDeleteGroupMemberReq imDeleteGroupMemberReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + deleteGroupMemberUrl + "?"),
                gson.toJson(imDeleteGroupMemberReq));
        log.debug("IM删除群成员结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImResponse modifyGroupMemberInfo(ImModifyGroupMemberInfoReq imModifyGroupMemberInfoReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + modifyGroupMemberInfoUrl + "?"),
                gson.toJson(imModifyGroupMemberInfoReq));
        log.debug("IM修改群成员资料结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImResponse destroyGroup(ImDestroyGroupReq imDestroyGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + destroyGroupUrl + "?"),
                gson.toJson(imDestroyGroupReq));
        log.debug("IM解散群组结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImGetJoinedGroupListRes getJoinedGroupList(ImGetJoinedGroupListReq imGetJoinedGroupListReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getJoinedGroupListUrl + "?"),
                gson.toJson(imGetJoinedGroupListReq));
        log.debug("IM获取用户所加入的群组结果："+body);
        return gson.fromJson(body, ImGetJoinedGroupListRes.class);
    }

    @Override
    public ImGetRoleInGroupRes getRoleInGroup(ImGetRoleInGroupReq imGetRoleInGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getRoleInGroupUrl + "?"),
                gson.toJson(imGetRoleInGroupReq));
        log.debug("IM查询用户在群组中的身份结果："+body);
        return gson.fromJson(body, ImGetRoleInGroupRes.class);
    }

    @Override
    public ImResponse forbidSendMsg(ImForbidSendMsgReq imForbidSendMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + forbidSendMsgUrl + "?"),
                gson.toJson(imForbidSendMsgReq));
        log.debug("IM批量禁言和取消禁言结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImGetGroupShuttedUinRes getGroupShuttedUin(ImGetGroupShuttedUinReq imGetGroupShuttedUinReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getGroupShuttedUinUrl + "?"),
                gson.toJson(imGetGroupShuttedUinReq));
        log.debug("IM获取被禁言群成员列表结果："+body);
        return gson.fromJson(body, ImGetGroupShuttedUinRes.class);
    }

    @Override
    public ImSendGroupMsgRes sendGroupMsg(ImSendGroupMsgReq imSendGroupMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + sendGroupMsgUrl + "?"),
                gson.toJson(imSendGroupMsgReq));
        log.debug("IM在群组中发送普通消息结果："+body);
        return gson.fromJson(body, ImSendGroupMsgRes.class);
    }

    @Override
    public ImResponse sendGroupSystemNotification(ImSendGroupSystemNotificationReq imSendGroupSystemNotificationReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + sendGroupSystemNotificationUrl + "?"),
                gson.toJson(imSendGroupSystemNotificationReq));
        log.debug("IM在群组中发送系统通知结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImResponse changeGroupOwner(ImChangeGroupOwnerReq imChangeGroupOwnerReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + changeGroupOwnerUrl + "?"),
                gson.toJson(imChangeGroupOwnerReq));
        log.debug("IM转让群主结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImGroupMsgRecallRes groupMsgRecall(ImGroupMsgRecallReq imGroupMsgRecallReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + groupMsgRecallUrl + "?"),
                gson.toJson(imGroupMsgRecallReq));
        log.debug("IM撤回群消息结果："+body);
        return gson.fromJson(body, ImGroupMsgRecallRes.class);
    }

    @Override
    public ImCreateGroupRes importGroup(ImCreateGroupReq imCreateGroupReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + importGroupUrl + "?"),
                gson.toJson(imCreateGroupReq));
        log.debug("IM导入群基础资料结果："+body);
        return gson.fromJson(body, ImCreateGroupRes.class);
    }

    @Override
    public ImImportGroupMsgRes importGroupMsg(ImImportGroupMsgReq imImportGroupMsgReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + importGroupMsgUrl + "?"),
                gson.toJson(imImportGroupMsgReq));
        log.debug("IM导入群消息结果："+body);
        return gson.fromJson(body, ImImportGroupMsgRes.class);
    }

    @Override
    public ImImportGroupMemberRes importGroupMember(ImImportGroupMemberReq imImportGroupMemberReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + importGroupMemberUrl + "?"),
                gson.toJson(imImportGroupMemberReq));
        log.debug("IM导入群成员结果："+body);
        return gson.fromJson(body, ImImportGroupMemberRes.class);
    }

    @Override
    public ImResponse setUnreadMsgNum(ImSetUnreadMsgNumReq imSetUnreadMsgNumReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + setUnreadMsgNumUrl + "?"),
                gson.toJson(imSetUnreadMsgNumReq));
        log.debug("IM设置成员未读消息计数结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImResponse deleteGroupMsgBySender(ImDeleteGroupMsgBySenderReq imDeleteGroupMsgBySenderReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + deleteGroupMsgBySenderUrl + "?"),
                gson.toJson(imDeleteGroupMsgBySenderReq));
        log.debug("IM删除指定用户发送的消息结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImGroupMsgGetSimpleRes groupMsgGetSimple(ImGroupMsgGetSimpleReq imGroupMsgGetSimpleReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + groupMsgGetSimpleUrl + "?"),
                gson.toJson(imGroupMsgGetSimpleReq));
        log.debug("IM拉取群历史消息结果："+body);
        return gson.fromJson(body, ImGroupMsgGetSimpleRes.class);
    }

    @Override
    public ImGetOnlineMemberNumRes getOnlineMemberNum(ImGetOnlineMemberNumReq imGetOnlineMemberNumReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + getOnlineMemberNumUrl + "?"),
                gson.toJson(imGetOnlineMemberNumReq));
        log.debug("IM获取直播群在线人数结果："+body);
        return gson.fromJson(body, ImGetOnlineMemberNumRes.class);
    }

    @Override
    public ImGetGroupAttrRes getGroupAttr(ImGetGroupAttrReq imGetGroupAttrReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?",  getGroupAttrUrl + "?"),
                gson.toJson(imGetGroupAttrReq));
        log.debug("IM获取群自定义属性结果："+body);
        return gson.fromJson(body, ImGetGroupAttrRes.class);
    }

    @Override
    public ImResponse modifyGroupAttr(ImModifyGroupAttrReq imModifyGroupAttrReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + modifyGroupAttrUrl + "?"),
                gson.toJson(imModifyGroupAttrReq));
        log.debug("IM修改群自定义属性结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImResponse clearGroupAttr(ImClearGroupAttrReq imClearGroupAttrReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + clearGroupAttrUrl + "?"),
                gson.toJson(imClearGroupAttrReq));
        log.debug("IM清空群自定义属性结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }

    @Override
    public ImResponse setGroupAttr(ImModifyGroupAttrReq imModifyGroupAttrReq) {
        String body = httpClient.doPost(imConfig.getBaseUrl().replace("?", url + setGroupAttrUrl + "?"),
                gson.toJson(imModifyGroupAttrReq));
        log.debug("IM重置群自定义属性结果："+body);
        return gson.fromJson(body, ImResponse.class);
    }
}
