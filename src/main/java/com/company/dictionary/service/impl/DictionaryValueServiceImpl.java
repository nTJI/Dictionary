package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.repository.value.DictionaryValueRepository;
import com.company.dictionary.repository.value.FieldValueRepository;
import com.company.dictionary.service.DictionaryValueService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DictionaryValueServiceImpl implements DictionaryValueService {

    private final DictionaryValueRepository dictionaryValueRepository;
    private final FieldValueRepository fieldValueRepository;

    public DictionaryValueServiceImpl(DictionaryValueRepository dictionaryValueRepository, FieldValueRepository fieldValueRepository) {
        this.dictionaryValueRepository = dictionaryValueRepository;
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
}
