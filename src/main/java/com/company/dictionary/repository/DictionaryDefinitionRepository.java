package com.company.dictionary.repository;

import com.company.dictionary.model.DictionaryDefinition;
import org.springframework.data.repository.CrudRepository;

public interface DictionaryDefinitionRepository extends CrudRepository<DictionaryDefinition, String> {
}
