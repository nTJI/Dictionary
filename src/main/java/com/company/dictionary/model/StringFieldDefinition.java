package com.company.dictionary.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.ToString;

@Entity
@DiscriminatorValue("str")
@ToString(callSuper = true)
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