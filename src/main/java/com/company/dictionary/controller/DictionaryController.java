package com.company.dictionary.controller;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.service.DictionaryDefinitionService;
import com.company.dictionary.service.DictionaryValueService;
import java.util.Collection;
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
        Optional<DictionaryDefinition> dictionaryById = dictionaryDefinitionService.getDictionaryById(id);
        DictionaryValue newDictValue = dictionaryDefinitionService.convertToDictValue(dictionaryById)
                .orElse(null);
        List<DictionaryValue> allDictValues = dictionaryValueService.getDictionaryByName(newDictValue.getName());
        List<List<AbstractFieldValue>> fieldValues = allDictValues.stream().map(dv -> dv.getFieldValues()).collect(Collectors.toList());
        List<String> fieldNames = allDictValues.stream()
                .map(dv ->
                        dv.getFieldValues().stream()
                                .map(fv -> fv.getName())
                                .collect(Collectors.toList())).findFirst().orElse(null);

//        model.addAttribute("dictValues", allDictValues);
        model.addAttribute("fieldNames", fieldNames);
        model.addAttribute("fieldValues", fieldValues);
        model.addAttribute("emptyValue", newDictValue);

        return "dictEdit";
    }

    @GetMapping("/dicts/{id}/drop")
    public String dropDictValue(@PathVariable("id") Long id, Model model) {
        dictionaryValueService.dropById(id);

        model.addAttribute("dicts", dictionaryDefinitionService.getAllDictionaries());
        return "redirect:/dicts";
    }

}
