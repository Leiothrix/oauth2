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
import org.springframework.web.bind.annotation.*;

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
    public ClientController(OauthClientDetailRepository oauthClientDetailRepository) {
        this.oauthClientDetailRepository = oauthClientDetailRepository;
    }

    @ApiOperation(value = "保存第三方应用登记信息")
    @PostMapping("/api/v1/oauth2/registration")
    @ResponseBody
    public BooleanWrapper<Void> saveRegistrationInfo(@RequestBody @ApiParam(name = "OauthClientDetailDto", value = "需要保存的登记信息", required = true)
                                                           OauthClientDetailDto oauthClientDetailDto){
           BooleanWrapper<Void> response = new BooleanWrapper<>();
           try{
               OauthClientDetailInfo oauthClientDetailInfo = new OauthClientDetailInfo();
               String  clientId = oauthClientDetailDto.getClientId();
               if(clientId != null){
                   if("".equals(clientId)){
                       response.setCode(BooleanWrapper.FAIL_CODE);
                       response.setMessage("应用ID不可为空字符串");
                       return response;
                   }
                   if(oauthClientDetailRepository.existsById(clientId)){
                       response.setCode(BooleanWrapper.FAIL_CODE);
                       response.setMessage("该应用ID已被占用");
                       return response;
                   }
               }
               oauthClientDetailInfo.setClientId(clientId);
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

    @ApiOperation(value = "删除第三方应用登记信息")
    @DeleteMapping("/api/v1/oauth2/registration/{clientId}")
    @ResponseBody
    public BooleanWrapper deleteRegistrationInfo(@ApiParam(name = "clientId", value = "第三方应用ID", required = true)
                                                     @RequestParam(value = "clientId") String clientId) {
        BooleanWrapper<Void> response = new BooleanWrapper<>();
        try {
            oauthClientDetailRepository.deleteById(clientId);
        }
        catch (Exception e) {
            log.error("删除第三方应用登记信息出现异常", e);
            response.setCode(BooleanWrapper.FAIL_CODE);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation(value = "更新第三方应用登记信息")
    @PutMapping("/api/v1/oauth2/registration/")
    @ResponseBody
    public BooleanWrapper updateRegistrationInfo(@RequestBody @ApiParam(name = "OauthClientDetailDto", value = "需要更新的登记信息", required = true)
                                                             OauthClientDetailDto oauthClientDetailDto) {
        BooleanWrapper<Void> response = new BooleanWrapper<>();
        try {
            OauthClientDetailInfo oauthClientDetailInfo = new OauthClientDetailInfo();
            String  clientId = oauthClientDetailDto.getClientId();
            if(clientId != null && oauthClientDetailRepository.existsById(clientId)){
                oauthClientDetailInfo.setClientId(clientId);
                oauthClientDetailInfo.setAuthorizedGrantTypes(oauthClientDetailDto.getAuthorizedGrantTypes());
                oauthClientDetailInfo.setClientSecret(oauthClientDetailDto.getClientSecret());
                oauthClientDetailInfo.setScope(oauthClientDetailDto.getScope());
                oauthClientDetailInfo.setWebServerRedirectUri(oauthClientDetailDto.getWebServerRedirectUri());
                oauthClientDetailRepository.save(oauthClientDetailInfo);
            }else {
                response.setCode(BooleanWrapper.FAIL_CODE);
                response.setMessage("应用ID非法");
                return response;
            }
        }
        catch (Exception e) {
            log.error("更新第三方应用登记信息出现异常", e);
            response.setCode(BooleanWrapper.FAIL_CODE);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation(value = "查询第三方应用登记信息")
    @GetMapping("/api/v1/oauth2/registration/{clientId}")
    @ResponseBody
    public BooleanWrapper<OauthClientDetailInfo> queryRegistrationInfo(@ApiParam(name = "clientId", value = "第三方应用ID", required = true)
                                                    @RequestParam(value = "clientId") String clientId){
        BooleanWrapper<OauthClientDetailInfo> response = new BooleanWrapper<>();
        try {
            response.setData(oauthClientDetailRepository.findByClientId(clientId));
        }catch (Exception e){
            log.error("保存第三方应用登记信息出现异常", e);
            response.setCode(BooleanWrapper.FAIL_CODE);
            response.setMessage(e.getMessage());
        }
        return response;
    }

}
