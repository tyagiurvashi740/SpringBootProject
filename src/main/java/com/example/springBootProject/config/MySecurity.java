package com.example.springBootProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurity {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(Authorize->Authorize.requestMatchers("/api/**")
                .authenticated().anyRequest().permitAll())
                .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable);
        return security.build();
    }
}