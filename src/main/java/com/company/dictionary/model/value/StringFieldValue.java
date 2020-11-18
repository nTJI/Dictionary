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
    private String presetValue;

    @Override
    public String getPresetValue() {
        return presetValue;
    }

    @Override
    public StringFieldValue setPresetValue(String presetValue) {
        this.presetValue = presetValue;
        return this;
    }
}