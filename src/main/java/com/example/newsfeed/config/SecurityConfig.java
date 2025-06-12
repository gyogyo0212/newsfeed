package com.example.newsfeed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ lambda 방식으로 수정
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/members/register", "/members/login").permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> httpBasic.disable()); // ✅ 마찬가지로 lambda 방식

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}