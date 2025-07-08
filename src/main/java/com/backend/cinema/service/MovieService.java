package com.backend.cinema.service;

import com.backend.cinema.dto.MovieDto;
import java.util.List;


public interface MovieService {
    List<MovieDto> getCurrentMovies();
}
