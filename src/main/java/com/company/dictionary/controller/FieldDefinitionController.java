package com.company.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class FieldDefinitionController {

    @GetMapping("/")
    public String getMain() {
        return "redirect:/createDict";
    }

    @GetMapping("/createDict")
    public String createDict(Model model){
        return "createDict";
    }
}
