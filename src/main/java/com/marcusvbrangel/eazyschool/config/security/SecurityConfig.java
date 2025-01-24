package com.marcusvbrangel.eazyschool.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll())
//            .formLogin(Customizer.withDefaults())
//            .httpBasic(Customizer.withDefaults());

//        http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll())
//            .formLogin(Customizer.withDefaults())
//            .httpBasic(Customizer.withDefaults());

        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/saveMsg"))
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/test/**").permitAll()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/", "home").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/logout").permitAll()
            .requestMatchers("/assets/**").permitAll())
            .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true")
                .permitAll())
            .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll())


//            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailService() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

//        System.out.println("------------------------------------------");
//        System.out.println(encoder.encode("12345"));
//        System.out.println(encoder.encode("54321"));
//        System.out.println("------------------------------------------");

        // user  -> 12345 -> encoder -> {bcrypt}$2a$10$3NdGSIrAq1de0Ngv4uVjZOHAUdSm51Jh5TKYFQwK258iobCyvM63y
        // admin -> 54321 -> encoder -> {bcrypt}$2a$10$J3WjVYiEEqHW0RDvIj823uT.6h1TTllpfgEO1omqzDoLpktD39AMi

        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("12345")
//            .password("{bcrypt}$2a$10$3NdGSIrAq1de0Ngv4uVjZOHAUdSm51Jh5TKYFQwK258iobCyvM63y")
            .roles("USER")
            .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("54321")
//            .password("{bcrypt}$2a$10$J3WjVYiEEqHW0RDvIj823uT.6h1TTllpfgEO1omqzDoLpktD39AMi")
            .roles("USER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

}
