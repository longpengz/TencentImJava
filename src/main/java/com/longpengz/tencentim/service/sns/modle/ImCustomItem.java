package com.longpengz.tencentim.service.sns.modle;
import com.longpengz.tencentim.service.sns.enums.CustomItemTagEunm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "自定义好友数据")
public class ImCustomItem {

    @ApiModelProperty(value = "自定义好友字段的名称")
    private CustomItemTagEunm Tag;

    @ApiModelProperty(value = "自定义好友字段的值 String/Integer")
    private Object Value;
}
