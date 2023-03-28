package com.exemplo.arquiteturahexagonal.adapter.outbound.repository;

import com.exemplo.arquiteturahexagonal.domain.domain.User;
import com.exemplo.arquiteturahexagonal.domain.ports.outbound.SaveUserAdapterPort;
import com.exemplo.arquiteturahexagonal.adapter.outbound.repository.entities.UserEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SaveUserAdapter implements SaveUserAdapterPort {

    private final UserRepository userRepository;

    public SaveUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setFavoriteMovieId(user.getFavoriteMovie().getImdbID());

        user.setId(userRepository.save(userEntity).getId());

        return user;
    }

}
