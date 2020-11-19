package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.repository.DictionaryDefinitionRepository;
import com.company.dictionary.repository.FieldDefinitionRepository;
import com.company.dictionary.repository.value.DictionaryValueRepository;
import com.company.dictionary.repository.value.FieldValueRepository;
import com.company.dictionary.service.DictionaryValueService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DictionaryValueServiceImpl implements DictionaryValueService {

    private final DictionaryDefinitionRepository dictionaryDefinitionRepository;
    private final DictionaryValueRepository dictionaryValueRepository;
    private final FieldDefinitionRepository fieldDefinitionRepository;
    private final FieldValueRepository fieldValueRepository;

    public DictionaryValueServiceImpl(DictionaryDefinitionRepository dictionaryDefinitionRepository,
                                      DictionaryValueRepository dictionaryValueRepository,
                                      FieldDefinitionRepository fieldDefinitionRepository,
                                      FieldValueRepository fieldValueRepository) {
        this.dictionaryDefinitionRepository = dictionaryDefinitionRepository;
        this.dictionaryValueRepository = dictionaryValueRepository;
        this.fieldDefinitionRepository = fieldDefinitionRepository;
        this.fieldValueRepository = fieldValueRepository;
    }


    @Override
    public void save(DictionaryValue dictionaryValue) {

        dictionaryValueRepository.save(dictionaryValue);
        fieldValueRepository.saveAll(dictionaryValue.getFieldValues());

        System.out.println(1);
    }

    @Override
    public List<DictionaryValue> getDictionaryByName(String name) {
        return dictionaryValueRepository.findAllByName(name);
    }

    @Override
    public boolean dropById(Long id) {
        Optional<DictionaryValue> value = dictionaryValueRepository.findById(id);
        value.ifPresent( dict -> {
            dict.getFieldValues().forEach(
                    fieldValueRepository::delete
            );
            dictionaryValueRepository.delete(dict);
        });

        //definition
        Optional<DictionaryDefinition> definition = dictionaryDefinitionRepository.findById(id);
        definition.ifPresent( dict -> {
            dict.getFieldDefinitions().forEach(
                    fieldDefinitionRepository::delete
            );
            dictionaryDefinitionRepository.delete(dict);
        });
        return true;
    }
}
