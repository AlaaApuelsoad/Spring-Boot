package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //Update spring security to use JDBC
    //inject data source autoconfigured by spring boot
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        //tell spring security to use JDBC authentication with our data source
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //Restricting access to Roles
        http.authorizeHttpRequests(Configurer ->
                Configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        //use Http basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery CSRF
        //in general, not required for stateless REST APIs that use post,put, delete and patch
        http.csrf(csrf -> csrf.disable());
        
        return http.build();
    }
}
