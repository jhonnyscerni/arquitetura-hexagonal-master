package com.exemplo.arquiteturahexagonal.adapter.outbound.integration;

import com.exemplo.arquiteturahexagonal.domain.domain.Movie;
import com.exemplo.arquiteturahexagonal.domain.ports.outbound.FindMovieAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class FindMovieAdapter implements FindMovieAdapterPort {

    private final OmdbClient omdbClient;

    public FindMovieAdapter(OmdbClient omdbClient) {
        this.omdbClient = omdbClient;
    }

    @Override
    public Movie getMovieByTitle(String title) {
        return omdbClient.getMovieByName(title).toDomain();
    }

    @Override
    public Movie getMovieById(String id) {
        return omdbClient.getMovieById(id).toDomain();
    }
}
