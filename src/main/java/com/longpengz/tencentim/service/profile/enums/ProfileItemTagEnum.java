package com.longpengz.tencentim.service.profile.enums;

import io.swagger.annotations.ApiModel;

/**
 * @author longpengZ
 * 1. uint32_t 类型的整数（自定义资料字段不支持）。
 * 2. uint64_t 类型的整数（自定义资料字段不支持）。
 * 3. string 类型的字符串（string 的长度不得超过500字节）。
 * 4. bytes 类型的一段 buffer（buffer 的长度不得超过500字节）。
 */
@ApiModel(description = "设置的资料字段的名称")
public enum ProfileItemTagEnum {
    /**
     * 昵称（String）
     * 长度不得超过500个字节
     */
    Tag_Profile_IM_Nick,
    /**
     * 性别（String）
     * Gender_Type_Unknown：没设置性别
     * Gender_Type_Female：女性
     * Gender_Type_Male：男性
     */
    Tag_Profile_IM_Gender,
    /**
     * 生日（uint32）
     * 推荐用法：20190419
     */
    Tag_Profile_IM_BirthDay,
    /**
     * 所在地（String）
     * 长度不得超过16个字节
     */
    Tag_Profile_IM_Location,
    /**
     * 个性签名（String）
     * 长度不得超过500个字节
     */
    Tag_Profile_IM_SelfSignature,
    /**
     * 加好友验证方式（String）
     * AllowType_Type_NeedConfirm：需要经过自己确认对方才能添加自己为好友
     * AllowType_Type_AllowAny：允许任何人添加自己为好友
     * AllowType_Type_DenyAny：不允许任何人添加自己为好友
     */
    Tag_Profile_IM_AllowType,
    /**
     * 语言（uint32）
     */
    Tag_Profile_IM_Language,
    /**
     * 头像URL（String）
     * 长度不得超过500个字节
     */
    Tag_Profile_IM_Image,
    /**
     * 消息设置（uint32）
     * 标志位：Bit0：置0表示接收消息，置1则不接收消息
     */
    Tag_Profile_IM_MsgSettings,
    /**
     * 管理员禁止加好友标识（String）
     * AdminForbid_Type_None：默认值，允许加好友
     * AdminForbid_Type_SendOut：禁止该用户发起加好友请求
     */
    Tag_Profile_IM_AdminForbidType,
    /**
     * 等级（uint32）
     * 通常一个 UINT-8 数据即可保存一个等级信息
     */
    Tag_Profile_IM_Level,
    /**
     * 角色（uint32）
     * 通常一个 UINT-8 数据即可保存一个角色信息
     */
    Tag_Profile_IM_Role;

}
