package com.company.dictionary.model.field;

import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.model.value.StringFieldValue;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class StringFieldDefinition extends AbstractFieldDefinition<String> {
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

    @Override
    public AbstractFieldValue convertToValue(DictionaryValue dictionaryValue) {
        return new StringFieldValue()
                .setName(getName())
                .setDict(dictionaryValue)
                .setValue(getPresetValue());
    }

    @Override
    public String getCreateSql() {
        return " " + getName() + " varchar(255)";
    }

    @Override
    public boolean isSupportedByType(String type) {
        return "character varying".equals(type);
    }

    @Override
    @SneakyThrows
    public String getResultForColumn(ResultSet rs, String col) throws SQLException {
        return rs.getString(col);
    }
}