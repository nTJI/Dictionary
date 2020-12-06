package com.company.dictionary.model;

import com.company.dictionary.model.field.AbstractFieldDefinition;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DictionaryDefinition {
    private Long id;
    private String name;
    private List<AbstractFieldDefinition> fieldDefinitions;

    public void addFieldDefinition(AbstractFieldDefinition fd) {
        fieldDefinitions.add(fd);
    }
}
