package com.longpengz.tencentim.service.account;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.account.modle.*;
import com.longpengz.tencentim.service.account.request.*;
import com.longpengz.tencentim.service.account.response.ImAccountCheckRes;
import com.longpengz.tencentim.service.account.response.ImAccountDeleteRes;
import com.longpengz.tencentim.service.account.response.ImMultiAccountImportRes;
import com.longpengz.tencentim.service.account.response.ImQueryStateRes;

/**
 * @author longpengZ
 * IM账号管理相关接口
 */
public interface AccountService {


    /**
     * 导入单个账号：
     * 将自有帐号导入即时通信IM帐号系统，为该帐号创建一个对应的内部ID，使该帐号能够使用即时通信IM服务。
     * identifier 用户名，长度不超过32字节（必填）
     * nick  用户昵称（选填）
     * faceUrl 用户头像 URL（选填）
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse accountImport(ImAccountImportReq imAccountImportReq);

    /**
     * 导入多个账号：
     * 批量将自有帐号导入即时通信IM帐号系统，为该帐号创建一个对应的内部ID，使该帐号能够使用即时通信IM服务。
     * accounts 用户名列表（必填）
     * @author longpengZ
     * @return ImMultiaccountImportResponse
     */
    ImMultiAccountImportRes multiaccountImport(ImMultiAccountImportReq imMultiaccountImportRequest);

    /**
     * 删除账号：
     * 注：
     *  1.仅支持删除体验版帐号
     *  2.帐号删除时，该用户的关系链、资料等数据也会被删除
     *  3.帐号删除后，该用户的数据将无法恢复，请谨慎使用该接口
     * deleteItem 请求删除的帐号对象数组，单次请求最多支持100个帐号（必填）
     * @author longpengZ
     * @return ImAccountDeleteResponse
     */
    ImAccountDeleteRes accountDelete(ImAccountDeleteReq imAccountDeleteReq);

    /**
     * 查询帐号：
     * 查询自有帐号是否已导入即时通信IM,支持批量查询
     * checkItem 请求检查的帐号对象数组，单次请求最多支持100个帐号（必填）
     * @author longpengZ
     * @return ImAccountCheckResponse
     */
    ImAccountCheckRes accountCheck(ImAccountCheckReq imAccountCheckReq);

    /**
     * 失效帐号登录态：
     * 将App用户帐号的登录态（例如 UserSig）失效
     * 例：
     * 开发者判断一个用户为恶意帐号后，可以调用本接口将该用户当前的登录态失效，这样用户使用历史 UserSig 登录即时通信 IM 会失败。
     * identifier 用户名（必填）
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse kick(ImKickRequest imKickRequest);

    /**
     * 查询帐号在线状态:
     * toAccount 需要查询这些 UserID 的登录状态，一次最多查询500个 UserID 的状态（必填）
     * isNeedDetail 是否需要返回详细的登录平台信息。0表示不需要，1表示需要（必填）
     * 获取用户当前的登录状态
     * @return ImQueryStateResponse
     */
    ImQueryStateRes queryState(ImQueryStateReq imQueryStateReq);

}
