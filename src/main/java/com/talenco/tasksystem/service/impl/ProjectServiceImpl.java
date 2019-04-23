package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.ProjectRepository;
import com.talenco.tasksystem.domain.Module;
import com.talenco.tasksystem.domain.Project;
import com.talenco.tasksystem.service.ProjectService;
import com.talenco.tasksystem.util.TemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Optional<Project> getPureProjectById(String id) {
        // todo 查询纯粹的project
        return Optional.empty();
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAllPureProject() {
        // todo 查询纯粹的project
        return null;
    }

    @Override
    public Map<String, Module> getModulesById(String id) {
        // todo 查询project.modules
        return null;
    }

    @Override
    public Module getModuleByIdAndName(String id, String name) {
        // todo 查询project.module
        return null;
    }

    @Override
    public boolean addPureProject(Project project) {
        return TemplateUtils.falseAndLogIfException(log, () -> {
            project.setId(null);
            HashMap<String, Module> modules = new HashMap<>();
            project.setModules(modules);
            projectRepository.save(project);
            return true;
        });
    }

    @Override
    public boolean setPureProject(Project project) {
        // todo 设置纯粹的project
        return false;
    }

    @Override
    public boolean removeProjectById(String id) {
        projectRepository.deleteById(id);
        // todo 递归删除任务及任务处理信息
        return false;
    }

    @Override
    public boolean addModule(String id, String name, Module module) {
        // todo 添加module
        return false;
    }

    @Override
    public boolean setModule(String id, String name, Module module) {
        // todo 设置module
        return false;
    }

    @Override
    public boolean removeModuleByIdAndName(String id, String name) {
        // todo 删除module
        return false;
    }
}
