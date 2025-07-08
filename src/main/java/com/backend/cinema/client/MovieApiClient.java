package com.backend.cinema.client;

import com.backend.cinema.dto.ApiNowPlayingResponse;
import reactor.core.publisher.Mono;

public interface MovieApiClient {
    Mono<ApiNowPlayingResponse> fetchNowPlaying(int page);
}
