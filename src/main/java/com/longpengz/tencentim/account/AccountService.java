package com.longpengz.tencentim.account;

import com.longpengz.tencentim.account.modle.ImMultiaccountImportResponse;
import com.longpengz.tencentim.bean.response.ImResponse;

import java.util.List;

public interface AccountService {


    /**
     * 将自有帐号导入即时通信IM帐号系统，为该帐号创建一个对应的内部ID，使该帐号能够使用即时通信IM服务。
     * @author longpengZ
     * @param baseUrl 基础请求参数
     * @param identifier 用户名，长度不超过32字节
     * @param nick  用户昵称
     * @param faceUrl 用户头像 URL
     * @return ImResponse
     */
    ImResponse accountImport(String baseUrl, String identifier, String nick, String faceUrl);


    /**
     * 批量将自有帐号导入即时通信IM帐号系统，为该帐号创建一个对应的内部ID，使该帐号能够使用即时通信IM服务。
     * @author longpengZ
     * @param baseUrl
     * @param accounts
     * @return ImMultiaccountImportResponse
     */
    ImMultiaccountImportResponse multiaccountImport(String baseUrl, List<String> accounts);

}
