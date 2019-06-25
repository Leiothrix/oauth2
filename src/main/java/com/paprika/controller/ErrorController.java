package com.paprika.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * @author adam
 * @date 2019/6/24
 * PS: You may say I'm a dreamer.But I'm not the only one.
 */
@Slf4j
@RestController
@SessionAttributes("authorizationRequest")
public class ErrorController {
    public String error(@RequestParam Map<String, String> parameters){
        String redirectUrl = parameters.get("redirect_uri");
        log.info("重定向到：{}", redirectUrl);
        return "redirect:" + redirectUrl + "?error=1";
    }
}
