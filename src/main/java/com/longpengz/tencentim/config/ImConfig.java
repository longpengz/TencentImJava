package com.longpengz.tencentim.config;

import com.tencentyun.TLSSigAPIv2;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Random;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "腾讯IM配置")
public class ImConfig {

    @ApiModelProperty(value = "请求方式和请求域名")
    private String domain;

    @ApiModelProperty(value = "App在即时通信IM控制台获取的应用标识")
    private long sdkAppId;

    @ApiModelProperty(value = "用户名App管理员帐号")
    private String identifier;

    @ApiModelProperty(value = "密钥信息可在即时通信IM控制台的应用详情页面中获取")
    private String key;

    @ApiModelProperty(value = "用户名对应的密码（会过期）")
    private String usersig;
    
    @ApiModelProperty(value = "密码过期时间")
    private Long usersigExpire;

    @ApiModelProperty(value = "usersig计算工具")
    private TLSSigAPIv2 tlsSigAPIv2;


    public ImConfig(long sdkAppId, String identifier, String key) {
        this.domain = "https://console.tim.qq.com";
        init(sdkAppId,identifier,key);
    }

    public void init(long sdkAppId, String identifier, String key){
        this.sdkAppId = sdkAppId;
        this.identifier = identifier;
        this.key = key;
        this.tlsSigAPIv2 = new TLSSigAPIv2(sdkAppId,key);
    }

    /**
     * 构建请求基础URL
     * @author longpengZ
     */
    public String getBaseUrl(){
        refreshUsersig();
        return domain
                + "?sdkappid=" + sdkAppId
                + "&identifier=" + identifier
                + "&usersig=" + usersig
                + "&random=" + getRandom()
                + "&contenttype=json";
    }

    /**
     * 刷新密码信息
     * @author longpengZ
     */
    public void refreshUsersig(){
        if(!StringUtils.hasLength(usersig)
                || ObjectUtils.isEmpty(usersigExpire)
                || System.currentTimeMillis() >= usersigExpire){
            setUsersig(tlsSigAPIv2.genSig(identifier,24*60*60));//1天
            setUsersigExpire(System.currentTimeMillis() + 23*60*60*1000);
        }
    }

    /**
     * 获取随机数
     * @author longpengZ
     */
    public static Integer getRandom() {
        Random random = new Random();
        return random.nextInt(2147483647);
    }

}
