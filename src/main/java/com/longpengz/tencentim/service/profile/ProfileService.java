package com.longpengz.tencentim.service.profile;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.profile.modle.ImPortraitGetReq;
import com.longpengz.tencentim.service.profile.modle.ImPortraitGetRes;
import com.longpengz.tencentim.service.profile.modle.ImPortraitSetReq;

/**
 * @author longpengZ
 * IM账号管理相关接口
 */
public interface ProfileService {

    /**
     * 设置资料
     * 支持 标配资料字段 和 自定义资料字段 的设置。
     * From_Account	（必填）需要设置该 UserID 的资料
     * ProfileItem 待设置的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value
     * @author longpengZ
     * @return ImPortraitSetRes
     */
    ImResponse portraitSet(ImPortraitSetReq imPortraitSetReq);

    /**
     * 拉取资料
     * 注：
     *  1.支持拉取好友和非好友的资料字段。
     *  2.支持拉取 标配资料字段 和 自定义资料字段。
     *  3.建议每次拉取的用户数不超过100，避免因回包数据量太大导致回包失败。
     *  4.请确保请求中的所有帐号都已导入即时通信 IM，如果请求中含有未导入即时通信 IM 的帐号，即时通信 IM 后台将会提示错误。
     * To_Account （必填）需要拉取这些 UserID 的资料；注意：每次拉取的用户数不得超过100，避免因回包数据量太大以致回包失败
     * TagList （必填）指定要拉取的资料字段的
     * @author longpengZ
     * @return ImPortraitGetRes
     */
    ImPortraitGetRes portraitGet(ImPortraitGetReq imPortraitGetReq);


}
