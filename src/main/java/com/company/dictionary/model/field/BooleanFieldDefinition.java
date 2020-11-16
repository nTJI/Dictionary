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