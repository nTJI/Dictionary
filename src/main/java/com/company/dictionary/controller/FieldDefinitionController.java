package com.company.dictionary.controller;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.service.DictionaryDefinitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FieldDefinitionController {

    private final DictionaryDefinitionService dictionaryDefinitionService;

    public FieldDefinitionController(DictionaryDefinitionService dictionaryDefinitionService) {
        this.dictionaryDefinitionService = dictionaryDefinitionService;
    }


    @GetMapping("/")
    public String getMain() {
        return "redirect:/createDict";
    }

    @GetMapping("/createDict")
    public String createDict(Model model) {
        return "createDict";
    }

    @PostMapping("/post")
    @ResponseBody
    public String getData(@RequestBody DictionaryDefinition dictionaryDefinition, Model model) {
        dictionaryDefinitionService.save(dictionaryDefinition);
        return "redirect to dicts";
    }
}
