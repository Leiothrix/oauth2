package com.paprika.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author adam
 * @date 2019/6/28
 */
@Slf4j
@RestController
@Api(value = "/api/v1/oauth2", description = "授权管理接口", tags = "AuthorizationManageController")
public class AuthorizationController {
    @GetMapping("/api/v1/oauth2/login/authorize")
    public String authorize(@RequestParam Map<String, String> parameters){
        String authorizationCode = parameters.get("code");
        return "收到授权码：" + authorizationCode;
    }

    @GetMapping("/api/v1/oauth2/login/accessToken")
    public String genAccessToken(@RequestParam Map<String, String> parameters){
        String accessToken = parameters.get("access_token");
        return "收到access_token：" + accessToken;
    }
}
