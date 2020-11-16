package com.company.dictionary.model;

import com.company.dictionary.model.field.AbstractFieldDefinition;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "dictionary")
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class DictionaryDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "dict", cascade = CascadeType.ALL)
    private List<AbstractFieldDefinition> fieldDefinitions;
} 
