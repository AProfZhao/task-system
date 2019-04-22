package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.UserKey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * UserKey 数据库查询类
 *
 * @author echcz
 * @date 2019-04-16 22:53:37
 */
public interface UserKeyRepository extends MongoRepository<UserKey, String> {
    Optional<UserKey> findFirstByUsername(String username);

    List<UserKey> findAllByUsernameNot(String username);
}
