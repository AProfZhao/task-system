package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.UserDescRepository;
import com.talenco.tasksystem.dao.UserKeyRepository;
import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户服务类
 *
 * @author echcz
 * @date 2019-04-16 23:44:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserKeyRepository userKeyRepository;
    @Autowired
    private UserDescRepository userDescRepository;

    @Override
    public Optional<UserDesc> findUserDescById(String id) {
        return userDescRepository.findById(id);
    }
}
