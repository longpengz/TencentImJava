package com.longpengz.tencentim.service.profile;

import com.longpengz.tencentim.ImTestFactory;
import com.longpengz.tencentim.bean.enums.ActionStatusEnum;
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.account.AccountService;
import com.longpengz.tencentim.service.account.modle.ImAccountDeleteRequest;
import com.longpengz.tencentim.service.account.modle.ImMultiaccountImportRequest;
import com.longpengz.tencentim.service.profile.modle.ImPortraitGetReq;
import com.longpengz.tencentim.service.profile.modle.ImPortraitSetReq;
import com.longpengz.tencentim.service.profile.modle.ProfileItem;
import com.longpengz.tencentim.service.profile.modle.ProfileItemTagEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ProfileServiceTest {

    private static ProfileService profileService = null;
    private static AccountService accountServiceImp = null;
    private static List<String> accounts = new ArrayList<>();


    @BeforeAll
    static void init(){
        log.debug("资料模块测试开始");
        ImConfig imConfig = new ImConfig(1400459926,
                "administrator",
                "c1e7f72f98f8c44ec87bf779871e9e34bde51f3f3b84bc41e44ea3ab70c60381");
        accountServiceImp = ImTestFactory.getAccountService(imConfig);
        accounts.add("profile_1");
        accountServiceImp.multiaccountImport(ImMultiaccountImportRequest.builder()
                .Accounts(accounts).build());
        profileService = ImTestFactory.getProfileService(imConfig);

    }

    @AfterAll
    static void end(){
        accountServiceImp.accountDelete(ImAccountDeleteRequest.builder().DeleteItem(ImTestFactory.getDeleteItemsByAccounts(accounts)).build());
        log.debug("资料模块测试结束");
    }

    @Test
    void portraitSet() {
        List<ProfileItem> profileItems = new ArrayList<>();
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Nick)
                .value("测试名称").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Gender)
                .value("Gender_Type_Female").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_BirthDay)
                .value(20190419).build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Location)
                .value("所在地").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_SelfSignature)
                .value("个性签名").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_AllowType)
                .value("AllowType_Type_NeedConfirm").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Language)
                .value(1).build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Image)
                .value("头像URL").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_MsgSettings)
                .value(0).build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_AdminForbidType)
                .value("AdminForbid_Type_None").build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Level)
                .value(1).build());
        profileItems.add(ProfileItem.builder()
                .Tag(ProfileItemTagEnum.Tag_Profile_IM_Role)
                .value(1).build());
        assertEquals(profileService.portraitSet(ImPortraitSetReq.builder()
                .ProfileItem(profileItems)
                .From_Account("profile_1").build()).getActionStatus(), ActionStatusEnum.OK);

    }

    @Test
    void portraitGet() {
        List<ProfileItemTagEnum> tagEnums = new ArrayList<>();
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Nick);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Gender);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_BirthDay);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Location);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_SelfSignature);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_AllowType);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Language);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Image);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_MsgSettings);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_AdminForbidType);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Level);
        tagEnums.add(ProfileItemTagEnum.Tag_Profile_IM_Role);
        assertEquals(profileService.portraitGet(ImPortraitGetReq.builder()
                .To_Account(accounts)
                .TagList(tagEnums).build()).getActionStatus(),ActionStatusEnum.OK);
    }
}