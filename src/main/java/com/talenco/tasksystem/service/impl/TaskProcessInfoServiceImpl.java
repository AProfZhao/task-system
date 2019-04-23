package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.TaskProcessInfoRepository;
import com.talenco.tasksystem.domain.TaskProcessInfo;
import com.talenco.tasksystem.service.TaskProcessInfoService;
import com.talenco.tasksystem.util.TemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TaskProcessInfoServiceImpl implements TaskProcessInfoService {
    @Autowired
    private TaskProcessInfoRepository taskProcessInfoRepository;

    @Override
    public Optional<TaskProcessInfo> getTaskProcessInfoById(String id) {
        return taskProcessInfoRepository.findById(id);
    }

    @Override
    public List<TaskProcessInfo> getAllTaskProcessInfoByTask(String task) {
        return taskProcessInfoRepository.findAllByTask(task);
    }

    @Override
    public boolean addTaskProcessInfo(TaskProcessInfo taskProcessInfo) {
        return TemplateUtils.falseAndLogIfException(log, () -> {
            if (StringUtils.isBlank(taskProcessInfo.getTask())) {
                return false;
            }
            taskProcessInfo.setId(null);
            taskProcessInfoRepository.save(taskProcessInfo);
            return true;
        });
    }

    @Override
    public boolean setTaskProcessInfo(TaskProcessInfo taskProcessInfo) {
        // todo 设置taskProcessInfo
        return false;
    }

    @Override
    public boolean removeTaskProcessInfoById(String id) {
        return TemplateUtils.falseAndLogIfException(log, () -> {
            taskProcessInfoRepository.deleteById(id);
            return true;
        });
    }
}
