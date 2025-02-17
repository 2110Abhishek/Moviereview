package com.example.moviereview.service;

import com.example.moviereview.model.Movie;
import com.example.moviereview.model.Review;
import com.example.moviereview.repository.MovieRepository;
import com.example.moviereview.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public Review addReview(Long movieId, Review review) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        review.setMovie(movie);
        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        review.setComment(updatedReview.getComment());
        review.setRating(updatedReview.getRating());
        return reviewRepository.save(review);
    }
}
