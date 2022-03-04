package com.longpengz.tencentim.service.sns.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "自定义好友字段的名称")
public enum CustomItemTagEunm {
    /**
     * 好友分组：
     * 1. 最多支持 32 个分组；
     * 2. 不允许分组名为空；
     * 3. 分组名长度不得超过 30 个字节；
     * 4. 同一个好友可以有多个不同的分组
     */
    Tag_SNS_IM_Group,
    /**
     * 好友备注：
     * 1. 备注长度最长不得超过 96 个字节
     */
    Tag_SNS_IM_Remark,
    /**
     * 加好友来源：
     * 1. 加好友来源字段包含前缀和关键字两部分；
     * 2. 加好友来源字段的前缀是：AddSource_Type_ ；
     * 3. 关键字：必须是英文字母，且长度不得超过 8 字节，建议用一个英文单词或该英文单词的缩写；
     * 4. 示例：加好友来源的关键字是 Android，则加好友来源字段是：AddSource_Type_Android
     */
    Tag_SNS_IM_AddSource,
    /**
     * 	加好友附言：
     * 1. 加好友附言的长度最长不得超过 256 个字节
     */
    Tag_SNS_IM_AddWording
}
