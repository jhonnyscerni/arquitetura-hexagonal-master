package com.exemplo.arquiteturahexagonal.domain.ports.inbound;

import com.exemplo.arquiteturahexagonal.domain.domain.User;

public interface CreateUserUseCasePort {
    User execute(User user);
}
