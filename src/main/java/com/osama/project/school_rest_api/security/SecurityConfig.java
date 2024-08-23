package com.osama.project.school_rest_api.security;

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
public class SecurityConfig {

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(UserService userService){
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService); //set the custom user details service
//        auth.setPasswordEncoder(bCryptPasswordEncoder()); //set the password encoder - bcrypt
//        return auth;
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET,"/api/employees", "/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/api/students","/api/students/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/students").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/students").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/students").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/api/courses","/api/courses/**").hasRole("EMPLOYEE,STUDENT")
                    .requestMatchers(HttpMethod.POST,"/api/courses").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/courses").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/courses").hasRole("ADMIN")
                );

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

}
