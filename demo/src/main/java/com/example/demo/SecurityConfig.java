package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                configurer -> configurer.anyRequest().authenticated()
        )
                //.formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());

        return chainBuilder.build();
    }

}
/*
Fehlermeldung:
[invalid_token_response] An error occurred while attempting to retrieve the OAuth 2.0 Access Token Response:
Error while extracting response for type
[class org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse]
and content type
[application/json;charset=utf-8]
 */