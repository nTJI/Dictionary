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
//@DiscriminatorValue("boolean")
//@ToString(callSuper = true)
//@JsonTypeName("radiobutton") // todo

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