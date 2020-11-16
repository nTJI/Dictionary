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