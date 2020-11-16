package com.company.dictionary.service.impl;

import com.company.dictionary.model.field.AbstractFieldDefinition;
import com.company.dictionary.service.FieldDefinitionService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FieldDefinitionServiceImpl implements FieldDefinitionService {
    @Override
    public void save(List<AbstractFieldDefinition> fieldDefinitions) {

        System.out.println(fieldDefinitions);
    }
}
