//package com.ssadhukhanv2.thymeleafpoc.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class AppAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String userName = authentication.getName();
//        String userPassword = authentication.getCredentials().toString();
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
//        if (userDetails != null) {
//            if (passwordEncoder.matches(userPassword, userDetails.getPassword())) {
//                return new UsernamePasswordAuthenticationToken(userName, userPassword, userDetails.getAuthorities());
//            } else {
//                throw new BadCredentialsException("Invalid Password");
//            }
//        } else {
//            throw new BadCredentialsException("No user registered with this user");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
