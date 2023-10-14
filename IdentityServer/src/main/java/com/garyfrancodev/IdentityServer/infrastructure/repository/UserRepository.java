package com.garyfrancodev.IdentityServer.infrastructure.repository;

import com.garyfrancodev.IdentityServer.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
