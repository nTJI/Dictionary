package com.company.dictionary;

import com.company.dictionary.repository.DictionaryDefinitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }

    @Bean
    public CommandLineRunner getRunner(DictionaryDefinitionRepository dictionaryDefinitionRepository) {
        return a -> {

        };
    }

}
