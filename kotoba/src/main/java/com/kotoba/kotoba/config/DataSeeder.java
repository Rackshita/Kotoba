package com.kotoba.kotoba.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotoba.kotoba.model.Word;
import com.kotoba.kotoba.repository.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner loadWords(WordRepository wordRepository) {
        return args -> {

            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream =
                    getClass().getResourceAsStream("/n5-words-clean.json");

            List<Word> words = mapper.readValue(
                    inputStream,
                    new TypeReference<List<Word>>() {}
            );

            wordRepository.saveAll(words);

            System.out.println("✅ JLPT N5 words loaded successfully!");
        };
    }
}