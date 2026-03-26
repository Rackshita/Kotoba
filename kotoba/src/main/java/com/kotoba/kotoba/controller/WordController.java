package com.kotoba.kotoba.controller;

import com.kotoba.kotoba.model.Word;
import com.kotoba.kotoba.repository.ReviewWordRepository;
import com.kotoba.kotoba.repository.WordRepository;
import com.kotoba.kotoba.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {

    @Autowired
    private WordService wordService;

    @Autowired
    private ReviewWordRepository reviewWordRepository;

    @Autowired
    private WordRepository wordRepository;


    @GetMapping("/n5/words")
    public List<Word> getN5Words(@RequestParam(defaultValue = "10") int limit) {
        return wordService.getWords(limit);
    }

}