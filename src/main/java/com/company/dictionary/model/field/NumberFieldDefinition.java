package com.company.dictionary.model.field;

import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.model.value.NumberFieldValue;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NumberFieldDefinition extends AbstractFieldDefinition<Double> {
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

    @Override
    public AbstractFieldValue convertToValue(DictionaryValue dictionaryValue) {
        return new NumberFieldValue()
                .setName(getName())
                .setDict(dictionaryValue)
                .setValue(getPresetValue());
    }

    @Override
    public String getCreateSql() {
        return " " + getName() + " int";
    }

    @Override
    public boolean isSupportedByType(String type) {
        return "integer".equals(type);
    }

    @Override
    public Double getResultForColumn(ResultSet rs, String name) throws SQLException {
        return rs.getDouble(name);
    }
}