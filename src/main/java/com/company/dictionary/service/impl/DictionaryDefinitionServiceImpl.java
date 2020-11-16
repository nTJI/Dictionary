package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.repository.DictionaryDefinitionRepository;
import com.company.dictionary.repository.FieldDefinitionRepository;
import com.company.dictionary.service.DictionaryDefinitionService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryDefinitionServiceImpl implements DictionaryDefinitionService {

    private final DictionaryDefinitionRepository dictionaryDefinitionRepository;
    private final FieldDefinitionRepository fieldDefinitionRepository;

    public DictionaryDefinitionServiceImpl(DictionaryDefinitionRepository dictionaryDefinitionRepository,
                                           FieldDefinitionRepository fieldDefinitionRepository) {
        this.dictionaryDefinitionRepository = dictionaryDefinitionRepository;
        this.fieldDefinitionRepository = fieldDefinitionRepository;
    }

    @Override
    public void save(DictionaryDefinition dictionaryDefinition) {
        dictionaryDefinition.getFieldDefinitions().forEach(
                def -> def.setDict(dictionaryDefinition));

        dictionaryDefinitionRepository.save(dictionaryDefinition);
        fieldDefinitionRepository.saveAll(dictionaryDefinition.getFieldDefinitions());
        System.out.println(dictionaryDefinition);
    }
}
