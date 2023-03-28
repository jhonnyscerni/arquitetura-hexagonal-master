package com.exemplo.arquiteturahexagonal.adapter.outbound.repository;

import com.exemplo.arquiteturahexagonal.adapter.outbound.repository.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
