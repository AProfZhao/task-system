package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.History;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 历史数据查询类
 *
 * @author echcz
 * @date 2019-04-22 11:33:07
 */
public interface HistoryRepository extends MongoRepository<History, String> {
}
