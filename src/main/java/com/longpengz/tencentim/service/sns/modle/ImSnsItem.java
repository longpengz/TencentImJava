package com.longpengz.tencentim.service.sns.modle;
import com.longpengz.tencentim.service.sns.enums.CustomItemTagEunm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "需要更新的关系链数据对象")
public class ImSnsItem {

    @ApiModelProperty(value = "（必填）需要更新的关系链数据对象数组")
    private CustomItemTagEunm Tag;

    @ApiModelProperty(value = "（必填）需要更新的关系链字段的值，Array/String/Integer")
    private Object Value;

}
