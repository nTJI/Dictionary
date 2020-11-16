package com.company.dictionary.controller;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.field.AbstractFieldDefinition;
import com.company.dictionary.service.FieldDefinitionService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
//@RequestMapping("/")
public class FieldDefinitionController {

    private final FieldDefinitionService fieldDefinitionService;

    public FieldDefinitionController(FieldDefinitionService fieldDefinitionService) {
        this.fieldDefinitionService = fieldDefinitionService;
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
    public void getData(@RequestBody DictionaryDefinition dictionaryDefinition) {

        System.out.println(1);
//        fieldDefinitionService.save(dictionaryDefinition.getFieldDefinitions());
//        System.out.println(fieldDefinitions);
    }
}
