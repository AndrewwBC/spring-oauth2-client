package com.andrew.oauth2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    protected OAuth2LoginConfigurer<HttpSecurity> configure(HttpSecurity http) throws Exception {
        // @formatter:off
      return  http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(a -> a
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
              .oauth2Login();
        // @formatter:on
    }

}
