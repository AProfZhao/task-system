package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.UserDesc;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserDesc 数据库查询类
 *
 * @author echcz
 * @date 2019-04-16 22:26:24
 */
public interface UserDescRepository extends MongoRepository<UserDesc, String> {
}
