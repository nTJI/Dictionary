package com.company.dictionary.model.value;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class StringFieldValue extends AbstractFieldValue<String> {
    @Column
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