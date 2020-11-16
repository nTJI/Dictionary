package com.company.dictionary.model.field;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@DiscriminatorValue("double")
//@ToString(callSuper = true)
//@JsonTypeName("number")

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