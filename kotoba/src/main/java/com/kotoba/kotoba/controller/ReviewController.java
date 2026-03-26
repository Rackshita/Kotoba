package com.kotoba.kotoba.controller;

import com.kotoba.kotoba.model.ReviewWord;
import com.kotoba.kotoba.model.Word;
import com.kotoba.kotoba.repository.ReviewWordRepository;
import com.kotoba.kotoba.repository.WordRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewWordRepository reviewWordRepository;
    private final WordRepository wordRepository;

    public ReviewController(ReviewWordRepository reviewWordRepository,
                            WordRepository wordRepository) {
        this.reviewWordRepository = reviewWordRepository;
        this.wordRepository = wordRepository;
    }

    @PostMapping("/start")
    public Map<String,String> startReview(@RequestBody List<Long> wordIds) {

        for(Long id : wordIds) {

            ReviewWord rw = new ReviewWord();
            rw.setWordId(id);
            rw.setNextReview(LocalDateTime.now());
            rw.setStage(1);

            reviewWordRepository.save(rw);
        }

        return Map.of("message","Review started");
    }

    @GetMapping("/next")
    public List<Word> getNextReview() {

        List<ReviewWord> reviewWords = reviewWordRepository.findAll();

        List<Word> words = new ArrayList<>();

        for (ReviewWord rw : reviewWords) {

            Word word = wordRepository
                    .findById(rw.getWordId())
                    .orElse(null);

            if(word != null){
                words.add(word);
            }
        }

        return words;
    }
}