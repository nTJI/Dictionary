package com.company.dictionary.model.value;


import com.company.dictionary.model.DictionaryValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.cfg.NotYetImplementedException;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor

public abstract class AbstractFieldValue<T> {
    private Long id;
    private String name;
    private DictionaryValue dict;

    public abstract T getValue();

    public abstract AbstractFieldValue<T> setValue(T value);

    public static AbstractFieldValue getFieldValueForType(Object o) {
        if (o instanceof String) {
            return new StringFieldValue()
                    .setValue((String) o);
        } else if (o instanceof Number) {
            return new NumberFieldValue()
                    .setValue((Double) o);
        } else {
            throw new NotYetImplementedException();
        }
    }
}
