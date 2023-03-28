package com.exemplo.arquiteturahexagonal.config;

import com.exemplo.arquiteturahexagonal.domain.ports.inbound.CreateUserUseCasePort;
import com.exemplo.arquiteturahexagonal.domain.ports.inbound.GetUserByIdUseCasePort;
import com.exemplo.arquiteturahexagonal.domain.usecase.CreateUserUseCase;
import com.exemplo.arquiteturahexagonal.domain.usecase.GetUserByIdUseCase;
import com.exemplo.arquiteturahexagonal.adapter.outbound.integration.FindMovieAdapter;
import com.exemplo.arquiteturahexagonal.adapter.outbound.repository.GetUserByIdAdapter;
import com.exemplo.arquiteturahexagonal.adapter.outbound.repository.SaveUserAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateUserUseCasePort createUserUseCasePort(FindMovieAdapter omdbIntegration, SaveUserAdapter saveUserAdapter) {
        return new CreateUserUseCase(omdbIntegration, saveUserAdapter);
    }

    @Bean
    public GetUserByIdUseCasePort getUserByIdUseCasePort(FindMovieAdapter omdbIntegration, GetUserByIdAdapter getUserByIdAdapter) {
        return new GetUserByIdUseCase(omdbIntegration, getUserByIdAdapter);
    }

}
