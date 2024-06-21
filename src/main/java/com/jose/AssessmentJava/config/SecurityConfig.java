package com.jose.AssessmentJava.config;

import com.jose.AssessmentJava.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario = User.builder()
                .username("José").password(passwordEncoder()
                        .encode("123456")).roles("USER").build();
        UserDetails admin = User.builder()
                .username("ADMIN").password(passwordEncoder()
                        .encode("123456")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(usuario, admin);

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**")
                        .permitAll()
                        .requestMatchers("/funcionario/**")
                        .permitAll()
                        .requestMatchers("/usuarios**")
                        .permitAll()
                        .requestMatchers("/departamento/**")
                        .permitAll()
                        .requestMatchers("/h2-console**")
                        .permitAll()
                        .anyRequest().authenticated()

                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
