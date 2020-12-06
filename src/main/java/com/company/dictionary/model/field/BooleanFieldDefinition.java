package com.company.dictionary.model.field;

import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Data;
import org.hibernate.cfg.NotYetImplementedException;

@Data
public class BooleanFieldDefinition extends AbstractFieldDefinition<Boolean> {
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

    // todo
    @Override
    public AbstractFieldValue convertToValue(DictionaryValue dictionaryValue) {
        throw new NotYetImplementedException();
    }

    @Override
    public String getCreateSql() {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean isSupportedByType(String type) {
        return false;
    }

    @Override
    public Boolean getResultForColumn(ResultSet rs, String name) throws SQLException {
        return null;
    }
}