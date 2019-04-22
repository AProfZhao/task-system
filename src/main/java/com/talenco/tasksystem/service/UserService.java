package com.talenco.tasksystem.service;

import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.domain.UserKey;

import java.util.List;
import java.util.Optional;

/**
 * 用户服务类接口
 *
 * @author echcz
 * @date 2019-04-16 23:49:47
 */
public interface UserService {
    /**
     * 根据UserKey.id获取用户登录信息
     * @param id UserKey.id
     * @return 用户登录信息
     */
    Optional<UserKey> getUserKeyById(String id);

    /**
     * 根据UserKey.username获取用户登录信息
     * @param username UserKey.username
     * @return 用户登录信息
     */
    Optional<UserKey> getUserKeyByUsername(String username);

    /**
     * 获取所有用户登录信息
     * @return 用户登录信息列表
     */
    List<UserKey> getAllUserKey();

    /**
     * 获取所有用户登录信息，除了admin的
     * @return 用户登录信息列表
     */
    List<UserKey> getAllUserKeyButAdmin();

    /**
     * 添加用户登录信息
     * @param userKey 用户登录信息
     */
    boolean addUserKey(UserKey userKey);

    /**
     * 设置用户登录信息根据userKey.id
     * 空值或无效字段将被忽略
     * @param userKey 用户登录信息，userKey.id应有效
     */
    boolean setUserKey(UserKey userKey);

    /**
     * 删除用户登录信息根据UserKey.id
     * @param id UserKey.id
     */
    boolean removeUserKeyById(String id);

    /**
     * 根据UserDesc.id获取用户描述信息
     * @param id UserDesc.id
     * @return 用户描述信息
     */
    Optional<UserDesc> getUserDescById(String id);

    /**
     * 设置用户描述信息根据userDesc.id
     * 空值或无效字段将被忽略
     * @param userDesc 用户描述信息，userDesc.id应有效
     */
    boolean setUserDesc(UserDesc userDesc);

    /**
     * 删除用户描述信息根据UserDesc.id
     * @param id UserDesc.id
     */
    boolean removeUserDescById(String id);
}
