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
//@DiscriminatorValue("str")
//@ToString(callSuper = true)
//@NoArgsConstructor
//@JsonTypeName("text")

@Entity
@NoArgsConstructor
@Getter
@Setter
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