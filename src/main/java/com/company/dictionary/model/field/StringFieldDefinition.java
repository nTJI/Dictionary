package com.company.dictionary.model.field;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class StringFieldDefinition extends AbstractFieldDefinition<String> {
    @Column
    private String presetValue;

    @Override
    public String getPresetValue() {
        return presetValue;
    }

    @Override
    public StringFieldDefinition setPresetValue(String presetValue) {
        this.presetValue = presetValue;
        return this;
    }
}