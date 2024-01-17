package com.example.diplomchik;


import com.example.diplomchik.model.Person;
import com.example.diplomchik.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String greeting(@RequestParam Map<String, Object> model){
        return "greeting";
    }
    @GetMapping("/main")
    public String main (Map<String, Object> model){
        Iterable<Person>persons=personRepository.findAll();
        model.put("persons",persons);
        return  "main";
    }

    @PostMapping("main")
    public String add(@RequestParam String te, @RequestParam String tag, Map<String, Object> model){
        Person person=new Person(te,tag);
        personRepository.save(person);
        Iterable<Person>persons=personRepository.findAll();
        model.put("persons",persons);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Person> persons;
        if (filter!=null && filter.isEmpty()){
        persons=personRepository.findByTag(filter);
        } else {
           persons=personRepository.findAll();
        }
        model.put("persons",persons);
        return "main";
    }
}
