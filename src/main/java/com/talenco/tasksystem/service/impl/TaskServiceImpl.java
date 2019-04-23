package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.TaskRepository;
import com.talenco.tasksystem.domain.Task;
import com.talenco.tasksystem.service.TaskService;
import com.talenco.tasksystem.util.TemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTaskByProjectAndModule(String project, String module) {
        return taskRepository.findAllByProjectAndModule(project, module);
    }

    @Override
    public boolean addTask(Task task) {
        return TemplateUtils.falseAndLogIfException(log, () -> {
            if (StringUtils.isBlank(task.getProject()) || StringUtils.isBlank(task.getModule())) {
                return false;
            }
            task.setId(null);
            taskRepository.save(task);
            return true;
        });
    }

    @Override
    public boolean setTask(Task task) {
        // todo 设置任务
        return false;
    }

    @Override
    public boolean removeTaskById(String id) {
        return TemplateUtils.falseAndLogIfException(log, () -> {
            taskRepository.deleteById(id);
            return true;
        });
    }
}
