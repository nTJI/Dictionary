package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.repository.DictionaryDefinitionRepository;
import com.company.dictionary.repository.FieldDefinitionRepository;
import com.company.dictionary.service.DictionaryDefinitionService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryDefinitionServiceImpl implements DictionaryDefinitionService {

    private final DictionaryDefinitionRepository dictionaryDefinitionRepository;
    private final FieldDefinitionRepository fieldDefinitionRepository;
    private final ConversionService conversionService;

    public DictionaryDefinitionServiceImpl(DictionaryDefinitionRepository dictionaryDefinitionRepository,
                                           FieldDefinitionRepository fieldDefinitionRepository,
                                           ConversionService conversionService) {
        this.dictionaryDefinitionRepository = dictionaryDefinitionRepository;
        this.fieldDefinitionRepository = fieldDefinitionRepository;
        this.conversionService = conversionService;
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

    @Override
    public Optional<DictionaryValue> convertToDictValue(Optional<DictionaryDefinition> dictionaryDefinition) {
        return dictionaryDefinition.map(d -> {
            DictionaryValue v = conversionService.convert(d, DictionaryValue.class);
            List<AbstractFieldValue> abstractFieldValues = d.getFieldDefinitions().stream()
                    .map(fd -> fd.convertToValue(v))
                    .collect(Collectors.toList());
            v.setFieldValues(abstractFieldValues);
            return v;
        });
    }
}
