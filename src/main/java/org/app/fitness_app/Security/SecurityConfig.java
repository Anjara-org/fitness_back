package org.app.fitness_app.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((request) -> request
                        .anyRequest().permitAll()
                        /*.requestMatchers("/", "/home")
                        .authenticated()
                        .requestMatchers("/signup", "/login")
                        .permitAll()
                        .requestMatchers("/ping")
                        .permitAll()
                        .requestMatchers("/users", "/users/**")
                        .hasRole(Role.ADMIN.getRole())
                        .authenticated()*/
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
