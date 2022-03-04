package com.longpengz.tencentim.service.sns;

import com.longpengz.tencentim.bean.response.ImResponse;
import com.longpengz.tencentim.service.sns.request.*;
import com.longpengz.tencentim.service.sns.response.*;

/**
 * @author longpengZ
 * 关系链管理模块接口
 */
public interface SnsService {

    /**
     * 添加好友
     * 添加好友，支持批量添加好友
     * From_Account （必填）需要为该 UserID 添加好友
     * AddFriendItem （必填）好友结构体对象
     * AddType （选填）加好友方式（默认双向加好友方式）：
     * ForceAddFlags （选填）管理员强制加好友标记：1表示强制加好友，0表示常规加好友方式
     * @author longpengZ
     * @return ImFriendAddRes
     */
    ImFriendRes friendAdd(ImFriendAddReq imFriendAddReq);

    /**
     * 导入好友
     * 注：
     *  1.支持批量导入单向好友。
     *  2.往同一个用户导入好友时建议采用批量导入的方式，避免并发写导致的写冲突。
     * From_Account （必填）需要为该 UserID 添加好友
     * AddFriendItem （必填）好友结构体对象
     * @author longpengZ
     * @return ImFriendAddRes
     */
    ImFriendRes friendImport(ImFriendImportReq imFriendImportReq);

    /**
     * 更新好友
     * 注：
     *  1.支持批量更新同一用户的多个好友的关系链数据。
     *  2.更新一个用户多个好友时，建议采用批量方式，避免并发写导致的写冲突。
     * From_Account （必填）需要为该 UserID 添加好友
     * UpdateItem （必填）需要更新的好友对象数组
     * @author longpengZ
     * @return ImFriendAddRes
     */
    ImFriendRes friendUpdate(ImFriendUpdateReq imFriendUpdateReq);

    /**
     * 删除好友
     * 删除好友，支持单向删除好友和双向删除好友。
     * From_Account （必填）需要删除该 UserID 的好友
     * To_Account （必填）待删除的好友的 UserID 列表，单次请求的 To_Account 数不得超过1000
     * DeleteType （必填）删除模式
     * @author longpengZ
     * @return ImFriendAddRes
     */
    ImFriendRes friendDelete(ImFriendDeleteReq imFriendDeleteReq);

    /**
     * 删除所有好友
     * 清除指定用户的标配好友数据和自定义好友数据。
     * From_Account （必填）指定要清除好友数据的用户的 UserID
     * DeleteType （选填）删除模式
     * @author longpengZ
     * @return ImResponse
     */
    ImResponse friendDeleteAll(ImFriendDeleteAllReq imFriendDeleteAllReq);

    /**
     * 校验好友
     * 支持批量校验好友关系。
     * From_Account （必填）需要校验该 UserID 的好友
     * To_Account （必填）请求校验的好友的 UserID 列表，单次请求的 To_Account 数不得超过1000
     * CheckType （必填）校验模式
     * @author longpengZ
     * @return ImFriendRes
     */
    ImFriendRes friendCheck(ImFriendCheckReq imFriendCheckReq);


    /**
     * 拉取好友
     * 注：
     *  1.分页拉取全量好友数据。
     *  2.不支持资料数据的拉取。
     *  3.不需要指定请求拉取的字段，默认返回全量的标配好友数据和自定义好友数据。
     * From_Account （必填）指定要拉取好友数据的用户的 UserID
     * StartIndex （必填）分页的起始位置
     * StandardSequence （选填）上次拉好友数据时返回的 StandardSequence，如果 StandardSequence 字段的值与后台一致，后台不会返回标配好友数据
     * CustomSequence （选填）上次拉好友数据时返回的 CustomSequence，如果 CustomSequence 字段的值与后台一致，后台不会返回自定义好友数据
     * @author longpengZ
     * @return ImFriendGetRes
     */
    ImFriendGetRes friendGet(ImFriendGetReq imFriendGetReq);

