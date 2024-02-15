package org.app.fitness_app.Security;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.app.fitness_app.Security.SecurityModel.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
