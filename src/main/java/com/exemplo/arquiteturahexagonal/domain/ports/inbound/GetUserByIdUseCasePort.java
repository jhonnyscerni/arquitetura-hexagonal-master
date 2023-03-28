package com.exemplo.arquiteturahexagonal.domain.ports.inbound;

import com.exemplo.arquiteturahexagonal.domain.domain.User;

public interface GetUserByIdUseCasePort {
    User execute(Long id);
}
