package com.example.moviereview.controller;

import com.example.moviereview.model.Movie;
import com.example.moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
    movieService.deleteMovie(id);
    return ResponseEntity.ok("Movie deleted successfully.");
}

}
