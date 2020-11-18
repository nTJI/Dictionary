package com.company.dictionary.model;

import com.company.dictionary.model.value.AbstractFieldValue;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Table(name = "dictionary_value")
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class DictionaryValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "dict")
    private List<AbstractFieldValue> fieldValues;
}