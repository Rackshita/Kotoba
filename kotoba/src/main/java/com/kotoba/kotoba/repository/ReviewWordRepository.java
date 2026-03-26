package com.kotoba.kotoba.repository;

import com.kotoba.kotoba.model.ReviewWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewWordRepository extends JpaRepository<ReviewWord, Long> {

    List<ReviewWord> findTop5ByNextReviewBefore(LocalDateTime time);

}