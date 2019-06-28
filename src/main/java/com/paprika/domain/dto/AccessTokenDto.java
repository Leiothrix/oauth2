package com.paprika.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author adam
 * @date 2019/6/28
 */
@Data
@ApiModel("返回access_token信息的实体")
public class AccessTokenDto {
    @ApiModelProperty(value="访问令牌", name="accessToken")
    private String accessToken;

    @ApiModelProperty(value="授权范围", name="scope")
    private String scope;

    @ApiModelProperty(value="令牌过期时间", name="expiresTime")
    private String expiresTime;

    @ApiModelProperty(value="令牌类型", name="tokenType")
    private String tokenType;
}
