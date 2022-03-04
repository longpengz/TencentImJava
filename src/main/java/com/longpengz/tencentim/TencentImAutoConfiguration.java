package com.longpengz.tencentim;

import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.ImClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Configuration
@EnableConfigurationProperties(TencentImProperties.class)
@Slf4j
public class TencentImAutoConfiguration {

    @Bean
    ImClient imClient(TencentImProperties tencentImProperties){
        ImClient imClient = new ImClient();
        if(ObjectUtils.isEmpty(tencentImProperties.getSdkAppId())
                || !StringUtils.hasLength(tencentImProperties.getIdentifier())
                || !StringUtils.hasLength(tencentImProperties.getKey())){
            log.info("TencentImProperties 有参数未配置，初始化imClient失败");
        }else {
            imClient.init(new ImConfig(tencentImProperties.getSdkAppId(), tencentImProperties.getIdentifier(), tencentImProperties.getKey()));
            log.info("初始化imClient成功");
        }
        return imClient;
    }
}
