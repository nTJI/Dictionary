package com.company.dictionary.converter;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromDictionaryDefinitionToDictionaryValue
        implements Converter<DictionaryDefinition, DictionaryValue> {

    @Override
    public DictionaryValue convert(DictionaryDefinition dictionaryDefinition) {
        return new DictionaryValue()
                .setName(dictionaryDefinition.getName())
                .setFieldValues(null);
    }
}
