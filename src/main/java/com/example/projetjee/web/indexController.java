package com.example.projetjee.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class indexController {

    @PostMapping("/index")
    public String note(String note) {
    System.out.println(note);
        return note;
    }

    @GetMapping("/index")
    public String note(){
        return "index";
    }
}
