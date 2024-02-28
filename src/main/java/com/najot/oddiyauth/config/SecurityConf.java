package com.najot.oddiyauth.config;

import com.najot.oddiyauth.enums.Role;
import com.najot.oddiyauth.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.najot.oddiyauth.enums.Permission.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConf {
    private final MyUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request->
                        request
                                .requestMatchers("/api/v1/admin").hasRole("ADMIN")
                                .requestMatchers("/api/v1/home").hasAnyRole(Role.ADMIN.name(),Role.USER.name())
                                .requestMatchers(HttpMethod.POST,"/api/v1/product").hasAnyAuthority(CREATE_PRODUCT.name())
                                .requestMatchers(HttpMethod.PUT,"/api/v1/product").hasAnyAuthority(UPDATE_PRODUCT.name())
                                .requestMatchers(HttpMethod.DELETE,"/api/v1/product").hasAnyAuthority(DELETE_PRODUCT.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/product").hasAuthority(READ_PRODUCT.name())
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers("/api/v1/auth/login").permitAll()
                                .requestMatchers("/api/v1/auth/login-post").permitAll()
                                .anyRequest().authenticated()
                        ).formLogin(s->{
                            s.loginPage("/api/v1/auth/login");
                        })
                ;

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
