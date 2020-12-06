package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.service.DictionaryValueService;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DictionaryValueServiceImpl implements DictionaryValueService {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DictionaryValueServiceImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(DictionaryValue dictionaryValue) {
        //todo
    }

    @Override
    @SneakyThrows
    public List<DictionaryValue> getDictionaryByName(String name, Optional<DictionaryDefinition> definition) {
        String sql = "select * from " + name;
        return jdbcTemplate.query(sql, Collections.emptyMap(), (rs, count) -> {
            DictionaryValue dictionaryValue = new DictionaryValue();
            Optional<List<AbstractFieldValue>> fieldValues = definition.map(def -> def.getFieldDefinitions()
                    .stream()
                    .map(
                            field -> {
                                try {

                                    Object resultForColumn = field.getResultForColumn(rs, field.getName());
                                    AbstractFieldValue fieldValue = AbstractFieldValue.getFieldValueForType(resultForColumn);
                                    fieldValue.setName(field.getName());
                                    fieldValue.setDict(dictionaryValue);
                                    fieldValue.setId(rs.getLong("id")); //todo
                                    return fieldValue;
                                } catch (SQLException throwables) {
                                    throw new RuntimeException(throwables);
                                }
                            })
                    .collect(Collectors.toList())
            );
            dictionaryValue.setName(definition.isPresent() ? definition.get().getName() : null);
            dictionaryValue.setId(rs.getLong("id")); //todo
            fieldValues.ifPresent(dictionaryValue::setFieldValues);
            return dictionaryValue;
        });
    }

    @Override
    public boolean dropById(Long id) {
        return false;
    }
}
