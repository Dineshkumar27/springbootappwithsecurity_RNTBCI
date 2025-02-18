package com.example.springbootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

//no hard coded users
@Bean
public UserDetailsManager userDetailsManager(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
    jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select user_id,pw,isactive from members where user_id=?"
    );
    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "select user_id,role from roles where user_id=?"
    );
    return jdbcUserDetailsManager;
}


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{

        httpSecurity.authorizeHttpRequests(configurer->
                configurer.requestMatchers(HttpMethod.GET,"/api/employee/employees").hasRole("EMPLOYEE")
                          .requestMatchers(HttpMethod.GET,"/api/employee/employees/**").hasRole("EMPLOYEE")
                          .requestMatchers(HttpMethod.POST,"/api/employee/employees").hasRole("MANAGER")
                          .requestMatchers(HttpMethod.PUT,"/api/employee/employees").hasRole("MANAGER")
                          .requestMatchers(HttpMethod.DELETE,"/api/employee/employees/**").hasRole("ADMIN"));
        //basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

//        disable Cross Site Reference Forgery
        //actually it is not required for stateless HTTP requests
        httpSecurity.csrf(csrf->csrf.disable());

        return  httpSecurity.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails dinesh = User.builder()
//                .username("dinesh")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails manish = User.builder()
//                .username("manish")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails ishan = User.builder()
//                .username("ishan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(dinesh,ishan,manish);
//    }
}