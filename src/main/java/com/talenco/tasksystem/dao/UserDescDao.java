package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.UserDesc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDescDao extends MongoRepository<UserDesc, String> {
}
