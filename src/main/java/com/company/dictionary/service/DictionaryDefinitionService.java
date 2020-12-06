package com.company.dictionary.service;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import java.util.List;
import java.util.Optional;

public interface DictionaryDefinitionService {
    void save(DictionaryDefinition dictionaryDefinition);

    List<String> getAllDictionaries();

    Optional<DictionaryDefinition> getDictionaryByName(String name);

    Optional<DictionaryValue> convertToDictValue(Optional<DictionaryDefinition> dictionaryDefinition);
}
