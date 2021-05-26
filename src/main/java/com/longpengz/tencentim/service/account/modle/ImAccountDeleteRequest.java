package com.longpengz.tencentim.service.account.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.util.StringUtils;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "IM删除用户（多个）请求参数")
public class ImAccountDeleteRequest {

    @ApiModelProperty(value = "请求删除的帐号对象数组，单次请求最多支持100个帐号")
    private List<ImAccountDeleteItem> DeleteItem;

}
