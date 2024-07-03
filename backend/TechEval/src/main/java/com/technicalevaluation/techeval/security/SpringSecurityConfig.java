package com.technicalevaluation.techeval.security;

import com.technicalevaluation.techeval.security.filter.JwtAuthenticationFilter;
import com.technicalevaluation.techeval.security.filter.JwtValidationFilter;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 *
 * @author adan_ga
 */
@Configuration
public class SpringSecurityConfig {
    
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    
    @Bean
    AuthenticationManager authenticationManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(authz -> authz              
            .requestMatchers(HttpMethod.GET, "/api/pokemon").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/pokemon/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/login").permitAll()
            .requestMatchers(HttpMethod.GET, "/catalog").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/catalog").hasAnyRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/catalog/*").hasAnyRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/catalog/*").hasAnyRole("ADMIN")
            .anyRequest().authenticated())
            .cors(cors -> cors.configurationSource(configurationSource()))
            .addFilter(new JwtAuthenticationFilter(this.authenticationManager()))
            .addFilter(new JwtValidationFilter(this.authenticationManager()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
    }
    
    @Bean
    CorsConfigurationSource configurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE"));
        config.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));
        config.setAllowCredentials(Boolean.TRUE);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    
    /*@Bean 
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(
                new CorsFilter(this.configurationSource()), null);
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }*/
            
}
