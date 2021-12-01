//package com.ssadhukhanv2.thymeleafpoc.security;
//
//import com.ssadhukhanv2.thymeleafpoc.model.User;
//import com.ssadhukhanv2.thymeleafpoc.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AppUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username).get(0);
//        //https://www.javadevjournal.com/spring/spring-security-userdetailsservice/
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
//                .password(user.getUserPassword()).authorities("USER").build();
//        return userDetails;
//    }
//}
