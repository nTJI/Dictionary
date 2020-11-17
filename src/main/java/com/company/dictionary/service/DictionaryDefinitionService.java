package com.company.dictionary.service;

import com.company.dictionary.model.DictionaryDefinition;
import java.util.List;
import java.util.Optional;

public interface DictionaryDefinitionService {
    void save(DictionaryDefinition dictionaryDefinition);
    List<DictionaryDefinition> getAllDictionaries();
    Optional<DictionaryDefinition> getDictionaryById(Long id);
}
