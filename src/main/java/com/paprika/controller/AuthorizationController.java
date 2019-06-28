package com.paprika.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author adam
 * @date 2019/6/28
 */
@Slf4j
@RestController
public class AuthorizationController {
    @RequestMapping("/login/oauth/authorize")
    public String authorize(@RequestParam Map<String, String> parameters){
        String authorizationCode = parameters.get("code");
        return "收到授权码：" + authorizationCode;
    }

    @RequestMapping("/login/oauth/accessToken")
    public String genAccessToken(@RequestParam Map<String, String> parameters){
        String accessToken = parameters.get("access_token");
        return "收到access_token：" + accessToken;
    }
}
