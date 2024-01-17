package com.example.diplomchik.controller;


import com.example.diplomchik.model.Person;
import com.example.diplomchik.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String hello(@RequestParam Map<String, Object> model){
        return "main";
    }
    @GetMapping("/main")
    public String main (Map<String, Object> model){
        Iterable<Person>persons=personRepository.findAll();
        model.put("persons",persons);
        return  "main";
    }

    @PostMapping("main")
    public String add(@RequestParam String name, @RequestParam String middleName,@RequestParam String lastName,
                      @RequestParam String birthday, @RequestParam String gender, @RequestParam String phone,
                      @RequestParam String email, @RequestParam String sity,Map<String, Object> model){
        Person person=new Person(name, middleName,lastName,birthday,gender,phone,email,sity);
        personRepository.save(person);
        Iterable<Person>persons=personRepository.findAll();
        model.put("persons",persons);
        return "main";
    }

}
