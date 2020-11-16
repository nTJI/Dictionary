package com.company.dictionary.repository;

import com.company.dictionary.model.DictionaryDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryDefinitionRepository extends JpaRepository<DictionaryDefinition, Long> {
}
