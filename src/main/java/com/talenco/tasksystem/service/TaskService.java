package com.talenco.tasksystem.service;

import com.talenco.tasksystem.domain.Task;

import java.util.List;
import java.util.Optional;

/**
 * 任务服务类接口
 *
 * @author echcz
 * @date 2019-04-22 15:43:23
 */
public interface TaskService {
    /**
     * 根据Task.id获取任务信息
     * @param id Task.id
     * @return 任务信息
     */
    Optional<Task> getTaskById(String id);

    /**
     * 根据Project.id与模块名获取任务信息
     * @param project Project.id
     * @param module 模块名
     * @return 任务信息列表
     */
    List<Task> getAllTaskByProjectAndModule(String project, String module);

    /**
     * 添加任务信息
     * @param task 任务信息
     */
    boolean addTask(Task task);

    /**
     * 根据task.id设置任务信息
     * 空值或无效值将被忽略
     * @param task 任务信息，task.id应有效
     */
    boolean setTask(Task task);

    /**
     * 根据Task.id删除任务信息
     * @param id Task.id
     */
    boolean removeTaskById(String id);
}
