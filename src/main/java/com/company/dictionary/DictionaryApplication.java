package com.company.dictionary;

import com.company.dictionary.model.AbstractFieldDefinition;
import com.company.dictionary.model.StringFieldDefinition;
import com.company.dictionary.repository.FieldRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class DictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }

    @Bean
    public CommandLineRunner getRunner(FieldRepository fieldRepository) {
        return a -> {

            fieldRepository.save(new StringFieldDefinition()
                    .setId("myId")
                    .setName("myName")
                    .setPresetValue("setPresetValue"));
            Iterable<AbstractFieldDefinition> all = fieldRepository.findAll();
            all.forEach(System.out::println);
//            System.out.println(all);
        };
    }

}
