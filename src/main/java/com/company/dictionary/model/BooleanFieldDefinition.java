package com.company.dictionary.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.ToString;

@Entity
@DiscriminatorValue("boolean")
@ToString(callSuper = true)
public class BooleanFieldDefinition extends AbstractFieldDefinition<Boolean> {
    @Column
    private Boolean presetValue;

    @Override
    public Boolean getPresetValue() {
        return presetValue;
    }

    @Override
    public BooleanFieldDefinition setPresetValue(Boolean presetValue) {
        this.presetValue = presetValue;
        return this;
    }
}