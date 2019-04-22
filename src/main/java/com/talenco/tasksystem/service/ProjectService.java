package com.talenco.tasksystem.service;

import com.talenco.tasksystem.domain.Module;
import com.talenco.tasksystem.domain.Project;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 项目(包含模块)服务类接口
 *
 * @author echcz
 * @date 2019-04-22 13:56:21
 */
public interface ProjectService {
    /**
     * 根据Project.id获取项目信息
     * @param id Project.id
     * @return 项目信息
     */
    Optional<Project> getProjectById(String id);

    /**
     * 根据Project.id获取纯粹的项目信息
     * 此信息不包含拥有的模块信息
     * @param id Project.id
     * @return 纯粹的项目信息
     */
    Optional<Project> getPureProjectById(String id);

    /**
     * 获取所有的项目信息
     * @return 项目信息列表
     */
    List<Project> getAllProject();

    /**
     * 获取所有的纯粹的信息信息
     * 此信息不包含拥有的模块信息
     * @return 纯粹的项目信息
     */
    List<Project> getAllPureProject();

    /**
     * 根据Project.id获取拥有的模块信息
     * @param id Project.id
     * @return 拥有的模块信息
     */
    Map<String, Module> getModulesById(String id);

    /**
     * 根据Project.id与模块名获取拥有的模块信息
     * @param id Project.id
     * @param name 模块名
     * @return 模块信息
     */
    Module getModuleByIdAndName(String id, String name);

    /**
     * 添加纯粹的项目信息
     * 项目的模块信息将被消除
     */
    boolean addPureProject(Project project);

    /**
     * 设置纯粹的项目信息
     * 项目的模块信息将被忽略
     * 空值或无效值将被忽略
     * @param project
     */
    boolean setPureProject(Project project);

    /**
     * 根据Project.id删除项目
     * 这将递归删除拥有的模块及任务及处理信息
     * @param id Project.id
     */
    boolean removeProjectById(String id);

    /**
     * 添加名为name的模块信息到Project.id指向的项目
     * @param id Project.id
     * @param name 模块名
     */
    boolean addModule(String id, String name, Module module);

    /**
     * 更改Project.id指向的项目下名为name的模块信息
     * @param id Project.id
     * @param name 模块名
     * @param module 模块信息
     */
    boolean setModule(String id, String name, Module module);

    /**
     * 根据Project.id与模块名删除项目
     * 这将递归删除拥有的任务及处理信息
     * @param id Project.id
     * @param name 模块名
     */
    boolean removeModuleByIdAndName(String id, String name);
}
