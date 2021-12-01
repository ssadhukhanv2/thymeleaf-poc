package com.ssadhukhanv2.thymeleafpoc.controller;

import com.ssadhukhanv2.thymeleafpoc.model.User;
import com.ssadhukhanv2.thymeleafpoc.repositories.UserRepository;
//import com.ssadhukhanv2.thymeleafpoc.security.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

//    @Autowired
//    private AppUserDetailsService appUserDetailsService;
//

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/index")
    public String indexPage(
            @ModelAttribute(name = "loginFormUser")
                    User loginFormUser,
            @ModelAttribute(name = "registrationFormUser")
                    User registrationFormUser,
            BindingResult bindingResult, Model model) {
        return "login-register";
    }

    @GetMapping("/")
    public String index(
            @ModelAttribute(name = "loginFormUser")
                    User loginFormUser,
            @ModelAttribute(name = "registrationFormUser")
                    User registrationFormUser,
            BindingResult bindingResult, Model model) {
        return "login-register";
    }

    @PostMapping("/authenticate-user")
    public String authenticate(
            @ModelAttribute(name = "loginFormUser")
            @Valid User loginFormUser,
            BindingResult resultForLoginFormUser,
            @ModelAttribute(name = "registrationFormUser")
                    User registrationFormUser,
            BindingResult resultForRegistrationFormUser, Model model) {
        if (resultForLoginFormUser.hasErrors()) {
            return "login-register";
        }


        List<User> userList = userRepository.findByUserName(loginFormUser.getUserName());
        if (null != userList && userList.size() > 0 && userList.get(0).getUserPassword().equals(loginFormUser.getUserPassword())) {
            return "index";
        }

        model.addAttribute("loginError", true);
        return "login-register";
    }

    @PostMapping("/register-user")
    public String registerUser(
            @ModelAttribute(name = "loginFormUser")
                    User loginFormUser,
            BindingResult resultForLoginFormUser,
            @ModelAttribute(name = "registrationFormUser")
            @Valid User registrationFormUser,
            BindingResult resultForRegistrationFormUser,
            Model model) {
        if (resultForRegistrationFormUser.hasErrors()) {
            return "login-register";
        }
        try {
            // userRepository=null
            // If by some means userRepository is null then a validation would be triggered.
            // We tapped this issue to add model attribute "registrationError" to true.
            // This would display error on the UI
            userRepository.save(registrationFormUser);
        } catch (Exception e) {
            //Very Bad Code here. Later change how exceptions are handled.
            model.addAttribute("registrationError", true);
        }
        return "login-register";
    }

    @GetMapping("/signup")
    public String signUp(@Valid User user, BindingResult result, Model model) {
        return "login-register";
    }

    @GetMapping("/sign-in")
    public String login(Model model) {
        return "login-register";
    }
}
