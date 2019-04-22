package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 任务查询类
 *
 * @author echcz
 * @date 2019-04-22 11:34:29
 */
public interface TaskRepository extends MongoRepository<Task, String> {
}
