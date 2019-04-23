package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.TaskProcessInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 任务处理信息查询类
 *
 * @author echcz
 * @date 2019-04-22 11:34:10
 */
public interface TaskProcessInfoRepository extends MongoRepository<TaskProcessInfo, String> {
    List<TaskProcessInfo> findAllByTask(String task);
}
