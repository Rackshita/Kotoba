package com.kotoba.kotoba.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReviewWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long wordId;

    private LocalDateTime nextReview;

    private int stage;

    public ReviewWord() {}

    public Long getId() {
        return id;
    }

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }

    public LocalDateTime getNextReview() {
        return nextReview;
    }

    public void setNextReview(LocalDateTime nextReview) {
        this.nextReview = nextReview;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}