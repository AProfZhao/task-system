package com.talenco.tasksystem.service;

import com.talenco.tasksystem.domain.UserDesc;

import java.util.Optional;

/**
 * 用户服务类接口
 *
 * @author echcz
 * @date 2019-04-16 23:49:47
 */
public interface UserService {
    /**
     * 根据UserDesc.id获取用户描述信息
     * @param id UserDesc.id
     * @return 用户描述信息
     */
    Optional<UserDesc> findUserDescById(String id);
}
