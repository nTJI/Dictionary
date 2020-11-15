package com.company.dictionary.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.ToString;

@Entity
@DiscriminatorValue("double")
@ToString(callSuper = true)
public class NumberFieldDefinition extends AbstractFieldDefinition<Double> {
    @Column
    private Double presetValue;

    @Override
    public Double getPresetValue() {
        return presetValue;
    }

    @Override
    public NumberFieldDefinition setPresetValue(Double presetValue) {
        this.presetValue = presetValue;
        return this;
    }
}