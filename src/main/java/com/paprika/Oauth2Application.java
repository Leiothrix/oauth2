package com.paprika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import java.util.Arrays;

/**
 * @author adam
 * @date 2019/6/25
 */
@SpringBootApplication
@EnableAuthorizationServer
public class Oauth2Application {

	public static void main(String[] args) {SpringApplication.run(Oauth2Application.class, args);}

    private AuthenticationProvider authenticationProvider;

    @Autowired
    public Oauth2Application(AuthenticationProvider authenticationProvider){
	    this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }
}