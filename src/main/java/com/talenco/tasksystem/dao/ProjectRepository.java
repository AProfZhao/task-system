package com.talenco.tasksystem.dao;

import com.talenco.tasksystem.domain.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 项目(包含模块)查询类
 *
 * @author echcz
 * @date 2019-04-22 11:33:48
 */
public interface ProjectRepository extends MongoRepository<Project, String> {
}
