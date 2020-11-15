package com.company.dictionary.repository;

import com.company.dictionary.model.AbstractFieldDefinition;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FieldRepository extends CrudRepository<AbstractFieldDefinition, String> {



}
