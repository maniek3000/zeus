package com.maciejopolski.module.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping({"/", "/index","/index.html"})
    // może być @GetMapping a w nawiasie może być sam ("/")
    public String getHome(Model model){

        //string
        model.addAttribute("name", "Maciej");

        //object
        PersonDto person = new PersonDto(
                "Maciej",
                "Opolski",
                33
        );
        model.addAttribute("person", person);

        //lista obiektów
        List<PersonDto> persons = List.of(
                new PersonDto("pierwszy", "jedenasty", 11),
                new PersonDto("drugi", "dwunasty", 12),
                new PersonDto("trzeci", "trzynasty", 13)
        );
        model.addAttribute("persons", persons);

        return "home";
    }
}

