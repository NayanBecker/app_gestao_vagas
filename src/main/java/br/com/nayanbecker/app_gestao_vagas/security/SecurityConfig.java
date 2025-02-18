package br.com.nayanbecker.app_gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    @Order(1)
    SecurityFilterChain candidateSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/candidate/**")
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/candidate/login").permitAll();
                auth.requestMatchers("/candidate/signIn").permitAll();
                auth.requestMatchers("/candidate/create").permitAll();
                auth.anyRequest().authenticated();
            })
            .formLogin(form -> form.loginPage("/candidate/login"));
        return http.build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain companySecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/company/**")
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/company/create").permitAll();
                auth.requestMatchers("/company/login").permitAll();
                auth.requestMatchers("/company/signIn").permitAll();
                auth.anyRequest().authenticated();
            })
            .formLogin(form -> form.loginPage("/company/login"));
        return http.build();
    }

    @Bean
    @Order(3)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> {
                auth.anyRequest().authenticated();
            })
            .formLogin(form -> form.loginPage("/candidate/login"));
        return http.build();
    }
}