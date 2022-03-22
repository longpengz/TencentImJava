# TencentImJava - 腾讯即时通信IM Java SDK
## 概述
腾讯即时通信IM Java 开发工具包，支持服务端API 账号管理、单聊消息、资料管理、关系链管理、群组管理等模块。

功能根据官方文档开发完成。[即时通信IM官方文档地址](https://cloud.tencent.com/document/product/269/1519)

## 特殊说明
参数的字段命名根据官方来的

## 用法
### 1.maven 依赖
```xml
<dependency>
    <groupId>com.longpengz</groupId>
    <artifactId>tencentim</artifactId>
    <version>${tencentim.version}</version>
</dependency>
```
### 2.properties 配置（springboot项目中使用配置）
```properties
# 用户名App管理员帐号
tencentim.identifier=identifier
# 密钥信息可在即时通信IM控制台的应用详情页面中获取
tencentim.key=key
# app在即时通信IM控制台获取的应用标识
tencentim.sdk-app-id=sdk-app-id 
```
### 3.项目中使用
ImClient Service对应各个功能模块
```text
账号管理模块 AccountService 
单聊消息模块 SingleChatService
全员推送模块 暂不支持
资料管理模块 ProfileService
关系链模块 SnsService
最近联系人模块 RecentContactsService
群组管理模块 GroupOpenHttpSvcService
全局禁言+运营管理模块 OpenconfigsvrService
注：各个模块具体的调用，请查阅对应Service，有非常详细的注解。
```

springboot项目中使用示例

```java
import com.longpengz.tencentim.service.ImClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final ImClient imClient;
    
    public void useImClient(){
        imClient.service.方法;
    }
}
```
其他使用示例

```java
import com.longpengz.tencentim.config.ImConfig;
import com.longpengz.tencentim.service.ImClient;

public class Demo {
    public static void main(String[] args) {
        ImClient imClient = new ImClient();
        long sdkAppId = 11111;
        imClient.init(new ImConfig(sdkAppId, "Identifier", "key"));
        imClient.service.方法;
    }
}
```
## 版本说明
目前是Beta版本 0.0.1，1.0.0之后为正式发布稳定版本。



