package com.longpengz.tencentim.bean.modle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "地理位置消息")
public class LocationMsgContent extends MsgContent{

    @ApiModelProperty(value = "地理位置描述信息")
    private String Desc;

    @ApiModelProperty(value = "经度")
    private Double Longitude;

    @ApiModelProperty(value = "纬度")
    private Double Latitude;


}
