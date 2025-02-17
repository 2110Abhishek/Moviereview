package com.example.moviereview.service;

import com.example.moviereview.model.Movie;
import com.example.moviereview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Fetch all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Delete a movie by ID
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found.");
        }
        movieRepository.deleteById(id);
    }
}
