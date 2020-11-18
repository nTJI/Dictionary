package com.company.dictionary.repository.value;

import com.company.dictionary.model.value.AbstractFieldValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldValueRepository extends JpaRepository<AbstractFieldValue, String> {
}
