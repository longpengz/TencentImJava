package com.longpengz.tencentim.service.openconfigsvr.response;

import com.longpengz.tencentim.bean.modle.ImFileInfo;
import com.longpengz.tencentim.bean.response.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM下载最近消息记录返回参数")
public class ImGetHistoryRes extends ImResponse {

    @ApiModelProperty(value = "消息记录文件下载信息")
    private List<ImFileInfo> File;

}
