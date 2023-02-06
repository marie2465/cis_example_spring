package com.example.cis_example.repository;

import com.example.cis_example.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
    UserEntity findByLoginAndPassword(String login, String password);
}
