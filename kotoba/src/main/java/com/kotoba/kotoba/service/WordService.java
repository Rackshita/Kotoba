package com.kotoba.kotoba.service;

import com.kotoba.kotoba.model.Word;
import com.kotoba.kotoba.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<Word> getWords(int limit) {
        return wordRepository.findAll(PageRequest.of(0, limit)).getContent();
    }

}