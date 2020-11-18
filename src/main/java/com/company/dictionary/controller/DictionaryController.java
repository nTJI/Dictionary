package com.company.dictionary.controller;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.service.DictionaryDefinitionService;
import com.company.dictionary.service.DictionaryValueService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DictionaryController {

    private final DictionaryDefinitionService dictionaryDefinitionService;
    private final DictionaryValueService dictionaryValueService;
    private final ConversionService conversionService;

    public DictionaryController(DictionaryDefinitionService dictionaryDefinitionService,
                                DictionaryValueService dictionaryValueService, ConversionService conversionService) {
        this.dictionaryDefinitionService = dictionaryDefinitionService;
        this.dictionaryValueService = dictionaryValueService;
        this.conversionService = conversionService;
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
        DictionaryValue dictionaryValue = dictionaryById.map(d -> {
            DictionaryValue v = conversionService.convert(d, DictionaryValue.class);
            List<AbstractFieldValue> abstractFieldValues = d.getFieldDefinitions().stream()
                    .map(fd -> fd.convertToValue(v))
                    .collect(Collectors.toList());
            v.setFieldValues(abstractFieldValues);
            return v;
        }).orElse(null);


        dictionaryValueService.save(dictionaryValue);

//        model.addAttribute("dictionary", dictionaryValue);


        return "dictEdit";
    }
}
