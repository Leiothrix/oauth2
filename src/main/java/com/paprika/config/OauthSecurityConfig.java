package com.paprika.config;

import com.paprika.service.MyUserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author adam
 * @date 2019/6/24
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Configuration
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.requestMatchers().antMatchers(HttpMethod.OPTIONS, "/**")
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().xssProtection().disable()
                .frameOptions().sameOrigin();
    }

    /**
     * swagger-ui 加入白名单
     */
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/v2/api-docs",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/configuration/ui",
                "/swagger-resources/configuration/security",
                "/configuration/security", "/swagger-ui.html", "/webjars/**");
        webSecurity.ignoring().antMatchers("/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js");
        webSecurity.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        webSecurity.ignoring().requestMatchers(new RequestMatcher(){
            @Override
            public boolean matches(HttpServletRequest request) {
                return CorsUtils.isPreFlightRequest(request);
            }
        });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(new MyUserDetailsServiceImpl()).passwordEncoder(new BCryptPasswordEncoder());
    }
}
