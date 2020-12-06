package com.company.dictionary.service.impl;

import com.company.dictionary.model.DictionaryDefinition;
import com.company.dictionary.model.DictionaryValue;
import com.company.dictionary.model.field.AbstractFieldDefinition;
import com.company.dictionary.model.value.AbstractFieldValue;
import com.company.dictionary.service.DictionaryDefinitionService;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DictionaryDefinitionServiceImpl implements DictionaryDefinitionService {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ConversionService conversionService;

    public DictionaryDefinitionServiceImpl(NamedParameterJdbcTemplate jdbcTemplate,
                                           ConversionService conversionService) {
        this.jdbcTemplate = jdbcTemplate;
        this.conversionService = conversionService;
    }

    @Override
    public void save(DictionaryDefinition dictionaryDefinition) {
        if (StringUtils.isBlank(dictionaryDefinition.getName())
                || dictionaryDefinition.getFieldDefinitions().size() == 0) {
            throw new UnsupportedOperationException();
        }

        boolean isNotExist = isNotExistInSchema(dictionaryDefinition);

        if (isNotExist) {
            createTable(dictionaryDefinition);
        } else {
            throw new RuntimeException("Table with name " + dictionaryDefinition.getName() + " already exist.");
        }


        System.out.println(1);
    }

    private boolean createTable(DictionaryDefinition definition) {
        String sql = "CREATE TABLE " + definition.getName() + " ( id int PRIMARY KEY";
        for (AbstractFieldDefinition fd : definition.getFieldDefinitions()) {
            if (StringUtils.isBlank(fd.getName())) {
                throw new RuntimeException(fd.getName() + " is blank");
            }
            sql += ", " + fd.getCreateSql();
        }
        sql += ");";

        try {
            return jdbcTemplate.update(sql, Collections.emptyMap()) > 0;
        } catch (Exception e) {
            // todo error handling
            throw new RuntimeException("Exception while save table");
        }
    }

    private boolean isNotExistInSchema(DictionaryDefinition dictionaryDefinition) {
        String sql = "select * from information_schema.tables where table_schema = 'public' and table_name = :tableName";

        Map<String, String> params = new HashMap<>();
        params.put("tableName", dictionaryDefinition.getName());

        return jdbcTemplate.query(sql, params, (rs, count) -> rs.getString("table_name")).isEmpty();
    }

    @Override
    public List<String> getAllDictionaries() {
        String sql = "select * from information_schema.tables where table_schema = 'public'";
        return jdbcTemplate.query(sql, (rs, count) -> rs.getString("table_name"));
    }

    @Override
    public Optional<DictionaryDefinition> getDictionaryByName(String name) {

        String sql = "select * from information_schema.columns where table_name = :tableName";
        Map<String, String> params = new HashMap<>();
        params.put("tableName", name);
        DictionaryDefinition dict = new DictionaryDefinition();

        List<AbstractFieldDefinition> fd = jdbcTemplate.query(sql, params, (rs, count) -> {
            AbstractFieldDefinition fieldDef = AbstractFieldDefinition.getByType(rs.getString("data_type"));
            fieldDef.setName(rs.getString("column_name"));
            return fieldDef;
        });


        return Optional.of(new DictionaryDefinition()
                .setName(name)
                .setFieldDefinitions(fd));
    }

    @Override
    public Optional<DictionaryValue> convertToDictValue(Optional<DictionaryDefinition> dictionaryDefinition) {

        return dictionaryDefinition.map(d -> {
            DictionaryValue v = conversionService.convert(d, DictionaryValue.class);
            List<AbstractFieldValue> abstractFieldValues = d.getFieldDefinitions().stream()
                    .map(fd -> fd.convertToValue(v))
                    .collect(Collectors.toList());
            v.setFieldValues(abstractFieldValues);
            return v;
        });
    }
}
