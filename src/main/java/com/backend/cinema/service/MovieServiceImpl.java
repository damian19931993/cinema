package com.backend.cinema.service;

import com.backend.cinema.client.MovieApiClient;
import com.backend.cinema.dto.ApiNowPlayingResponse;
import com.backend.cinema.dto.MovieDto;
import com.backend.cinema.exception.MovieApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private static final int MAX_RESULTS = 20;
    private final MovieApiClient apiClient;

    public MovieServiceImpl(MovieApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public List<MovieDto> getCurrentMovies() {
        try {
            ApiNowPlayingResponse resp = apiClient.fetchNowPlaying(1).block();
            if (resp == null || resp.getResults() == null) {
                throw new MovieApiException("Respuesta vacía de la API de películas");
            }
            return resp.getResults().stream()
                    .limit(MAX_RESULTS)
                    .map(m -> new MovieDto(
                            m.getId(),
                            m.getTitle(),
                            m.getOverview(),
                            m.getReleaseDate()
                    ))
                    .collect(Collectors.toList());
        } catch (MovieApiException e) {
            throw e;
        } catch (Exception e) {
            throw new MovieApiException("Error obteniendo la cartelera: " + e.getMessage(), e);
        }
    }
}
