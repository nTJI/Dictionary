package com.company.dictionary.model.value;


import com.company.dictionary.model.DictionaryValue;
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
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractFieldValue<T> {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;
    @Column
    private String name;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private DictionaryValue dict;

    public abstract T getValue();

    public abstract AbstractFieldValue<T> setValue(T value);
}
