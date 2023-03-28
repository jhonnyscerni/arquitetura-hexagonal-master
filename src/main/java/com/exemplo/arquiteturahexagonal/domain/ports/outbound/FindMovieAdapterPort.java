package com.exemplo.arquiteturahexagonal.domain.ports.outbound;

import com.exemplo.arquiteturahexagonal.domain.domain.Movie;

public interface FindMovieAdapterPort {
    Movie getMovieByTitle(String title);
    Movie getMovieById(String id);
}
