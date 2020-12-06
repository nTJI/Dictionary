package com.company.dictionary.model.field;


import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY, property = "hidden")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringFieldDefinition.class, name = "text"),
        @JsonSubTypes.Type(value = NumberFieldDefinition.class, name = "number"),
        @JsonSubTypes.Type(value = BooleanFieldDefinition.class, name = "radiobutton"),
        @JsonSubTypes.Type(value = BooleanFieldDefinition.class, name = "checkbox"),
})

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public abstract class AbstractFieldDefinition<T> {
    private String id;
    private String name;
    private DictionaryDefinition dict;

    public abstract T getPresetValue();

    public abstract AbstractFieldDefinition<T> setPresetValue(T presetValue);

    public abstract AbstractFieldValue convertToValue(DictionaryValue dictionaryValue);

    public abstract String getCreateSql();

    public abstract boolean isSupportedByType(String type);

    public static AbstractFieldDefinition getByType(String type) {
        StringFieldDefinition str = new StringFieldDefinition();
        if (str.isSupportedByType(type)) {
            return str;
        }

        NumberFieldDefinition num = new NumberFieldDefinition();
        if (num.isSupportedByType(type)) {
            return num;
        }
        return null;
    }

    public abstract T getResultForColumn(ResultSet rs, String name) throws SQLException;
}
