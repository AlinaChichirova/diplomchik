package com.example.diplomchik.controller;


import com.example.diplomchik.model.Role;
import com.example.diplomchik.model.User;
import com.example.diplomchik.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping ("/registration")
    public String addUser(User user, Map<String, Object> model) {
       String houseroomB = user.getUsername();
       // User houseroomB=userRepository.findByUserName(user.getUsername());
        if (houseroomB != null) {
            model.put("message", "User, exists!");
            return "registration";
        } else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
            return "redirect:/login/";
        }
    }
}
