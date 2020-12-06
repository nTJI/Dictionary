package com.company.dictionary.model;

import com.company.dictionary.model.value.AbstractFieldValue;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class DictionaryValue {
    private Long id;
    private String name;
    private List<AbstractFieldValue> fieldValues;
}
