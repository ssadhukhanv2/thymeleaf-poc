//package com.ssadhukhanv2.thymeleafpoc.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
//
//import javax.annotation.Resource;
//
//@EnableWebSecurity
//public class AppWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Resource
//    UserDetailsService userDetailsService;
//
//    protected void configure(HttpSecurity http) throws Exception {
//        // Allows "/" to be used as unauthorized
//        http.authorizeRequests().antMatchers("/").permitAll().anyRequest()
//                .authenticated()
//                .and().formLogin().loginPage("/");
//        ;
//    }
//
//    @Bean//("encoder")
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//        //return new SCryptPasswordEncoder();
//        //return new BCryptPasswordEncoder();
//    }
//}
