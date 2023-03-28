package com.exemplo.arquiteturahexagonal.domain.ports.outbound;

import com.exemplo.arquiteturahexagonal.domain.domain.User;

public interface SaveUserAdapterPort {
    User saveUser(User user);
}
