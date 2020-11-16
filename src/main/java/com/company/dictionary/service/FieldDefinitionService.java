package com.company.dictionary.service;

import com.company.dictionary.model.field.AbstractFieldDefinition;
import java.util.List;

public interface FieldDefinitionService {
    void save(List<AbstractFieldDefinition> fieldDefinitions) ;
}
