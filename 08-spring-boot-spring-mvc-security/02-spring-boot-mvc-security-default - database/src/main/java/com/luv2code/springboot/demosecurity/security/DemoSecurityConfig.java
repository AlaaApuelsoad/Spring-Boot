package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // tell spring security to use JDBC authentication with our datasource
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                //any request to the app must be authenticated meaning must be logged in
                                .anyRequest().authenticated()
                )
                //customization for access denied page.
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                )                //form login customization
                .formLogin(form ->
                        form
                                //show our custom form at the request mapping
                                .loginPage("/showMyLoginPage")
                                //login form should POST data to this url for processing(check user id and password)
                                .loginProcessingUrl("/authenticateTheUser")
                                //allow every one to see login page no need to be logged in
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}
