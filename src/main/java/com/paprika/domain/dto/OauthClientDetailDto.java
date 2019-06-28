package com.paprika.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author adam
 * @date 2019/6/28
 */
@Data
@ApiModel("OAuth应用登记信息")
public class OauthClientDetailDto {
    @ApiModelProperty(value="第三方应用ID", name="clientId", required = true)
    private String clientId;

    @ApiModelProperty(value="授权类型", name="authorizedGrantTypes", required = true)
    private String authorizedGrantTypes;

    @ApiModelProperty(value="第三方应用密钥", name="clientSecret", required = true)
    private String clientSecret;

    @ApiModelProperty(value="授权范围", name="scope", required = true)
    private String scope;

    @ApiModelProperty(value="发放授权码重定向URL", name="webServerRedirectUri", required = true)
    private String webServerRedirectUri;
}
