package com.company.dictionary.controller;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.service.DictionaryDefinitionService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DictionaryController {

    private final DictionaryDefinitionService dictionaryDefinitionService;

    public DictionaryController(DictionaryDefinitionService dictionaryDefinitionService) {
        this.dictionaryDefinitionService = dictionaryDefinitionService;
    }

    @GetMapping("/dicts")
    public String getDicts(Model model) {
        model.addAttribute("dicts", dictionaryDefinitionService.getAllDictionaries());
        return "dicts";
    }

    @GetMapping("/dicts/{id}")
    public String getDictInfo(@PathVariable("id") Long id, Model model) {
        //todo
        Optional<DictionaryDefinition> dictionaryById = dictionaryDefinitionService.getDictionaryById(id);



        return null;
    }
}