    /**
     * 拉取指定好友
     * 注：
     *  1.支持拉取指定好友的好友数据和资料数据。
     *  2.建议每次拉取的好友数不超过100，避免因数据量太大导致回包失败。
     * From_Account （必填）指定要拉取好友数据的用户的 UserID
     * To_Account （必填）好友的 UserID 列表 建议每次请求的好友数不超过100，避免因数据量太大导致回包失败
     * TagList （必填）指定要拉取的资料字段及好友字段
     * @author longpengZ
     * @return ImFriendGetListRes
     */
    ImFriendGetListRes friendGetList(ImFriendGetListReq imFriendGetListReq);

    /**
     * 添加黑名单
     * 注：
     *  1.添加黑名单，支持批量添加黑名单。
     *  2.如果用户 A 与用户 B 之间存在好友关系，拉黑时会解除双向好友关系。
     *  3.如果用户 A 与用户 B 之间存在黑名单关系，二者之间无法发起加好友请求。
     *  4.如果用户 A 的黑名单中有用户 B 且用户 B 的黑名单中有用户 A，二者之间无法发起会话。
     *  5.如果用户 A 的黑名单中有用户 B 但用户 B 的黑名单中没有用户 A，那么用户 A 可以给用户 B 发消息，用户 B 不能给用户 A 发消息。
     * From_Account （必填）请求为该 UserID 添加黑名单
     * To_Account （必填）待添加为黑名单的用户 UserID 列表，单次请求的 To_Account 数不得超过1000
     * @author longpengZ
     * @return ImFriendRes
     */
    ImFriendRes blackListAdd(ImBlackListReq imBlackListReq);

    /**
     * 删除黑名单
     * 删除指定黑名单。
     * From_Account （必填）请求为该 UserID 删除黑名单
     * To_Account （必填）待删除为黑名单的用户 UserID 列表，单次请求的 To_Account 数不得超过1000
     * @author longpengZ
     * @return ImFriendRes
     */
    ImFriendRes blackListDelete(ImBlackListReq imBlackListReq);

    /**
     * 拉取黑名单
     * 支持分页拉取所有黑名单。
     * From_Account （必填）需要拉取该 UserID 的黑名单
     * StartIndex （必填）拉取的起始位置
     * MaxLimited （必填）每页最多拉取的黑名单数
     * LastSequence （必填）上一次拉黑名单时后台返回给客户端的 Seq，初次拉取时为0
     * @author longpengZ
     * @return ImBlackListGetRes
     */
    ImBlackListGetRes blackListGet(ImBlackListGetReq imBlackListGetReq);

    /**
     * 校验黑名单
     * 支持批量校验黑名单。
     * From_Account （必填）需要校验该 UserID 的黑名单
     * To_Account （必填）待校验的黑名单的 UserID 列表，单次请求的 To_Account 数不得超过1000
     * CheckType （必填）校验模式
     * @author longpengZ
     * @return ImBlackListCheckRes
     */
    ImBlackListCheckRes blackListCheck(ImBlackListCheckReq imBlackListCheckReq);

    /**
     * 添加分组
     * 添加分组，支持批量添加分组，并将指定好友加入到新增分组中。
     * From_Account （必填）需要为该 UserID 添加新分组
     * GroupName （必填）新增分组列表
     * To_Account （选填）需要加入新增分组的好友的 UserID 列表
     * @author longpengZ
     * @return ImFriendRes
     */
    ImFriendRes groupAdd(ImGroupReq imGroupReq);

    /**
     * 删除分组
     * 删除指定分组。
     * From_Account （必填）需要删除该 UserID 的分组
     * GroupName （必填）	要删除的分组列表
     * @author longpengZ
     * @return ImGroupDeleteRes
     */
    ImGroupDeleteRes groupDelete(ImGroupReq imGroupReq);

    /**
     * 拉取分组
     * 拉取分组，支持指定分组以及拉取分组下的好友列表。
     * From_Account （必填）指定要拉取分组的用户的 UserID
     * LastSequence （必填）上一次拉取分组时后台返回给客户端的 Seq，初次拉取时为0，只有 GroupName 为空时有效
     * NeedFriend （选填）是否需要拉取分组下的 User 列表, Need_Friend_Type_Yes: 需要拉取, 不填时默认不拉取, 只有 GroupName 为空时有效
     * GroupName （选填）要拉取的分组名称
     * @author longpengZ
     * @return ImGroupGetRes
     */
    ImGroupGetRes groupGet(ImGroupGetReq imGroupGetReq);
}
