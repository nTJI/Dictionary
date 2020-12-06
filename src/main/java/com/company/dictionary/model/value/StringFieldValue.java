package com.company.dictionary.model.value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StringFieldValue extends AbstractFieldValue<String> {
    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public StringFieldValue setValue(String value) {
        this.value = value;
        return this;
    }
}