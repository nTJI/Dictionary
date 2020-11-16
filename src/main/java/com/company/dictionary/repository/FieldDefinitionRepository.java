package com.company.dictionary.repository;

import com.company.dictionary.model.field.AbstractFieldDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDefinitionRepository extends JpaRepository<AbstractFieldDefinition, String> {
}
