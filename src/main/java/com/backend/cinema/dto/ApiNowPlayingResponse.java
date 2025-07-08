package com.backend.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ApiNowPlayingResponse {
    private int page;
    private List<ApiMovieDto> results;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_results")
    private int totalResults;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ApiMovieDto> getResults() {
        return results;
    }

    public void setResults(List<ApiMovieDto> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
