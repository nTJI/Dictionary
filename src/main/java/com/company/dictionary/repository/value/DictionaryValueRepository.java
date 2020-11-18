package com.company.dictionary.repository.value;

import com.company.dictionary.model.DictionaryValue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryValueRepository extends JpaRepository<DictionaryValue, Long> {

    List<DictionaryValue> findAllByName(String name);
}
