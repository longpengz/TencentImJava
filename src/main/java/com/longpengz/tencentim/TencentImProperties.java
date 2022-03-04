package com.longpengz.tencentim;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "tencentim")
public class TencentImProperties {

    @ApiModelProperty(value = "App在即时通信IM控制台获取的应用标识")
    private long sdkAppId;

    @ApiModelProperty(value = "用户名App管理员帐号")
    private String identifier;

    @ApiModelProperty(value = "密钥信息可在即时通信IM控制台的应用详情页面中获取")
    private String key;

}
