package com.talenco.tasksystem.service;

import com.talenco.tasksystem.domain.TaskProcessInfo;

import java.util.List;
import java.util.Optional;

/**
 * 任务处理信息服务类接口
 *
 * @author echcz
 * @date 2019-04-22 16:03:57
 */
public interface TaskProcessInfoService {
    /**
     * 根据TaskProcessInfo.id获取任务处理信息
     * @return 任务处理信息
     */
    Optional<TaskProcessInfo> getTaskProcessInfoById(String id);

    /**
     * 获取Task.id对应的任务下的所有任务处理信息
     * @param task Task.id
     * @return 任务处理信息列表
     */
    List<TaskProcessInfo> getAllTaskProcessInfoByTask(String task);

    /**
     * 添加任务处理信息
     * @param taskProcessInfo 任务处理信息
     */
    boolean addTaskProcessInfo(TaskProcessInfo taskProcessInfo);

    /**
     * 根据taskProcessInfo.id设置任务处理信息
     * 将忽略空值或无效值
     * @param taskProcessInfo 任务处理信息，taskProcessInfo.id应有效
     */
    boolean setTaskProcessInfo(TaskProcessInfo taskProcessInfo);

    /**
     * 根据TaskProcessInfo.id删除任务处理信息
     * @param id TaskProcessInfo.id
     */
    boolean removeTaskProcessInfoById(String id);
}
