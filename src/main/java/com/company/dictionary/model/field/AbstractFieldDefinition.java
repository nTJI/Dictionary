package com.company.dictionary.model.field;


import com.company.dictionary.model.DictionaryDefinition;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractFieldDefinition<T> {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;
    @Column
    private String name;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private DictionaryDefinition dict;

    public abstract T getPresetValue();

    public abstract AbstractFieldDefinition<T> setPresetValue(T presetValue);
}
