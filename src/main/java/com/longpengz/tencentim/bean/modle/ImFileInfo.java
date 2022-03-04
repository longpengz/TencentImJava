package com.longpengz.tencentim.bean.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM文件信息")
public class ImFileInfo {

    @ApiModelProperty(value = "消息记录文件下载地址")
    private String URL;

    @ApiModelProperty(value = "下载地址过期时间，请在过期前进行下载，若地址失效，请通过该接口重新获取")
    private String ExpireTime;
    
    @ApiModelProperty(value = "GZip 压缩前的文件大小（单位 Byte）")
    private Integer FileSize;

    @ApiModelProperty(value = "GZip 压缩前的文件 MD5")
    private String FileMD5;

    @ApiModelProperty(value = "GZip 压缩后的文件大小（单位 Byte）")
    private Integer GzipSize;

    @ApiModelProperty(value = "GZip 压缩后的文件 MD5")
    private String GzipMD5;

}
