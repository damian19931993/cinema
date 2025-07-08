package com.backend.cinema.controller;

import com.backend.cinema.dto.MovieDto;
import com.backend.cinema.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies/now-playing")
    public ResponseEntity<List<MovieDto>> getNowPlaying() {
        List<MovieDto> movies = movieService.getCurrentMovies();
        return ResponseEntity.ok(movies);
    }
}
