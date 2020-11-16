package com.company.dictionary.repository;

import com.company.dictionary.model.field.AbstractFieldDefinition;
import org.springframework.data.repository.CrudRepository;

public interface FieldRepository extends CrudRepository<AbstractFieldDefinition, String> {



}
