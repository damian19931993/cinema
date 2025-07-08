package com.backend.cinema.client;

import com.backend.cinema.dto.ApiNowPlayingResponse;
import com.backend.cinema.exception.MovieApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class MovieApiClientImpl implements MovieApiClient {

    private final WebClient webClient;
    private final String apiKey;
    private final String language;
    private final String region;
    private final String nowPlayingEndpoint;

    public MovieApiClientImpl(WebClient movieApiWebClient,
                              @Value("${movie.api.key}") String apiKey,
                              @Value("${movie.api.language}") String language,
                              @Value("${movie.api.region}") String region,
                              @Value("${movie.api.now-playing-endpoint}") String nowPlayingEndpoint) {
        this.webClient = movieApiWebClient;
        this.apiKey = apiKey;
        this.language = language;
        this.region = region;
        this.nowPlayingEndpoint = nowPlayingEndpoint;
    }

    @Override
    public Mono<ApiNowPlayingResponse> fetchNowPlaying(int page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(nowPlayingEndpoint)
                        .queryParam("api_key", apiKey)
                        .queryParam("language", language)
                        .queryParam("region", region)
                        .queryParam("page", page)
                        .build()
                )
                .retrieve()
                .bodyToMono(ApiNowPlayingResponse.class)
                .onErrorMap(WebClientResponseException.class,
                        ex -> new MovieApiException("Error al llamar a la API de películas: " + ex.getMessage(), ex)
                );
    }
}
