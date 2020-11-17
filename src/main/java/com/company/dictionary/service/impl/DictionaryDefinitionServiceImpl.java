package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.repository.DictionaryDefinitionRepository;
import com.company.dictionary.repository.FieldDefinitionRepository;
import com.company.dictionary.service.DictionaryDefinitionService;
import java.util.List;
import java.util.Optional;
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
    }

    @Override
    public List<DictionaryDefinition> getAllDictionaries() {
        return dictionaryDefinitionRepository.findAll();
    }

    @Override
    public Optional<DictionaryDefinition> getDictionaryById(Long id) {
        return dictionaryDefinitionRepository.findById(id);
    }
}
