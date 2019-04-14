package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.UserKey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserKeyDao extends MongoRepository<UserKey, String> {
    Optional<UserKey> findFirstByUsername(String username);
}
