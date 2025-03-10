package com.milkdelivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Allow all requests without authentication
            .csrf(csrf -> csrf.disable())  // Disable CSRF (only for development)
            .formLogin(form -> form.disable()) // Disable login form
            .httpBasic(httpBasic -> httpBasic.disable()); // Disable basic authentication

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { // Return exact BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }
}


//package com.milkdelivery.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}




//package com.milkdelivery.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Allow all requests without authentication
//            .csrf(csrf -> csrf.disable())  // Disable CSRF (only for development)
//            .formLogin(form -> form.disable()) // Disable login form
//            .httpBasic(httpBasic -> httpBasic.disable()); // Disable basic authentication
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
