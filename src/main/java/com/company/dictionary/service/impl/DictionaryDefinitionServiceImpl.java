package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.field.AbstractFieldDefinition;
import com.company.dictionary.service.DictionaryDefinitionService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DictionaryDefinitionServiceImpl implements DictionaryDefinitionService {
    @Override
    public void save(DictionaryDefinition dictionaryDefinition) {
        System.out.println(dictionaryDefinition);
    }
}
