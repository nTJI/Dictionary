package com.company.dictionary.model.field;

import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.cfg.NotYetImplementedException;

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

    //todo
    @Override
    public AbstractFieldValue convertToValue(DictionaryValue dictionaryValue) {
        throw new NotYetImplementedException();
    }
}