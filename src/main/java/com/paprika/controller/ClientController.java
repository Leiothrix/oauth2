package com.paprika.controller;

import com.paprika.common.BooleanWrapper;
import com.paprika.dao.OauthClientDetailRepository;
import com.paprika.domain.OauthClientDetailInfo;
import com.paprika.domain.dto.OauthClientDetailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adam
 * @date 2019/7/1
 */
@RestController
@Slf4j
@Api(value = "/api/v1/oauth2", description = "第三方应用管理接口", tags = "ClientManageController")
public class ClientController {

    private OauthClientDetailRepository oauthClientDetailRepository;

    @Autowired
    public ClientController(OauthClientDetailRepository oauthClientDetailRepository){
        this.oauthClientDetailRepository = oauthClientDetailRepository;
    }

    @ApiOperation(value = "保存第三方应用登记信息")
    @PostMapping("/api/v1/oauth2/registration")
    @ResponseBody
    public BooleanWrapper saveRegistrationInfo(@RequestBody @ApiParam(name = "OauthClientDetailDto", value = "需要保存的登记信息", required = true)
                                                           OauthClientDetailDto oauthClientDetailDto){
           BooleanWrapper response = new BooleanWrapper();
           try{
               OauthClientDetailInfo oauthClientDetailInfo = new OauthClientDetailInfo();
               oauthClientDetailInfo.setClientId(oauthClientDetailDto.getClientId());
               oauthClientDetailInfo.setAuthorizedGrantTypes(oauthClientDetailDto.getAuthorizedGrantTypes());
               oauthClientDetailInfo.setClientSecret(oauthClientDetailDto.getClientSecret());
               oauthClientDetailInfo.setScope(oauthClientDetailDto.getScope());
               oauthClientDetailInfo.setWebServerRedirectUri(oauthClientDetailDto.getWebServerRedirectUri());
               oauthClientDetailRepository.save(oauthClientDetailInfo);
           }
           catch (Exception e){
               log.error("保存第三方应用登记信息出现异常", e);
               response.setCode(BooleanWrapper.FAIL_CODE);
               response.setMessage(e.getMessage());
           }
           return response;
    }
}
