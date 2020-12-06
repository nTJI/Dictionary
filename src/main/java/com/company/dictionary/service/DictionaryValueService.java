package com.company.dictionary.service;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import java.util.List;
import java.util.Optional;

public interface DictionaryValueService {
    void save(DictionaryValue dictionaryValue);

    List<DictionaryValue> getDictionaryByName(String name, Optional<DictionaryDefinition> definition);

    boolean dropById(Long id);
}
