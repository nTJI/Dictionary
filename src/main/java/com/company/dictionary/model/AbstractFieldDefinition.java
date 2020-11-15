package com.company.dictionary.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "field")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Getter
@Setter
@ToString
@Accessors(chain = true)
public abstract class AbstractFieldDefinition<T> {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column()
    private String id;
    @Column
    private String name;

    public abstract T getPresetValue();

    public abstract AbstractFieldDefinition<T> setPresetValue(T presetValue);
}
