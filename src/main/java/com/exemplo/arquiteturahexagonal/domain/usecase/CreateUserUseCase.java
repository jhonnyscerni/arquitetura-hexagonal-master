package com.exemplo.arquiteturahexagonal.domain.usecase;

import com.exemplo.arquiteturahexagonal.domain.domain.Movie;
import com.exemplo.arquiteturahexagonal.domain.domain.User;
import com.exemplo.arquiteturahexagonal.domain.ports.inbound.CreateUserUseCasePort;
import com.exemplo.arquiteturahexagonal.domain.ports.outbound.FindMovieAdapterPort;
import com.exemplo.arquiteturahexagonal.domain.ports.outbound.SaveUserAdapterPort;

public class CreateUserUseCase implements CreateUserUseCasePort {

    private final FindMovieAdapterPort findMovieAdapterPort;
    private final SaveUserAdapterPort saveUserAdapterPort;

    public CreateUserUseCase(FindMovieAdapterPort findMovieAdapterPort, SaveUserAdapterPort saveUserAdapterPort) {
        this.findMovieAdapterPort = findMovieAdapterPort;
        this.saveUserAdapterPort = saveUserAdapterPort;
    }

    @Override
    public User execute(User user) {
        Movie movie = findMovieAdapterPort.getMovieByTitle(user.getFavoriteMovie().getTitle());
        user.setFavoriteMovie(movie);

        return saveUserAdapterPort.saveUser(user);
    }
}
