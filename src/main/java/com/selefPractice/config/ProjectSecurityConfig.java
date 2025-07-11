package com.selefPractice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf(csrfConfig -> csrfConfig.disable()).authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccounts", "/myBalance", "/myloans"
                , "/myCards").authenticated().requestMatchers("/notices", "/contact", "error","/createCustomer").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource datasource) {
//
//        return new JdbcUserDetailsManager(datasource);
//    }

    @Bean
    public PasswordEncoder  passwordEncoder () {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker (){
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }


}