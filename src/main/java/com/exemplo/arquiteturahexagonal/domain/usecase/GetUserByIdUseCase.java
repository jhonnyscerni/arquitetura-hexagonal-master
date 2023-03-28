package com.exemplo.arquiteturahexagonal.domain.usecase;

import com.exemplo.arquiteturahexagonal.domain.domain.Movie;
import com.exemplo.arquiteturahexagonal.domain.domain.User;
import com.exemplo.arquiteturahexagonal.domain.ports.inbound.GetUserByIdUseCasePort;
import com.exemplo.arquiteturahexagonal.domain.ports.outbound.FindMovieAdapterPort;
import com.exemplo.arquiteturahexagonal.domain.ports.outbound.GetUserByIdAdapterPort;

public class GetUserByIdUseCase implements GetUserByIdUseCasePort {
    private final FindMovieAdapterPort findMovieAdapterPort;
    private final GetUserByIdAdapterPort getUserByIdAdapterPort;

    public GetUserByIdUseCase(FindMovieAdapterPort findMovieAdapterPort, GetUserByIdAdapterPort getUserByIdAdapterPort) {
        this.findMovieAdapterPort = findMovieAdapterPort;
        this.getUserByIdAdapterPort = getUserByIdAdapterPort;
    }

    @Override
    public User execute(Long id) {
        User user = getUserByIdAdapterPort.getUser(id);
        Movie movie = findMovieAdapterPort.getMovieById(user.getFavoriteMovie().getImdbID());
        user.setFavoriteMovie(movie);

        return user;
    }
}
