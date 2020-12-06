package com.company.dictionary.model.value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NumberFieldValue extends AbstractFieldValue<Double> {
    private Double value;

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public NumberFieldValue setValue(Double value) {
        this.value = value;
        return this;
    }
}