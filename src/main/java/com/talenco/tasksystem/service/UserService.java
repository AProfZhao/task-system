package com.talenco.tasksystem.service;

import com.talenco.tasksystem.dao.UserDescDao;
import com.talenco.tasksystem.dao.UserKeyDao;
import com.talenco.tasksystem.domain.UserDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserKeyDao userKeyDao;
    @Autowired
    private UserDescDao userDescDao;

    public Optional<UserDesc> findUserDescById(String id) {
        return userDescDao.findById(id);
    }
}
