package com.backend.cinema.dto;

public class MovieDto {
    private Long id;
    private String title;
    private String overview;
    private String releaseDate;

    public MovieDto(Long id, String title, String overview, String releaseDate) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
